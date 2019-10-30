package com.springdemo.action;

/**
 * @program: javademo
 * @description:
 * @author: wang gang
 * @create: 2019-08-09 10:01
 */
public class HelloWorld {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("name:" + name);
    }

}