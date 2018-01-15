package com.springboot.start.jdbc;


import com.springboot.start.jdbc.service.User;
import com.springboot.start.jdbc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ApplicationTests {

    @Autowired
    private UserService userService;


    @Test
    public void testAdd() {
        User user = new User();
        user.setName("binecy");
        user.setAge(12);

        userService.add(user);
    }
}
