package com.netease.basecomponent.mvp.v;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netease.basecomponent.mvp.p.IPresenter;

import butterknife.ButterKnife;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public abstract class BaseMVPFragment<P extends IPresenter> extends Fragment implements IView {

    private P mPresenter;

    /**
     * 基类的变量
     */
    protected boolean isFragmentHidden = false;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.onAttachView();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter.onDetachView();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(view);
        return view;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isFragmentHidden = hidden;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onInitViews();
        onSetViewListeners();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onUIReady();
    }

    /**
     * 调用Activity的Loading，防止Loading重复
     */
    @Override
    public void showLoading() { // 调用Activity的Loading，防止Loading重复
        ((IView) getActivity()).showLoading();
    }

    @Override
    public void dismissLoading() {
        ((IView) getActivity()).dismissLoading();
    }


    /**
     * 手动创建 p 层的实例， 这里没有引入 Dagger2 依赖注入框架, 后期可以优化
     * @return
     */
    protected abstract P createPresenter();


}
