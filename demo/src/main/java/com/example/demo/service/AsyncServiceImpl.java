package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @program: demo
 * @description: 异步服务实现类
 * @author: wang gang
 * @create: 2019-03-07 17:03
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static Random random = new Random();

    @Async
    @Override
    public Future<String> doTask1() throws Exception {
        System.out.println("任务一开始执行");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.out.println("任务一结束：" + (end - start));
        return new AsyncResult<>("任务一结束");
    }
    @Async
    @Override
    public Future<String> doTask2() throws Exception {
        System.out.println("任务二开始执行");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.out.println("任务二结束：" + (end - start));
        return new AsyncResult<>("任务二结束");
    }
    @Async
    @Override
    public Future<String> doTask3() throws Exception {
        System.out.println("任务三开始执行");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.out.println("任务三结束：" + (end - start));
        return new AsyncResult<>("任务三结束");
    }
}