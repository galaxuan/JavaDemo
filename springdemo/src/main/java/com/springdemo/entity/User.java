package com.springdemo.entity;

import java.util.Set;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-08-15 18:30
 */
public class User {
    private Integer id;

    private String userName;

    private Set<GoodsCart> goodsCarts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<GoodsCart> getGoodsCarts() {
        return goodsCarts;
    }

    public void setGoodsCarts(Set<GoodsCart> goodsCarts) {
        this.goodsCarts = goodsCarts;
    }
}