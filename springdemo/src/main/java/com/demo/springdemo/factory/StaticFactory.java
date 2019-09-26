package com.demo.springdemo.factory;

import com.demo.springdemo.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-09-25 14:59
 */
public class StaticFactory {
    private static Map<String, UserService> maps = new HashMap<String, UserService>();

    static {
        UserService user1 = new UserService();
        user1.setName("buyer");

        UserService user2 = new UserService();
        user2.setName("seller");

        maps.put("u1", user1);
        maps.put("u2", user2);
    }

    public static UserService getUserService(String key) {
        return maps.get(key);
    }
}