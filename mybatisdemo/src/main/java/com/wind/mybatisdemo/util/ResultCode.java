package com.wind.mybatisdemo.util;

/**
 * @Author 王志学
 * @Data 2017/11/9
 */
public enum ResultCode {
    SUCCESS("100"),//成功
    FAIL("400"),//失败
    UNAUTHORIZED("401"),//未认证（签名错误）
    NOT_FOUND("404"),//接口不存在
    INTERNAL_SERVER_ERROR("500"),//服务器内部错误
    ParameterError("300"),
    LIMITER("600");//限流启动

    ResultCode(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
