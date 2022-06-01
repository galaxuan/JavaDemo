package com.wind.mybatisdemo;

import com.wind.mybatisdemo.bean.MySelect.Entity.MySelectEntity;
import com.wind.mybatisdemo.mapper.MySelectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

public class mybatisdemoApplicationTest {

    @Test
    public void testMyBatis() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        MySelectMapper mapper = sqlSession.getMapper(MySelectMapper.class);

        mapper.addSelect(new MySelectEntity());

        sqlSession.commit();

    }
}