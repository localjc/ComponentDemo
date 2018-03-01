package com.netease.basecomponent.mvp.v;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.netease.basecomponent.mvp.p.IPresenter;

import butterknife.ButterKnife;

/**
 * 基础的MVP, 主要是做基本的框架绑定， 没有涉及到业务逻辑
 *
 * Created by jiangcheng on 2018/2/28.
 */

public abstract class BaseMVPActivity<P extends IPresenter> extends AppCompatActivity implements IView {

    /**
     * P 层实例
     */
    private P mPresenter;

    /**
     * loading 加载
     */
    private ILoading mLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlePreViewCreate(savedInstanceState);
        handleWindow();
        setContentView(getLayoutResId());

        // 注册ButterKnife的bind
        ButterKnife.bind(this);

        onInitViews();
        onSetViewListeners();
        onUIReady();
    }



    /**
     * 手动创建 p 层的实例， 这里没有引入 Dagger2 依赖注入框架, 后期可以优化
     * @return
     */
    protected abstract P createPresenter();

    /**
     * 创建加载的
     * @return
     */
    protected abstract ILoading createLoading();

    /**
     * 子类可以 用这个方法来处理window 层的一些事
     * 包括 虚拟键盘的一些操作
     * 因为大部分页面 不需要处理，所以没有将该方法做成接口
     */
    protected void handleWindow() {
        // 移除window上的背景,优化过渡绘制
        getWindow().setBackgroundDrawable(null);
    }


    /**
     * 这个是用来绑定 presenter 层的
     *
     * @param savedInstanceState
     */
    protected void handlePreViewCreate(Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.onAttachView();
            mPresenter.onInitArguments(savedInstanceState);
        }
    }

    @Override
    public void showLoading() {
        if (mLoading == null) {
            mLoading = createLoading();
        }
        if (mLoading != null) {
            mLoading.showLoading();
        }
    }


    @Override
    public void dismissLoading() {
        if (mLoading != null) {
            mLoading.hideLoading();
        }
    }

    @Override
    public FragmentActivity getActivity() {
        return this;
    }


    public P getPresenter() {
        return this.mPresenter;
    }


    /**
     * 提供一个判断 当前view是否销毁的方法
     *
     * @return
     */
    public boolean isViewDestroyed() {
        boolean destroy = isFinishing();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            destroy = destroy || isDestroyed();
        }
        return destroy;
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDetachView();
        }
        super.onDestroy();
    }
}
