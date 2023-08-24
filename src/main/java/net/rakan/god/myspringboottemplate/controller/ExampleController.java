package net.rakan.god.myspringboottemplate.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import net.rakan.god.myspringboottemplate.common.config.SentinelRuleConfig;
import net.rakan.god.myspringboottemplate.common.handler.SentinelDegradeHandler;
import net.rakan.god.myspringboottemplate.common.handler.SentinelFlowHandler;
import net.rakan.god.myspringboottemplate.common.service.KafkaProducerService;
import net.rakan.god.myspringboottemplate.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.concurrent.atomic.AtomicLong;

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


    @Value("${kafka.topic-name.create-alarm-info}")
    String myTopic;
    @Value("${kafka.topic-name.create-alarm-info2}")
    String myTopic2;

    @Autowired
    private KafkaProducerService kafkaProducerService;
    private AtomicLong atomicLong = new AtomicLong();


    @GetMapping("/test")
    public void sendMessageToKafkaTopic(String name) {
        for (int i = 0; i < 10; i++) {
            kafkaProducerService.sendMessage(myTopic, name + i);

        }
//        this.producer.sendMessage(myTopic2, new Book(atomicLong.addAndGet(1), name));
        System.out.println();
    }

}
