package com.dubbo.client;

import com.dubbo.start.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bin on 2017/2/28.
 */
public class DubboClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new
                ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-client.xml"});
        ctx.start();

        HelloService service = (HelloService) ctx.getBean("helloService");

        System.out.println(service.hello("bin"));
    }
}
