package com.netease.basecomponent.mvp.m;

import com.netease.basecomponent.business.entity.IData;
import com.netease.basecomponent.business.entity.IResponse;

/**
 * Created by jiangcheng on 2018/3/1.
 */

public interface IModelCallback<T extends IData> {

    void showLoading();

    void dismissLoading();

    /**
     * 请求成功，有数据的那种
     * @param response
     */
    void onSuccess(T response);

    /**
     * 请求失败
     */
    void onFail(Throwable throwable, String msg);

    /**
     * 异常code码处理  404 500
     */
    void onAbnormal(int errorCode, String errorMsg);

    /**
     * 请求成功但是没有数据
     */
    void onNoResponseData();
}
