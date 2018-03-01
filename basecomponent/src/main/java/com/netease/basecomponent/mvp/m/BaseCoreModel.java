package com.netease.basecomponent.mvp.m;

import android.content.Context;

import java.util.function.Consumer;

/**
 * 基础的
 *
 * Created by jiangcheng on 2018/2/28.
 */

public class BaseCoreModel<L extends IModelCallback> implements IModel<L> {

    protected Context mContext;

    /**
     * M回调P层处理
     */
    protected L mModelCallback;

    @Override
    public void setModelCallback(L modelCallback) {
        this.mModelCallback = modelCallback;
    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }
}
