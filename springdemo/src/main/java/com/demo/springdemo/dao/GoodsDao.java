package com.demo.springdemo.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-09-26 16:11
 */
@Repository
public class GoodsDao {
     public void findGoods()
     {
         System.out.println("GoodsDao.findGoods()");
     }
}