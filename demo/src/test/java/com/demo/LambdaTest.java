package com.demo;

import com.demo.entity.Person;
import com.demo.entity.Student;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@SpringBootTest
public class LambdaTest {

    public void Test() {
        File f = new File(".");
        File[] files0 = f.listFiles((File file, String name) -> {
            if (name.endsWith(".txt")) {
                return true;
            }
            return false;
        });

        File[] files1 = f.listFiles((File file, String name) -> {
            return name.endsWith(".txt");
        });

        File[] files2 = f.listFiles((file, name) -> name.endsWith(".txt"));
    }

    List<Person> peoples = Arrays.asList(
            new Person(1, "张学友", 23, 5000),
            new Person(2, "刘德华", 24, 5000),
            new Person(3, "郭富城", 22, 4000),
            new Person(4, "黎明", 28, 6000)
    );

    List<Student> students = Arrays.asList(new Student[]{
            new Student("zhangsan", "1", 91d),
            new Student("lisi", "2", 89d),
            new Student("wangwu", "1", 50d),
            new Student("zhaoliu", "2", 78d),
            new Student("sunqi", "1", 59d)});

    @Test
    public void test0() {
        peoples.stream().filter(s -> s.getSalary() > 4000).forEach(System.out::println);
        List<Integer> list = peoples.stream().filter(s -> s.getSalary() > 3000).map(s -> s.getSalary()).collect(Collectors.toList());
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
     * Consumer<T> 消费型接口
     */
    @Test
    public void test4() {
        ha(10000, s -> System.out.println("赚了" + s + "元"));
    }

    private void ha(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * Supplier<T> 供给型接口
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
     * Function<T, R> 函数型接口
     */
    @Test
    public void test6() {
        String str = strHandler("\t\t\t 中国人牛逼！", s -> s.trim());
        System.out.println(str);
    }

    private String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * Predicate<T> 断言型接口
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList("hello", "fang", "ok", "test");

        List<String> filterList = filterStr(list, s -> s.length() > 3);

        for (String s : filterList) {
            System.out.println(s);
        }

    }

    private List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> stringList = new ArrayList<>();

        for (String str : list) {
            if (predicate.test(str)) {
                stringList.add(str);
            }
        }

        return stringList;
    }

    @Test
    public void test8() {
        peoples.sort(Comparator.comparing(Person::getSalary).reversed().thenComparing(Person::getName));

        for (Person people : peoples) {
            System.out.println(people.getName());
        }
    }

    @Test
    public void test9() {
        //按年级分组
        Map<String, List<Student>> groups = students.stream().collect(Collectors.groupingBy(Student::getGrade));

        System.out.println(groups);

        //统计每个年级的学生数
        Map<String, Long> gradeCountMap = students.stream().collect(groupingBy(Student::getGrade, counting()));

        System.out.println(gradeCountMap);

        //统计一个单词流中每个单词的个数，按出现顺序排序
        Map<String, Long> wordCountMap = Stream.of("hello", "world", "abc", "hello")
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));

        System.out.println(wordCountMap);

        //获取每个年级最高分的一个学生
        Map<String, Optional<Student>> topStudentMap = students.stream()
                .collect(groupingBy(Student::getGrade, maxBy(Comparator.comparing(Student::getScore))));

        Map<String, Student> topStudentMap2 = students.stream()
                .collect(groupingBy(Student::getGrade, collectingAndThen(maxBy(Comparator.comparing(Student::getScore)), Optional::get)));

        System.out.println(topStudentMap2);

        //按年级统计学生分数信息
        Map<String, DoubleSummaryStatistics> gradeScoreStat = students.stream()
                .collect(groupingBy(Student::getGrade, summarizingDouble(Student::getScore)));

        System.out.println(gradeScoreStat);

        //分组内的map
        Map<String, List<String>> gradeNameMap = students.stream()
                .collect(groupingBy(Student::getGrade, mapping(Student::getName, toList())));

        System.out.println(gradeNameMap);
    }
}