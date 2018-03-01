package com.netease.basecomponent.mvp.p;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public interface IPresenter {

    /**
     * 将presenter层和view层绑定
     */
    void onAttachView();

    /**
     * 页面中的数据传递, 放在p层来处理
     *
     * @param savedInstanceState
     */
    void onInitArguments(@Nullable Bundle savedInstanceState);

    /**
     * 将presenter层和view层解绑
     * 可以做一些资源的释放
     */
    void onDetachView();
}
