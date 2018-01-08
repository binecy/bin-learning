package com.springboot.start.amqp;


import com.springboot.start.User;
import com.springboot.start.jdbc.UserService;
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
        sender.send();
    }

    @Test
    public void hello2() throws Exception {
        sender.send2();
    }

}
