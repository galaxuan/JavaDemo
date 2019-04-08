package com.example.demo.service;

import java.util.concurrent.Future;

/**
 * @program: demo
 * @description: 异步服务
 * @author: wang gang
 * @create: 2019-03-07 16:51
 */
public interface AsyncService {
    Future<String> doTask1() throws Exception;
    Future<String> doTask2() throws Exception;
    Future<String> doTask3() throws Exception;
}