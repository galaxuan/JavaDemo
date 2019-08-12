package com.demo.springdemo.service;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @program: javademo
 * @description:
 * @author: wang gang
 * @create: 2019-08-09 14:45
 */
public class UserService {

    public String name;

    public Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserService() {
        System.out.println("new UserService");
    }

    public UserService(String name, Integer age) {
        System.out.println("new UserService(String name, Integer age)");
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("name:" + name);
        System.out.println("age:" + age);
    }

    public void findUser() {
        System.out.println("findUser....UserService");
    }
}