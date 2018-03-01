package com.netease.basecomponent.business.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.netease.basecomponent.mvp.p.IPresenter;
import com.netease.basecomponent.mvp.v.BaseMVPFragment;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public abstract class BaseFragment<P extends IPresenter> extends BaseMVPFragment<P> {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 统计、出入栈 等业务可以在这里做

    }
}
