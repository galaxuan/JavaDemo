package com.wind.mybatisdemo.util;

public class ResultGenerator<T> {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static ResultGenerator singleton;

    private ResultGenerator() {
    }

    public static ResultGenerator getSingleton() {
        if (singleton == null) {
            singleton = new ResultGenerator();
        }
        return singleton;
    }

    public Result<String> genSuccessResult() {
        return new Result<String>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData("");
    }

    //    public static Result<Object> genSuccessResult(Object data) {
//        return new Result<Object>()
//                .setCode(ResultCode.SUCCESS.getCode())
//                .setMessage(DEFAULT_SUCCESS_MESSAGE)
//                .setData(data);
//    }
    public Result<T> genSuccessResult(T data) {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public Result<T> genFailResult() {
        return new Result<T>()
                .setCode(ResultCode.FAIL.getCode())
                .setMessage("错误")
                .setData(null);
    }

    public Result<Integer> genSuccessResult(Integer data) {
        return new Result<Integer>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public Result<String> genFailResult(String message) {
        return new Result<String>()
                .setCode(ResultCode.FAIL.getCode())
                .setMessage(message)
                .setData("");
    }

    public Result<Object> getLimitResult() {
        return new Result<Object>()
                .setCode(ResultCode.LIMITER.getCode())
                .setMessage(ResultCode.LIMITER.toString())
                .setData(null);
    }

    public Result<T> getLimitResult(T object) {
        return new Result<T>()
                .setCode(ResultCode.LIMITER.getCode())
                .setMessage(ResultCode.LIMITER.toString())
                .setData(object);
    }
}
