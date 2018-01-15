package com.springboot.start.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by bin on 2017/3/1.
 */
@Component
public class MessageHandler {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public MessageHandler(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @KafkaListener(topics = "springboot_kafka")
    public void processMessage(String content) {
        System.out.println("get message :  " + content);
    }


    public void sendMessage(String content) {
        kafkaTemplate.send("springboot_kafka", content);
    }
}
