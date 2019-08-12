package com.demo.springdemo;

import com.demo.springdemo.dao.IUserDao;
import com.demo.springdemo.userservice.UserServiceFactory1;
import com.demo.springdemo.userservice.UserServiceFactory2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: wang gang
 * @date: 2019-5-21
 */
public class App {
    public static void main(String[] args) {

        //IUserDao userdao = new UserDaoImpl();
        //userdao.add();

        //ApplicationContext context1 = new ClassPathXmlApplicationContext("beans.xml");
        //ApplicationContext context2 = new FileSystemXmlApplicationContext("D:\\Java\\javademo\\springdemo\\src\\main\\resources\\beans.xml");

        //new 对象
        //IUserDao userService1 = (IUserDao) context1.getBean("userService1");
        //userService1.add();

        //静态工厂
        //IUserDao userService2 = UserServiceFactory1.createUserService();
        //IUserDao userService2 = (IUserDao) context1.getBean("userService2");
        //userService2.add();

        //实例工厂
        //1.创建工厂
        //UserServiceFactory2 factory2 = new UserServiceFactory2();
        //IUserDao userService3 = factory2.createUserService();

        //IUserDao userService3 = (IUserDao) context1.getBean("userService3");
        //userService3.add();

        //AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.demo.springdemo.dao");
        //UserDaoImpl daoImpl=applicationContext.getBean("UserDaoImpl",UserDaoImpl.class);
        //System.out.println(daoImpl);
        //applicationContext.close();

        System.out.println("1");
    }
}
