package com.spring.start.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseHandler {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        // * 基本4项
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_start");
        dataSource.setUsername("root");
        dataSource.setPassword("bin");

        //2  创建模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        //3 通过api操作
        jdbcTemplate.update("insert into t_user(username,password) values(?,?);", "tom","998");

    }
}
