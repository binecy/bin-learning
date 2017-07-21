package com.disconf.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by liangguobin on 2017/7/13.
 */
public class RedisTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("application.xml");
        SimpleRedisService service = (SimpleRedisService)beanFactory.getBean("simpleRedisService");

        System.out.println(service.getKey("com.disconf.start"));

    }
}
