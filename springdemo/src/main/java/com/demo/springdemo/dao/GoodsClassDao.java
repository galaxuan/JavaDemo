package com.demo.springdemo.dao;

import com.demo.springdemo.entity.GoodsClass;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class GoodsClassDao extends BaseDao<GoodsClass> {

    @Override
    public List<GoodsClass> findPages() {
        GoodsClass goodsClass = new GoodsClass();
        List<GoodsClass> list = new ArrayList<>();
        list.add(goodsClass);
        return list;
    }
}