package com.mybatis.start;

import com.mybatis.start.service.BlogService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bin on 2017/2/28.
 */
public class ServiceTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:mybatis-spring.xml"});

        BlogService service = ctx.getBean("blogService", BlogService.class);
        System.out.println(service.selectBlog(1));

    }
}
