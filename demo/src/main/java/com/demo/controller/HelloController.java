package com.demo.controller;

import com.demo.config.AppConfig;
import com.demo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * HelloController class
 *
 * @author 王刚
 * @date 2018/2/1
 * // @EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class}) //关闭自动配置
 */
@RestController
public class HelloController {

    @Autowired
    private AsyncService asyncService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Value("${book.author}")
    private String auther;

    //@Value("${book.name}")
    private String name;

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Resource //相同功能可使用@Autowire
    private AppConfig appconfig;

    //@RequestMapping(value = "/hello")
    //@RequestMapping(value = "/hello")
    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    //@GetMapping("/hello")

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/show")
    @ResponseBody
    public String show() {

        //return auther + ":" + name;
        return appconfig.getName();
    }

    @RequestMapping("/async")
    public String asyncTest() throws Exception {
        Long start = System.currentTimeMillis();
        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }

        }
        Thread.sleep(1000);

        Long end = System.currentTimeMillis();

        return String.valueOf(end - start);
    }
}
