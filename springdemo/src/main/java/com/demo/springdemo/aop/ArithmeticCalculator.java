package com.demo.springdemo.aop;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-10-18 09:46
 */
public class ArithmeticCalculator {

    public Integer add(int a, int b) {
        System.out.println("新增开始，传入参数：a=" + a + ",b=" + b);
        int c = a + b;
        System.out.println("新增结束，值：c=" + c);
        return c;
    }
}