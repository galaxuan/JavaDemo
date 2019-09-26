package com.demo.springdemo.action;

import com.demo.springdemo.service.GoodsService;
import com.demo.springdemo.utils.CommUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-09-26 16:17
 */
@Controller
public class GoodsAction {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CommUtil commUtil;

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public void findGoods() {
        System.out.println("GoodsAction.findGoods()");
        goodsService.findGoods();

        System.out.println(commUtil.format(new Date()));
    }
}