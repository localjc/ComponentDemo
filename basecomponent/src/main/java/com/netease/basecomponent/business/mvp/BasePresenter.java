package com.netease.basecomponent.business.mvp;

import com.netease.basecomponent.business.entity.BaseResponse;
import com.netease.basecomponent.business.entity.IData;
import com.netease.basecomponent.mvp.m.BaseCoreModel;
import com.netease.basecomponent.mvp.m.IModelCallback;
import com.netease.basecomponent.mvp.p.BaseMVPPresenter;
import com.netease.basecomponent.mvp.v.IView;

/**
 * 含有业务的presenter层， 比如显示loading 和统一的错误处理
 *
 * Created by jiangcheng on 2018/3/1.
 */

public abstract class BasePresenter<V extends IView, M extends BaseCoreModel, T extends IData>
        extends BaseMVPPresenter<V, M> implements IModelCallback<T> {

    /**
     * 之所以需要传递这两个参数，是因为创建P层 地方在V中，所以将V 传入到P层
     * 并将V 层的类型传入
     *
     * @param view
     * @param isFragment
     */
    public BasePresenter(V view, boolean isFragment) {
        super(view, isFragment);
    }


    @Override
    public void onAttachView() {
        super.onAttachView();
        if (mModel != null) {
            mModel.setModelCallback(this);
            /**
             * 解决 model 需要context 实例的问题
             *
             * 这里写的有点尴尬， 后期再优化
             */
            if (mView != null) {
                mModel.setContext(mView.getActivity());
            }
        }
    }

    @Override
    public void onDetachView() {
        if (mModel != null) {
            mModel.releaseResource();
        }
        super.onDetachView();
    }

    @Override
    public void showLoading() {
        if (mView != null) {
            mView.showLoading();
        }
    }

    @Override
    public void dismissLoading() {
        if (mView != null) {
            mView.dismissLoading();
        }
    }

    @Override
    public void onAbnormal(int errorCode, String errorMsg) {
        // 这里做一些异常 code码的统一处理  建议使用 错误连接桥
    }
}
