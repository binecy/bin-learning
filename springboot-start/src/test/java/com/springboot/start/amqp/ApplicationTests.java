package com.springboot.start.amqp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ApplicationTests {


    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Test
    public void hello() throws Exception {
        for(int i = 0; i < 30; i++) {
            sender.send();
            Thread.sleep(1000 * 3);
        }
    }

    @Test
    public void hello2() throws Exception {
        sender.send2();

        Thread.sleep(1000 * 1000);
    }


    @Test
    public void testTopic() throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            sender.sendToTopic();
            Thread.sleep(1000);
        }
    }



    @Test
    public void receiver() throws InterruptedException {
        Thread.sleep(1000 * 1000);
    }

    @Test
    public void testFanout() {
        sender.sentToFanout();
    }

}
