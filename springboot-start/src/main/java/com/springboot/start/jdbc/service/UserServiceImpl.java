package com.springboot.start.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(User user) {
        jdbcTemplate.update("insert into t_user(username, age) values(?, ?)", user.getName(), user.getAge());
    }
}
