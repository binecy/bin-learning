package com.spring.start.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application_jdbc.xml" })
public class BaseInsert {

    @Autowired
    BasicDataSource dataSource;

    @Test
    public void testInsert() {
        //2  创建模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        //3 通过api操作
        jdbcTemplate.update("insert into t_user(username,password) values(?,?);", "binecy","0891");
    }

}
