package com.springdemo.action;

import com.springdemo.service.UserService;

/**
 * @param
 * @author wanggang
 * @return
 * @date 2019-8-20
 */
public class LoginAction {
    private UserService userService;

    private String username;

    private Object initValue;

    public LoginAction() {
        System.out.println(userService);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getInitValue() {
        return initValue;
    }

    public void setInitValue(Object initValue) {
        this.initValue = initValue;
    }

    public void doLogin() {
        userService.findUser();
    }
}