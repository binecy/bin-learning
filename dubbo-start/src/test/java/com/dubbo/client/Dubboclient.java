package com.dubbo.client;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.dubbo.start.service.CallbackListener;
import com.dubbo.start.service.CallbackService;
import com.dubbo.start.service.HelloService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:dubbo-client.xml" })
public class Dubboclient {

    @Autowired
    private HelloService helloService;

    @Autowired
    private CallbackService callbackService;


    @Test
    public void testHello() {
        helloService.hello("binecy");
    }

    @Test
    public void testEcho() {
        EchoService echoService = (EchoService) helloService; // 强制转型为EchoService
        Assert.assertEquals(echoService.$echo("ok"), "ok");
    }


    @Test
    public void testSny() throws ExecutionException, InterruptedException {
        Assert.assertNull(helloService.hello2("binecy"));
        Future<String> hello2Future = RpcContext.getContext().getFuture();
        Assert.assertEquals(hello2Future.get(), "hello2:binecy");
    }

    @Test
    public void testCallback() throws InterruptedException {
        callbackService.addListener("hello", new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });

        Thread.currentThread().sleep(1000 * 30);

    }
}
