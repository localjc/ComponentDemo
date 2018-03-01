package com.netease.basecomponent.mvp.v;

import android.support.v4.app.FragmentActivity;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public interface IView {

    /**
     *
     * @return
     */
    FragmentActivity getActivity();

    /**
     * 布局ID
     * @return
     */
    int getLayoutResId();


    /**
     * 显示Loading
     */
    void showLoading();

    /**
     * 隐藏Loading
     */
    void dismissLoading();

    /**
     * 一些view的初始化 操作
     */
    void onInitViews();

    /**
     * 设置View的监听器
     */
    void onSetViewListeners();

    /**
     * Ui加载完成，可以去发送请求了
     */
    void onUIReady();


}
