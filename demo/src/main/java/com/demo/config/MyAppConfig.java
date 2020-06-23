package com.demo.config;

import com.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @param
 * @author wang gang
 * @return
 * @date 2020-3-25
 */
@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService() {
        System.out.println("添加组件");
        return new HelloService();
    }
}