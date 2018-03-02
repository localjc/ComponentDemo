package com.netease.basecomponent.business.exceptions;

/**
 * 业务请求成功(200)后数据为空异常
 */
public class NullDataException extends RuntimeException {
    public NullDataException(String desc) {
        super(desc);
    }
}