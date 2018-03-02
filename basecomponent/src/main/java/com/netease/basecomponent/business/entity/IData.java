package com.netease.basecomponent.business.entity;

/**
 * data实体 必须要继承这个接口
 *
 * Created by jiangcheng on 2018/3/1.
 */

public interface IData {
    /**
     * 若需要在请求成功(200)时用到服务器返回的msg的话,实现该方法,不需要就别管
     */
    void setMsg(String msg);

    String getMsg();
}
