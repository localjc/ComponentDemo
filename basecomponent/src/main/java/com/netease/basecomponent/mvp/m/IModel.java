package com.netease.basecomponent.mvp.m;

import android.content.Context;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public interface IModel<L extends IModelCallback> {

    /**
     * 设置Model的回调
     *
     * @param modelCallback
     */
    void setModelCallback(L modelCallback);

    /**
     * 在model 层注入context
     *
     * @param context
     */
    void setContext(Context context);

    /**
     * 释放一些资源
     */
    void releaseResource();

    /**
     *
     * rxjava观察者和被观察者，
     *
     * @param observable
     * @param onNext
     * @param onError
     * @return
     */
//    Disposable toSubscribe(Observable observable, Consumer onNext, Consumer<Throwable> onError);
}
