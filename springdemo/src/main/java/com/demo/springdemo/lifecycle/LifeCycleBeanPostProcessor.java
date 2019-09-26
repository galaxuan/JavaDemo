package com.demo.springdemo.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-09-25 11:16
 */
public class LifeCycleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("LifeCycleBeanPostProcessor.postProcessBeforeInitialization");

        String str = "helloWorld";

        if (str.equals(beanName)) {
            System.out.println("数据源读操作");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("LifeCycleBeanPostProcessor.postProcessAfterInitialization");
        String str = "helloWorld";

        if (str.equals(beanName)) {
            System.out.println("数据源写操作");
        }
        return bean;
    }
}