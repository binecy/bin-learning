package com.elklog.start;

import com.elklog.start.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void getGetUser() {
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("application.xml");
        UserController controller = beanFactory.getBean("userController", UserController.class);
        System.out.println(controller.getUser("111"));
        System.out.println(controller.getUser("111"));
        System.out.println(controller.getUser("111"));
    }
}
