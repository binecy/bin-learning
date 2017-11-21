package com.elklog.start.controller;

import com.elklog.start.domain.User;
import com.elklog.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public User getUser(String code) {
        return userService.getUser(code);
    }
}
