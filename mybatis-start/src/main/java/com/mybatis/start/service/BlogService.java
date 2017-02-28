package com.mybatis.start.service;

import com.mybatis.start.domain.Blog;
import com.mybatis.start.mapper.BlogMapper;

import java.util.List;

/**
 * Created by bin on 2017/2/28.
 */
public class BlogService {
    private BlogMapper blogMapper;

    public Blog selectBlog(long id) {
        System.out.println("mapper : " + blogMapper);
        return blogMapper.selectBlog(id);
    }

    public BlogMapper getBlogMapper() {
        return blogMapper;
    }

    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    public List<Blog> selectOn(List<Long> ids) {
        return blogMapper.selectOn(ids);
    }
}
