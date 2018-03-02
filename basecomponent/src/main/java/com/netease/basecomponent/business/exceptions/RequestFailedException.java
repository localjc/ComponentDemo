package com.netease.basecomponent.business.exceptions;

/**
 * 业务请求返回码非200异常
 */
public class RequestFailedException extends RuntimeException {
    private int code;
    private String msg;

    public RequestFailedException(String desc, int code, String msg) {
        super(desc);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}