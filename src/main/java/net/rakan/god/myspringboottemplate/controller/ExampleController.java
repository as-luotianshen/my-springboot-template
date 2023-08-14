package net.rakan.god.myspringboottemplate.controller;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import net.rakan.god.myspringboottemplate.common.config.SentinelRuleConfig;
import net.rakan.god.myspringboottemplate.common.handler.SentinelDegradeHandler;
import net.rakan.god.myspringboottemplate.common.handler.SentinelFlowHandler;
import net.rakan.god.myspringboottemplate.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {


    /**
     * 测试sentinel流控
     *
     * @Author LiChangRui on 2023/8/1 15:01
     */
    @SentinelResource(value = SentinelRuleConfig.RESOURCE_NAME
            , blockHandlerClass = SentinelFlowHandler.class
            , blockHandler = "resourceName")
    @GetMapping("/create")
    public Result create() {
        System.out.println("创建成功");
        return Result.ok();
    }

    /**
     * 测试sentinel熔断
     *
     * @Author LiChangRui on 2023/8/2 10:07
     */
    @SentinelResource(value = SentinelRuleConfig.DEGRADE_RESOURCE_NAME
            , blockHandlerClass = SentinelDegradeHandler.class
            , blockHandler = "blockHandlerForFb")
    @GetMapping("/cancel")
    public Result cancel() {
        throw new RuntimeException();
//        return Result.ok();
    }
}
