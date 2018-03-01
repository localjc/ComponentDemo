package com.netease.basecomponent.business.entity;

/**
 * Created by jiangcheng on 2018/3/1.
 */

public interface IResponse {

    /**
     * 是否请求成功
     * @return
     */
    boolean isSuccess();

    int getCode();

    String getMsg();

    /**
     * 是否有数据
     *
     * @return
     */
    boolean hasData();
}
