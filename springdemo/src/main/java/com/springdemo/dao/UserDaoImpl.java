package com.springdemo.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: javademo
 * @description:
 * @author: wang gang
 * @create: 2019-05-17 18:11
 */

@Repository
public class UserDaoImpl implements IUserDao {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add() {
        System.out.println("添加用户" + name);
    }
}