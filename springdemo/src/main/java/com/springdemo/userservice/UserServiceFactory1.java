package com.springdemo.userservice;

import com.springdemo.dao.IUserDao;
import com.springdemo.dao.UserDaoImpl;

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
