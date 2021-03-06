package com.springdemo.service;

import com.springdemo.dao.UserDao;

/**
 * @program: javademo
 * @description:
 * @author: wang gang
 * @create: 2019-08-09 14:45
 */
public class UserService {

    private String name;

    private Integer age;

    private String type;

    private UserDao userDao;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
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

    public void save() {
        System.out.println("UserService.save()....");
        userDao.save();
    }

    public void findUser() {
        System.out.println("findUser....UserService");
    }

    public void initMethod()
    {
        System.out.println("UserService.initMethod");
    }

    public void closeMethod()
    {
        System.out.println("UserService.closeMethod");
    }
}