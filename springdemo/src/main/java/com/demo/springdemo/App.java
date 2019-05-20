package com.demo.springdemo;

import com.demo.springdemo.dao.UserDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.demo.springdemo");

        UserDaoImpl daoImpl=applicationContext.getBean("UserDaoImpl",UserDaoImpl.class);

        System.out.println(daoImpl);
        applicationContext.close();
    }
}
