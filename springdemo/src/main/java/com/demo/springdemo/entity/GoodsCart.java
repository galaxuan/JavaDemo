package com.demo.springdemo.entity;

import java.util.List;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-08-13 22:19
 */
public class GoodsCart {

    private Integer id;

    private List<Goods> goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}