package com.spring.start.rabbit;

import org.springframework.amqp.core.AmqpTemplate;

public class Producer {


    private AmqpTemplate mqTemplate;

    public void sendHello() {
        Notice m = new Notice(System.currentTimeMillis(), "hello");

        mqTemplate.convertAndSend("helloQueue", m);

        System.out.println("send message over");
    }

    public AmqpTemplate getMqTemplate() {
        return mqTemplate;
    }

    public void setMqTemplate(AmqpTemplate mqTemplate) {

        this.mqTemplate = mqTemplate;
    }
}
