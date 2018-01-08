package com.springboot.start.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "hello")
public class Receiver {

//    @RabbitHandler
    public void receiveMessage(String hello) {
        System.out.println("Receiver : " + hello);
    }
}
