package com.springdemo.action;

import com.springdemo.dao.BaseDao;
import com.springdemo.entity.GoodsClass;
import com.springdemo.service.BaseService;
import com.springdemo.service.OrderFormService;
import com.springdemo.utils.CommUtil;
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