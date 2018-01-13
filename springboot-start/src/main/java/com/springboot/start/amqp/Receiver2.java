package com.springboot.start.amqp;

import org.springframework.stereotype.Component;

@Component
public class Receiver2 {

    public void receiveMessage(String hello) {
        System.out.println("Receiver2 : " + hello);
    }
}
