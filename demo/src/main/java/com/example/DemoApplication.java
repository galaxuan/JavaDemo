package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * DemoApplication class
 *
 * @author 王刚
 * @date 2018/2/1
 */
@SpringBootApplication
@EnableAsync
@PropertySource("classpath:config.properties")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}

