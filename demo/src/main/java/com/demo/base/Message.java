package com.demo.base;


import java.io.Serializable;


/**
 * 消息类
 *
 * @return code 错误码  message 错误信息
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 643138095986273286L;

    /**
     * 返回消息的具体内容
     */
    private String message;

    /**
     * 返回的消息码
     */
    private String code;

    public Message() {
    }

    public Message(ErrorCode error) {

        this.message = error.getMessage();
        this.code = error.getCode();
    }

    public Message(ErrorCode error, String mes) {
        this.message = error.getMessage() + " ; " + mes;
        this.code = error.getCode();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
