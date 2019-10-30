package com.springdemo;

import com.springdemo.action.GoodsAction;
import com.springdemo.action.HelloWorld;
import com.springdemo.action.LoginAction;
import com.springdemo.entity.Goods;
import com.springdemo.entity.GoodsCart;
import com.springdemo.entity.User;
import com.springdemo.service.UserService;
import com.springdemo.utils.DataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.junit.Assert.assertTrue;

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
        HelloWorld helloWorld = (HelloWorld) cxt.getBean("HelloWorld");
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
        UserService userService = (UserService) cxt.getBean("userService2");
        //执行对象的方法
        userService.print();
    }

    /**
     * @Description: 操作特殊字符
     * @Param:
     * @return:
     * @Author: wanggang
     * @date: 2019-8-12
     */
    @Test
    public void testSpecialCharacter() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        HelloWorld helloWorld = (HelloWorld) cxt.getBean("specialCharacter");
        //执行对象的方法
        helloWorld.hello();
    }

    @Test
    public void testInnerBean() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        UserService userService = (UserService) cxt.getBean("userServiceInnerBean");
        //执行对象的方法
        userService.save();
    }


    @Test
    public void testUserSericeCascade() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        UserService userService = (UserService) cxt.getBean("userSericeCascade");
        //执行对象的方法
        userService.getUserDao().save();
    }

    /**
     * List集合
     */
    @Test
    public void testGoodsCartList() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        GoodsCart goodsCart = (GoodsCart) cxt.getBean("goodsCartList");
        //执行对象的方法
        List<Goods> list = goodsCart.getGoods();

        for (Goods g : list) {
            System.out.println(g.getGoodsName());
        }
    }

    /**
     * Set集合
     */
    @Test
    public void testUserSet() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        User user = (User) cxt.getBean("userSet");
        //执行对象的方法
        Set<GoodsCart> goodsCarts = user.getGoodsCarts();

        for (GoodsCart goodsCart : goodsCarts) {
            for (Goods g : goodsCart.getGoods()) {
                System.out.println(g.getGoodsName());
            }

        }
    }

    /**
     * Map集合
     */
    @Test
    public void testGoodsMap() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        Goods goods = (Goods) cxt.getBean("goodsMap");
        //执行对象的方法
        Map<String, Object> map = goods.getSkus();

        for (String key : map.keySet()) {
            System.out.println("key:" + key + " value:" + map.get(key));
        }
    }

    /**
     * Map集合
     */
    @Test
    public void testDataSource() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        DataSource dataSource = (DataSource) cxt.getBean("dataSource");
        //执行对象的方法
        Properties config = dataSource.getConfig();

        for (Object key : config.keySet()) {
            System.out.println(config.get(key));
        }
    }


    /**
     * util集合
     */
    @Test
    public void testUtilList() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        List<String> list = (List) cxt.getBean("utilList");
        //执行对象的方法
        for (String key : list) {
            System.out.println(key);
        }
    }

    /**
     * p标签
     */
    @Test
    public void testUserP() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        User user = (User) cxt.getBean("userP");
        //执行对象的方法
        System.out.println(user.getUserName());
    }

    @Test
    public void testAtuowire() {

        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-autowire.xml");
        //获得Spring上下文环境的对象
        LoginAction loginAction = cxt.getBean(LoginAction.class);
        //执行对象的方法
        loginAction.doLogin();
    }

    @Test
    public void testExtends() {

        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-extends.xml");
        //获得Spring上下文环境的对象
        UserService userService = (UserService) cxt.getBean("userServiceChild");
        //执行对象的方法
        System.out.println(userService.getAge());
        System.out.println(userService.getName());
        System.out.println(userService.getType());
    }

    @Test
    public void testHelloWorldBean() {

        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得Spring上下文环境的对象
        HelloWorld helloWorld1 = (HelloWorld) cxt.getBean("HelloWorldBean");

        HelloWorld helloWorld2 = (HelloWorld) cxt.getBean("HelloWorldBean");
        //执行对象的方法

        System.out.println(helloWorld1);

        System.out.println(helloWorld2);
    }

    @Test
    public void testDataSourceProperties() {

        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext-datasource.xml");
        //获得Spring上下文环境的对象
        javax.sql.DataSource dataSource = (javax.sql.DataSource) cxt.getBean("dataSource");
        //执行对象的方法
        System.out.println(dataSource);
    }


    @Test
    public void testSpEL() {

        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext-SpEL.xml");
        //获得Spring上下文环境的对象
        LoginAction loginAction = cxt.getBean(LoginAction.class);
        //执行对象的方法
        loginAction.doLogin();
        System.out.println(loginAction.getUsername());
    }

    @Test
    public void testBeanlifecycle() {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext-bean-life-cycle.xml");
        //获得Spring上下文环境的对象

        //执行对象的方法
        cxt.close();
    }

    @Test
    public void testStaticFactory() {

        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("bean-factory.xml");

        //获得Spring上下文环境的对象
        UserService userService = (UserService) cxt.getBean("staticFactory");

        //执行对象的方法
        System.out.println(userService.getName());

        userService = (UserService) cxt.getBean("instanceFactory");

        System.out.println(userService.getName());
    }

    @Test
    public void testSpringScan()
    {
        //初始化配置文件：Spring加载配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext-scan.xml");

        //获得Spring上下文环境的对象
        GoodsAction goodsAction =cxt.getBean(GoodsAction.class);

        //执行对象的方法
        goodsAction.findGoods();
    }
}
