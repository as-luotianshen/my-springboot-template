package net.rakan.god.myspringboottemplate.common.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * sentinel规则配置
 *
 * @Author LiChangRui on 2023/8/1 14:16
 */
@Component
public class SentinelRuleConfig {

    public static final String RESOURCE_NAME = "default";
    public static final String DEGRADE_RESOURCE_NAME = "degrade";

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    /**
     * 定义流控规则
     *
     * @Author LiChangRui on 2023/8/1 14:20
     */
    @PostConstruct
    private static void initFlowRules() {
        // 流控规则
        List<FlowRule> rules = new ArrayList<>();
        // 通过@SentinelResource来定义资源并配置降级和流控的处理方法
        FlowRule rule2 = new FlowRule();
        // 设置受保护的资源
        rule2.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值
        // Set limit QPS to 20.
        rule2.setCount(1);

        rules.add(rule2);

        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 流控规则
     *
     * @Author LiChangRui on 2023/8/2 10:03
     */
    @PostConstruct
    public void initDegradeRule() {
        // 降级规则
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(DEGRADE_RESOURCE_NAME);
        // 设置规则策略： 异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        // 触发熔断异常数 ： 2
        degradeRule.setCount(2);
        // 触发熔断最小请求数:2
        degradeRule.setMinRequestAmount(2);
        // 统计时长：  单位：ms    1分钟（时间太短不好测）
        degradeRule.setStatIntervalMs(60 * 1000);

        // 一分钟内： 执行了2次  出现了2次异常  就会触发熔断

        // 熔断持续时长 ： 单位 秒
        // 一旦触发了熔断， 再次请求对应的接口就会直接调用  降级方法。
        // 10秒过了后进行半开状态： 恢复接口请求调用， 如果第一次请求就异常， 再次熔断，不会根据设置的条件进行判定
        degradeRule.setTimeWindow(10);

        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules(degradeRules);

        /*
        慢调用比率--DEGRADE_GRADE_RT
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        degradeRule.setCount(100);
        degradeRule.setTimeWindow(10);
        //请求总数小于minRequestAmount时不做熔断处理
        degradeRule.setMinRequestAmount(2);
        // 在这个时间段内2次请求
        degradeRule.setStatIntervalMs(60*1000*60);   //  时间太短不好测
        // 慢请求率：慢请求数/总请求数> SlowRatioThreshold ，
        // 这里要设置小于1   因为慢请求数/总请求数 永远不会大于1
        degradeRule.setSlowRatioThreshold(0.9);*/

    }
}
