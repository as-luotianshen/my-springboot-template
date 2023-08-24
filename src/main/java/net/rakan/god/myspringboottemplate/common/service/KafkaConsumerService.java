package net.rakan.god.myspringboottemplate.common.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Value("${kafka.topic-name.create-alarm-info}")
    private String myTopic;
    @Value("${kafka.topic-name.create-alarm-info2}")
    private String myTopic2;
    private final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = {"${kafka.topic-name.create-alarm-info}"}, groupId = "${kafka.topic-name.create-alarm-info}")
    public void consumeMessage(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第一个消费者");
    }

    @KafkaListener(topics = {"${kafka.topic-name.create-alarm-info}"}, groupId = "${kafka.topic-name.create-alarm-info}")
    public void consumeMessage2(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第二个消费者");
    }

    @KafkaListener(topics = {"${kafka.topic-name.create-alarm-info}"}, groupId = "${kafka.topic-name.create-alarm-info}")
    public void consumeMessage3(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第三个消费者");
    }

    @KafkaListener(topics = {"${kafka.topic-name.create-alarm-info}"}, groupId = "${kafka.topic-name.create-alarm-info}")
    public void consumeMessage4(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第四个消费者");
    }

    @KafkaListener(topics = {"${kafka.topic-name.create-alarm-info}"}, groupId = "${kafka.topic-name.create-alarm-info}")
    public void consumeMessage5(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第五个消费者");
    }


}
