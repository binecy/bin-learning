package com.mybatis.start.mapper;

import com.mybatis.start.domain.Blog;

import java.util.List;

/**
 * Created by bin on 2017/2/28.
 */
public interface BlogMapper {
    Blog selectBlog(long id);

    List<Blog> selectOn(List<Long> list);
}
