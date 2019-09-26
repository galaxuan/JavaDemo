package com.demo.springdemo.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-09-26 15:44
 */
@Component
public class CommUtil {

    public String format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(date);
    }
}