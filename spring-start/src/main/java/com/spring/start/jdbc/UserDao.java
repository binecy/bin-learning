package com.spring.start.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserDao {

    @Autowired
    BasicDataSource dataSource;


    public void insert(User user) {
        //2  创建模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        //3 通过api操作
        jdbcTemplate.update("insert into t_user(username,password) values(?,?);", user.getUsername(),user.getPassword());
    }


    @Transactional
    public void insert2(User user) {
        //2  创建模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        //3 通过api操作
        jdbcTemplate.update("insert into t_user(username,password) values(?,?);", user.getUsername(),user.getPassword());

        jdbcTemplate.update("insert into t_user(id, username,password) values(?,?);", 3, user.getUsername(),user.getPassword());
    }
}
