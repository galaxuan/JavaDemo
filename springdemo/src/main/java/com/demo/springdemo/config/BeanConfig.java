package com.demo.springdemo.config;

import com.demo.springdemo.dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: javademo
 * @description:
 * @author: wang gang
 * @create: 2019-05-20 15:06
 */

@Configuration
public class BeanConfig {

    @Bean("UserDao")
    public UserDaoImpl dao() {
        return new UserDaoImpl();
    }
}