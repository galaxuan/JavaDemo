package com.demo.springdemo.service;

import com.demo.springdemo.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-09-26 16:12
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void findGoods() {
        System.out.println("GoodsService.findGoods()");
        goodsDao.findGoods();
    }
}