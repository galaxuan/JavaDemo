package com.demo.springdemo.action;

import com.demo.springdemo.service.UserService;

/**
 * @program: javademo
 * @description:
 * @author: wang gang
 * @create: 2019-08-09 14:49
 */
public class LoginAction {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void doLogin() {
        userService.findUser();
    }
}