package com.springdemo.dao;

/**
 * @program: javademo
 * @description:
 * @author: wang gang
 * @create: 2019-08-12 20:27
 */
public class UserDao {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save() {
        System.out.println("UserDao.save()...");
        System.out.println("password:" + password);
    }
}