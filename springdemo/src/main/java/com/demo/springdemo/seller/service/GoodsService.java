package com.demo.springdemo.seller.service;

import com.demo.springdemo.dao.GoodsDao;
import com.demo.springdemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-10-09 17:10
 */
@Service("sellerGoodsService")
public class GoodsService implements BaseService {
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