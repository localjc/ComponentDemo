package com.netease.basecomponent.mvp.p;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.netease.basecomponent.mvp.m.BaseCoreModel;
import com.netease.basecomponent.mvp.v.IView;

/**
 * 基础的逻辑处理层，负责处理M、V层的桥接
 *
 * Created by jiangcheng on 2018/2/28.
 */

public abstract class BaseMVPPresenter<V extends IView, M extends BaseCoreModel> implements IPresenter {

    /**
     * V 层实例，后期可以考虑Dagger2
     */
    protected V mView;

    /**
     * M 层实例
     */
    protected M mModel;


    /**
     * 传递的bundle数据
     */
    protected Bundle mBundle;

    /**
     * 是否是fragment, 以便在P层 做不同的处理
     */
    protected  boolean isFragment;

    /**
     * 之所以需要传递这两个参数，是因为创建P层 地方在V中，所以将V 传入到P层
     * 并将V 层的类型传入
     * @param view
     * @param isFragment
     */
    public BaseMVPPresenter(V view, boolean isFragment) {
        this.mView = view;
        this.isFragment = isFragment;
        this.mModel = createModel();
    }


    @Override
    public void onAttachView() {

    }

    @Override
    public void onInitArguments(@Nullable Bundle bundle) {
       this.mBundle = bundle;
    }


    /**
     * 释放资源，防止内存泄露
     */
    @Override
    public void onDetachView() {
        mView = null;
        mModel = null;
    }

    /**
     * 创建M 层实例
     *
     * @return
     */
    public abstract M createModel();

}
