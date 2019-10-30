package com.demo.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.demo.springbootmybatis.mapper")
public class SpringbootmybatisApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringbootmybatisApplication.class, args);

        String s1=String.format("中华%s共和国,%s","人民","您好");
        System.out.println(s1);
        String s2=String.format("中华%1$s共和国,%2$s","人民","您好");
        System.out.println(s2);

        /*
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootmybatisApplication.class, args);

        DataSource dataSource = context.getBean(DataSource.class);

        System.out.println("dataSource:" + dataSource);
        System.out.println("=====================");
        EmpMapper mapper = context.getBean(EmpMapper.class);

        Emp emp = mapper.findById(7566);
        System.out.println("emp:" + emp);

        context.close();
        */
    }
}
