package com.netease.basecomponent.business.entity;

import java.io.Serializable;

/**
 * 基础的response 类
 * Created by jiangcheng on 2018/3/1.
 */

public abstract class BaseResponse<T extends IData> implements Serializable, IResponse {

    private static final long serialVersionUID = 7645717566023532013L;

    public static final int CODE_SUCCESS = 200;

    private int code;

    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean isSuccess() {
        return getCode() == CODE_SUCCESS;
    }

}
