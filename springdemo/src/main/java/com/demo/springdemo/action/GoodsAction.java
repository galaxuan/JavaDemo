package com.demo.springdemo.action;

import com.demo.springdemo.dao.BaseDao;
import com.demo.springdemo.entity.GoodsClass;
import com.demo.springdemo.service.BaseService;
import com.demo.springdemo.service.GoodsCartService;
import com.demo.springdemo.service.OrderFormService;
import com.demo.springdemo.utils.CommUtil;
import com.sun.istack.internal.Interned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
    @Qualifier("adminGoodsService")
    private BaseService goodsService;

    @Resource
    private OrderFormService orderFormService;

    @Autowired
    private BaseDao<GoodsClass> goodClassService;

    @Autowired
    private CommUtil commUtil;

    public void findGoods() {
        System.out.println("GoodsAction.findGoods()");
        goodsService.findGoods();

        System.out.println(commUtil.format(new Date()));

        System.out.println(orderFormService);

        System.out.println(goodClassService);
    }
}