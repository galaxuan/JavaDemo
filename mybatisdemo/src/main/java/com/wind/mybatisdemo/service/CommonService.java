package com.wind.mybatisdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.function.Function;


@Service
public class CommonService {

    @Async
    public <T, R> Future<R> Async(Function<T, R> function, T param) {
        return new AsyncResult<R>(function.apply(param));
    }
}
