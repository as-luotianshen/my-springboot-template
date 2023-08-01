package net.rakan.god.myspringboottemplate.common.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
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
@Configuration
public class SentinelRuleConfig {

    public static final String RESOURCE_NAME = "default";

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    /**
     * 定义规则
     *
     * @Author LiChangRui on 2023/8/1 14:20
     */
    @PostConstruct
    private static void initFlowRules() {
        // 流控规则
        List<FlowRule> rules = new ArrayList<>();

//        // 流控
//        FlowRule rule = new FlowRule();
//        // 为哪个资源进行流控
//        rule.setResource(RESOURCE_NAME);
//        // 设置流控规则 QPS
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        // 设置受保护的资源阈值
//        // Set limit QPS to 20.
//        rule.setCount(1);
//        rules.add(rule);

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
}
