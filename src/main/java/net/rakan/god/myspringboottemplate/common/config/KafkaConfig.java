package net.rakan.god.myspringboottemplate.common.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * 公共配置
 *
 * @Author LiChangRui on 2023/8/17 20:13
 */
@Configuration
public class KafkaConfig {

    @Value("${kafka.topic-name.create-alarm-info}")
    private String myTopic;
//    @Value("${kafka.topic-name.create-alarm-info2}")
//    private String myTopic2;

    /**
     * JSON消息转换器
     *
     * @Author LiChangRui on 2023/8/18 12:13
     */
    @Bean
    public RecordMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

    /**
     * 通过注入一个 NewTopic 类型的 Bean 来创建 topic，如果 topic 已存在，则会忽略。
     *
     * @Author LiChangRui on 2023/8/17 20:26
     */
    @Bean
    public NewTopic myTopic() {
        return new NewTopic(myTopic, 4, (short) 1);
    }

//    @Bean
//    public NewTopic myTopic2() {
//        return new NewTopic(myTopic2, 1, (short) 1);
//    }
}
