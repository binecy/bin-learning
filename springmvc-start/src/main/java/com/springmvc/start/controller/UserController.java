package com.springmvc.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bin on 2018/1/13.
 * your-project$ gradle jettyRun
 * 访问http://localhost:9191/spring4/?name=bin
 * 参考：https://www.mkyong.com/spring-mvc/gradle-spring-mvc-web-project-example/
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody  User user) {
        System.out.println("add user : " + user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("hello");
        return user;
    }
}
