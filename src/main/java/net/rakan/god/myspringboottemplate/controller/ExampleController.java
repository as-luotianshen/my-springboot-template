package net.rakan.god.myspringboottemplate.controller;

import net.rakan.god.myspringboottemplate.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/create")
    public Result create() {

        System.out.println("创建成功");
        return Result.ok();
    }
}
