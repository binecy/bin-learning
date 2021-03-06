package com.springboot.start.kafka;



import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ApplicationTests {
    @Autowired
    private MessageHandler messageHandler;


    @Test
    public void testListener() throws Exception {
        while (true) {  // 保持进程，以接收消息
            Thread.sleep(1000 * 10);
        }
    }

    @Test
    public void testSend() {
        messageHandler.sendMessage("hello, springboot_kafka");
    }
}
