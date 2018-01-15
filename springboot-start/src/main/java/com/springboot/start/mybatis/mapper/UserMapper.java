package com.springboot.start.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by bin on 2017/2/28.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user WHERE username = #{name}")
    User findByName(@Param("name") String name);


    @Insert("INSERT INTO t_user(username, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
