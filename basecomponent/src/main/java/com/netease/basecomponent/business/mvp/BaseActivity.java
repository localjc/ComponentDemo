package com.netease.basecomponent.business.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.netease.basecomponent.mvp.p.IPresenter;
import com.netease.basecomponent.mvp.v.BaseMVPActivity;

/**
 * 与业务相关的基层Activity, 不影响底层MVP层框架
 *
 * Created by jiangcheng on 2018/2/28.
 */

public abstract class BaseActivity<P extends IPresenter> extends BaseMVPActivity<P> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 统计、出入栈 等业务可以在这里做

    }



}
