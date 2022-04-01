package com.wind.mybatisdemo.util;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Result<E> implements Serializable {
    @ApiModelProperty(value = "错误码 100成功其他为失败", required = true)
    private String code;
    @ApiModelProperty(value = "消息提示",required = true)
    private String message;
    @ApiModelProperty(value = "返回数据",required = true)
    private E data;

    public String getCode() {
        return code;
    }

    public Result<E> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<E> setMessage(String message) {
        this.message = message;
        return this;
    }

    public E getData() {
        return data;
    }

    public Result<E> setData(E data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess(){
        return code.equals(ResultCode.SUCCESS.getCode());
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
