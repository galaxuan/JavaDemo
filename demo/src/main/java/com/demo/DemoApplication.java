package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAsync
@PropertySource("classpath:config.properties")
public class DemoApplication {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("guan");
        list.add("bao");

        list.stream().filter(s -> s.contains("a")).limit(2).forEach(System.out::println);

        SpringApplication.run(DemoApplication.class, args);
    }
}

