package com.dubbo.start.service;

/**
 * Created by bin on 2017/2/28.
 */
public class HelloServiceImpl implements HelloService  {
    @Override
    public String hello(String user) {
        System.out.println(" user : " + user + " say hello !");
        return "time : " + System.currentTimeMillis() + " , hello ! " + user;

    }

    @Override
    public String hello2(String user) {
        return "hello2:" + user;
    }
}
