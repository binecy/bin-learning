package com.mybatis.start;

import com.mybatis.start.domain.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bin on 2017/2/28.
 */
public class MapperTest {

    @Test
    public void  testSelectOne() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = session.selectOne("com.mybatis.start.mapper.BlogMapper.selectBlog", 1);

            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    @Test
    public void testSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {

            List<Long> longs = new ArrayList<Long>();
            longs.add(1L);
            Blog blog = session.selectOne("com.mybatis.start.mapper.BlogMapper.selectOn", longs);

            System.out.println(blog);
        } finally {
            session.close();
        }
    }

}
