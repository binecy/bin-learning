package com.spring.start.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class Consumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("get message : " + new String(message.getBody()));
    }
}
