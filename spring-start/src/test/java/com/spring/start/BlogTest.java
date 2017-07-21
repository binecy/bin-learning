package com.spring.start;

import com.spring.start.bean.Blog;
import com.spring.start.bean.IBlog;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by liangguobin on 2017/7/3.
 */
public class BlogTest {

    @Test
    public void test() {
        BeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
        Blog bean = (Blog)xmlBeanFactory.getBean("blog");

        Assert.assertEquals(bean.getTitle(), "hello spring");
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("application.xml");
        Blog bean = (Blog)beanFactory.getBean("blog");
        Assert.assertEquals(bean.getTitle(), "hello spring");
    }

    @Test
    public void test3() {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("application.xml");
        IBlog blog = (IBlog)beanFactory.getBean("blog");
        System.out.println(blog.getTitle());
    }
}
