package net.rakan.god.myspringboottemplate.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import net.rakan.god.myspringboottemplate.common.config.SentinelRuleConfig;
import net.rakan.god.myspringboottemplate.common.handler.SentinelFlowHandler;
import net.rakan.god.myspringboottemplate.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {


    @SentinelResource(value = SentinelRuleConfig.RESOURCE_NAME
            , blockHandlerClass = SentinelFlowHandler.class
            , blockHandler = "resourceName")
    @GetMapping("/create")
    public Result create() {
        System.out.println("创建成功");
        return Result.ok();
    }
}
