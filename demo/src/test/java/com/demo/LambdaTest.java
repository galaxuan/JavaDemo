package com.demo;

import com.demo.entity.Person;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class LambdaTest {

    List<Person> peoples = Arrays.asList(
            new Person(1, "张学友", 23, 5000),
            new Person(2, "刘德华", 25, 5000),
            new Person(3, "郭富城", 23, 4000),
            new Person(4, "黎明", 28, 6000)
            );

    @Test
    public void test1() {
        peoples.stream().filter(s -> s.getSalary() > 4000).forEach(System.out::println);
    }
}