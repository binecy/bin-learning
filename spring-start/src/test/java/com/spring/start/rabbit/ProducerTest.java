package com.spring.start.rabbit;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProducerTest {

    @Test
    public void test() throws InterruptedException {
        BeanFactory xmlBeanFactory = new ClassPathXmlApplicationContext("application_rabbit.xml");
        Producer producer = xmlBeanFactory.getBean("producer", Producer.class);

        producer.sendHello();

        Thread.sleep(1000 * 3);
    }
}
