package com.demo.springdemo.entity;

import java.util.Map;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-08-13 22:11
 */
public class Goods {

    private Integer id;

    private String goodsName;

    private String goodsPrice;

    private Map<String, Object> skus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Map<String, Object> getSkus() {
        return skus;
    }

    public void setSkus(Map<String, Object> skus) {
        this.skus = skus;
    }
}