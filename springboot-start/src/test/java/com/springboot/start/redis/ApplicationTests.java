package com.springboot.start.redis;




import com.springboot.start.redis.service.CacheService;
import com.springboot.start.redis.service.User;
import com.springboot.start.redis.service.UserService;
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

    @Autowired
    private UserService userService;


    @Test
    public void testAdd() {
        cacheService.add("tip", "hello");
        Assert.assertEquals("hello", cacheService.get("tip"));
    }

    @Test
    public void testUser() {
        // 保存对象
        User user = new User(1L, "超人", 20);
        userService.add(user);

        User user2 = new User(2L, "蝙蝠侠", 30);
        userService.add(user2);

        User user3 = new User(3L, "蜘蛛侠", 40);
        userService.add(user3);


        System.out.println("user id 1 : " + userService.get(1L));
    }
}
