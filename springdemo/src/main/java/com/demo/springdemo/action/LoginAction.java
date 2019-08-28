package com.demo.springdemo.action;

import com.demo.springdemo.service.UserService;

/**
 * @param
 * @author wanggang
 * @return
 * @date 2019-8-20
 */
public class LoginAction {
    private UserService userService;

    public LoginAction() {
        System.out.println(userService);
    }

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