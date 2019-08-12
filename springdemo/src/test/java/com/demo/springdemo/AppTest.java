package com.demo.springdemo;

import static org.junit.Assert.assertTrue;

import com.demo.springdemo.action.HelloWorld;
import com.demo.springdemo.action.LoginAction;
import com.demo.springdemo.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testHello() {
        HelloWorld helloWord = new HelloWorld();
        helloWord.setName("Spring");
        helloWord.hello();
    }

    @Test
    public void testSpringHello() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        HelloWorld helloWorld = cxt.getBean(HelloWorld.class);
        //执行对象的方法
        helloWorld.hello();
    }

    @Test
    public void testSpringHelloByName() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        HelloWorld helloWorld = (HelloWorld)cxt.getBean("HelloWorld");
        //执行对象的方法
        helloWorld.hello();
    }

    @Test
    public void testLoginAction() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        LoginAction loginAction = cxt.getBean(LoginAction.class);
        //执行对象的方法
        loginAction.doLogin();
    }


    @Test
    public void testUserService2() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        UserService userService =(UserService)cxt.getBean("userService2");
        //执行对象的方法
        userService.print();
    }
}
