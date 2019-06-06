package com.demo.springdemo.userservice;

import com.demo.springdemo.dao.IUserDao;
import com.demo.springdemo.dao.UserDaoImpl;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: wanggang
 * @date: 2019-5-27
 */
public class UserServiceFactory1 {

    public static IUserDao createUserService() {
        return new UserDaoImpl();
    }
}
