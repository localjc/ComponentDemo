package com.netease.basecomponent.business.exceptions;

import com.netease.basecomponent.business.entity.IData;
import com.netease.basecomponent.mvp.m.IModelCallback;

import retrofit2.adapter.rxjava2.HttpException;

/**
 * 网络异常处理类
 * Created by 苏杭 on 2018/3/1 16:30.
 */

public class NetworkException<T extends IData> {
    private IModelCallback<T> mCallback;

    public void setCallback(IModelCallback<T> callback) {
        mCallback = callback;
    }

    public void doException(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException he = (HttpException) e;
            //TODO http异常(400/401等)
        } else if (e instanceof RequestFailedException) {
            RequestFailedException rfe = (RequestFailedException) e;
            if (mCallback != null) {
                mCallback.onAbnormal(rfe.getCode(), rfe.getMsg());
            }
        } else if (e instanceof NullDataException) {
            if (mCallback != null) {
                mCallback.onFail(e, "数据为空!");
            }
        } else {
            if (mCallback != null) {
                mCallback.onFail(e, "其他异常!");
            }
        }
    }
}