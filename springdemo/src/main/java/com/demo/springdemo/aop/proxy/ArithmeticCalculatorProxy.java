package com.demo.springdemo.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-10-18 14:07
 */
public class ArithmeticCalculatorProxy implements InvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "开始");

        for (Object arg : args) {
            System.out.println(arg);
        }

        Object object = method.invoke(target, args);

        System.out.println(method.getName() + "结束，结果：" + object);

        return object;
    }

    public Object createProxyObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}