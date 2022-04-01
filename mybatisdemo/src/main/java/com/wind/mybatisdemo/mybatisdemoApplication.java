package com.wind.mybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.wind.mybatisdemo.mapper")
@EnableAsync
public class mybatisdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.wind.mybatisdemo.mybatisdemoApplication.class, args);
    }

}
