package com.springmvc.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bin on 2018/1/13.
 * your-project$ gradle jettyRun
 * 访问http://localhost:8080/spring4/?name=bin
 * 参考：https://www.mkyong.com/spring-mvc/gradle-spring-mvc-web-project-example/
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String hello(String name) {
        if(name == null) {
            return "hello";
        }

        return "hello, " + name;
    }

}
