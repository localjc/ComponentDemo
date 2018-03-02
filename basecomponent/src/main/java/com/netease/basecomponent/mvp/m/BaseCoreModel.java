package com.netease.basecomponent.mvp.m;

import android.content.Context;

import com.netease.basecomponent.business.entity.BaseResponse;
import com.netease.basecomponent.business.entity.IData;
import com.netease.basecomponent.business.exceptions.NetworkException;
import com.netease.basecomponent.business.utils.NetworkManager;
import com.netease.basecomponent.business.utils.RxUtil;

import java.util.function.Consumer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 基础的
 *
 * Created by jiangcheng on 2018/2/28.
 */

public abstract class BaseCoreModel<L extends IModelCallback<T>, T extends IData> implements IModel<L>, Observer<T> {
    /**
     * rx资源回收管理
     */
    protected CompositeDisposable mDisposables = new CompositeDisposable();
    /**
     * 异常处理类
     */
    protected NetworkException<T> mNetworkException = new NetworkException<>();
    protected NetworkManager mNetworkManager = new NetworkManager();
    protected Context mContext;

    /**
     * M回调P层处理
     */
    protected L mModelCallback;

    @Override
    public void setModelCallback(L modelCallback) {
        this.mModelCallback = modelCallback;
        mNetworkException.setCallback(mModelCallback);
    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    /**
     * 在默认线程中处理网络请求
     * @param observable 由retrofit得到的结果
     */
    protected void subscribe(Observable<BaseResponse<T>> observable) {
        if (mModelCallback != null) {
            mModelCallback.showLoading();
        }
        observable.compose(RxUtil.<BaseResponse<T>>fixScheduler()).compose(RxUtil.<T>handleResult()).subscribe(this);
    }

    /**
     * 在指定线程中处理网络请求
     * @param observable 由retrofit得到的结果
     */
    protected void subscribe(Observable<BaseResponse<T>> observable, Scheduler scheduler) {
        observable.subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread()).compose(RxUtil.<T>handleResult()).subscribe(this);
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposables.add(d);
    }

    @Override
    public void onNext(T t) {
        if (mModelCallback != null) {
            mModelCallback.onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        mNetworkException.doException(e);
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void releaseResource() {
        mDisposables.dispose();
    }
}
