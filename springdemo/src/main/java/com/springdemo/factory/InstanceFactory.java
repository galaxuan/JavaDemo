package com.springdemo.factory;

import com.springdemo.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-09-26 14:50
 */
public class InstanceFactory {
    private Map<String, UserService> maps = new HashMap<String, UserService>();

    public InstanceFactory() {
        UserService user1 = new UserService();
        user1.setName("admin");

        UserService user2 = new UserService();
        user2.setName("h5");

        maps.put("u1", user1);
        maps.put("u2", user2);
    }

    public UserService getUserService(String key) {
        return maps.get(key);
    }
}