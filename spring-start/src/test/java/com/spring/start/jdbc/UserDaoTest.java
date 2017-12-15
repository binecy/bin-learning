package com.spring.start.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application_jdbc.xml" })
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("binecy");
        user.setPassword("0891");

        userDao.insert(user);
    }

    @Test
    public void test2() {
        User user = new User();
        user.setUsername("binecy");
        user.setPassword("0891");

        userDao.insert2(user);
    }
}
