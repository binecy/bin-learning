package com.javassist.start;

import javassist.*;
import org.junit.Test;

/**
 * Created by liangguobin on 2017/7/18.
 */
public class ToStringTest {

    @Test
    public void test() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {

        StringDesc<Blog> stringDesc = DynamicStringDesc.getStringDesc(Blog.class);
        Blog blog = new Blog();
        blog.setContent("hello");
        blog.setTitle("this is test...");

        stringDesc.setBean(blog);

        System.out.println(stringDesc);

    }



}
