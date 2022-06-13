package com.demo;

import com.demo.entity.Person;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootTest
public class LambdaTest {

    List<Person> peoples = Arrays.asList(
            new Person(1, "张学友", 23, 5000),
            new Person(2, "刘德华", 24, 5000),
            new Person(3, "郭富城", 22, 4000),
            new Person(4, "黎明", 28, 6000)
    );

    @Test
    public void test0() {
        peoples.stream().filter(s -> s.getSalary() > 4000).forEach(System.out::println);
    }

    @Test
    public void test1() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test3() {
        Collections.sort(peoples, (s1, s2) -> {
            if (s1.getAge() == s2.getAge()) {
                return s1.getName().compareTo(s2.getName());
            } else {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });

        for (Person per : peoples) {
            System.out.println(per);
        }
    }

    /**
     * Consumer<T> 消费性接口
     */
    @Test
    public void test4() {
        ha(10000, s -> System.out.println("赚了" + s + "元"));
    }

    private void ha(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * Supplier<T> 供给性接口
     */
    @Test
    public void test5() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        for (Integer i : numList) {
            System.out.println(i);
        }
    }

    private List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }

        return list;
    }

    /**
     * Function<T, R> 接口
     */
    @Test
    public void test6() {

    }
}




















