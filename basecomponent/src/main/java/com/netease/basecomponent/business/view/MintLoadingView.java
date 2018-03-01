package com.netease.basecomponent.business.view;

import com.netease.basecomponent.BaseApplication;
import com.netease.basecomponent.mvp.v.ILoading;
import com.netease.toolslibrary.utils.ToastUtils;

/**
 * Created by jiangcheng on 2018/3/1.
 */

public class MintLoadingView implements ILoading {



    @Override
    public void showLoading() {
        ToastUtils.showToastMsg(BaseApplication.getAppContext(), "显示loading");
    }

    @Override
    public void hideLoading() {
        ToastUtils.showToastMsg(BaseApplication.getAppContext(), "隐藏loading");
    }
}
