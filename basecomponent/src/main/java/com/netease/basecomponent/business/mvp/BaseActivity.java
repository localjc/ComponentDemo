package com.netease.basecomponent.business.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.netease.basecomponent.business.view.MintLoadingView;
import com.netease.basecomponent.mvp.p.IPresenter;
import com.netease.basecomponent.mvp.v.BaseMVPActivity;
import com.netease.basecomponent.mvp.v.ILoading;

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


    // 创建每个app的loading的 ,不同的页面可以重写
    @Override
    protected ILoading createLoading() {
        return new MintLoadingView();
    }

}
