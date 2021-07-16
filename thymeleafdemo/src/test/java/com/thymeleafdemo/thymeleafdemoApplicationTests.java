package com.thymeleafdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class thymeleafdemoApplicationTests {

    @Test
    void contextLoads() {
        Random rnd = new Random(20160824);
        for (int i = 0; i < 5; i++) {
            System.out.print(rnd.nextInt(100) + " ");
        }
    }
}
