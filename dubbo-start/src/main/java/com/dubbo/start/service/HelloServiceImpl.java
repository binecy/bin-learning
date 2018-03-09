package com.dubbo.start.service;

import ddd.SpringApplicationContext;

/**
 * Created by bin on 2017/2/28.
 */
public class HelloServiceImpl implements HelloService  {
    @Override
    public String hello(String user) {

        System.out.println(SpringApplicationContext.getBean("com.dubbo.start.service.HelloService").getClass().getName());
        System.out.println(" user : " + user + " say hello !");

//        if(true) {
//            throw new NullPointerException("ttt...");
//        }
        return "time : " + System.currentTimeMillis() + " , hello ! " + user;

    }

    @Override
    public String hello2(String user) {
        return "hello2:" + user;
    }
}
