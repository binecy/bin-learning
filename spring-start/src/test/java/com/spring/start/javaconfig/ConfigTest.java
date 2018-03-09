package com.spring.start.javaconfig;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

    @Test
    public void test() {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.spring.start.javaconfig");
        Piano p = annotationContext.getBean(Piano.class);
        Assert.assertEquals("666", p.getBrand()); //测试
    }
}
