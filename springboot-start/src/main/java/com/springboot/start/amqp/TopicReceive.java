package com.springboot.start.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceive {

    @RabbitListener(queues="topic.message")
    public void process(String obj) {
        System.out.println("receiver:topic.message:"+obj);
    }

    @RabbitListener(queues="topic.message2")
    public void process2(String obj) {
        System.out.println("receiver:topic.message2:"+obj);
    }

}
