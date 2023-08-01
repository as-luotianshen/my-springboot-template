package net.rakan.god.myspringboottemplate;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringbootTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootTemplateApplication.class, args);
        System.out.println("项目启动成功！");
    }

//    @Bean
//    public SentinelResourceAspect sentinelResourceAspect() {
//        return new SentinelResourceAspect();
//    }

}
