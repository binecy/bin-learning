package com.springboot.start.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive {

    @RabbitListener(queues="fanout-queue")
    public void process(String obj) {
        System.out.println("receiver:fanout.message:"+obj);
    }

    @RabbitListener(queues="fanout-queue2")
    public void process2(String obj) {
        System.out.println("receiver:fanout.message2:"+obj);
    }

}
