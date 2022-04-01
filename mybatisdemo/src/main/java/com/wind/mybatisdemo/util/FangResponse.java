package com.wind.mybatisdemo.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: myfangapi
 * @description: FangResponse
 * @author: wang gang
 * @create: 2020-11-18 18:19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FangResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int STATUS_SUCCESS = 200;
    private int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    private String message;
    private String redisKey;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            locale = "zh",
            timezone = "GMT+8"
    )
    private Date timestamp;
    private String time;

    public String getRedisKey() {
        return this.redisKey;
    }

    @JsonProperty("rediskey")
    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public FangResponse(int code, String message, Object data) {
        this.status = code;
        this.message = message;
        this.data = data;
    }

    public static FangResponse buildSuccess(Object data) {
        return new FangResponse(100, "success", data);
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return new Date();
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time + "ms";
    }
}