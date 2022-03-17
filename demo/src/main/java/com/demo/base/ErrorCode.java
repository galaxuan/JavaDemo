package com.demo.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ErrorCode {

    ERRORCODE_SUCCESS("100000", "请求成功"),

    ERRORCODE_HTTP_GET("900006", " http request get fails  "),

    ERRORCODE_HTTP_POST("900007", " http request post fails  "),

    ERRORCODE_USER_ERROR("900008", "用户不存在或者未审核通过"),

    ERRORCODE_USER_ROLE_LIMIT("900009", "由于账号处于新手期, 每天一篇的发文指标已用完, 可明日再添加"),

    ERRORCODE_PARAMS_INVALID("100001", "Invalid parames");

    public static final Logger logger = LoggerFactory.getLogger(ErrorCode.class);
    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static void main(String[] args) {
//    logger.info(JSON.toJSONString(new Message(ErrorCode.ERRORCODE_PARAM_AUTH)));

    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

