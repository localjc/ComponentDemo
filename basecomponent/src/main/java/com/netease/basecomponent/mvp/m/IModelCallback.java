package com.netease.basecomponent.mvp.m;

/**
 * Created by jiangcheng on 2018/3/1.
 */

public interface IModelCallback {

    void showLoading();

    void dismissLoading();

    /**
     * 请求成功，有数据的那种
     * @param data
     */
    void onSuccess(String data);

    /**
     * 请求失败
     */
    void onFail();

    /**
     * 异常code码处理  404 500
     */
    void onAbnormal(int errorCode, String errorMsg);

    /**
     * 请求成功但是没有数据
     */
    void onNoResponseData();
}
