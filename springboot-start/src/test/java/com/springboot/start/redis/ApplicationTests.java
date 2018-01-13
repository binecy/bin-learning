package com.springboot.start.redis;


import com.springboot.start.User;
import com.springboot.start.redis.Main;
import com.springboot.start.jdbc.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ApplicationTests {

    @Autowired
    private CacheService cacheService;


    @Test
    public void testAdd() {
        cacheService.add("tip", "hello");
        Assert.assertEquals("hello", cacheService.get("tip"));
    }
}
