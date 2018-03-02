package com.netease.basecomponent.business.utils;


import com.netease.basecomponent.business.entity.BaseResponse;
import com.netease.basecomponent.business.entity.IData;
import com.netease.basecomponent.business.exceptions.NullDataException;
import com.netease.basecomponent.business.exceptions.RequestFailedException;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sh on 2016/10/25 11:16.
 */

public class RxUtil {
    /**
     * 简化RX线程处理
     */
    public static <T> FlowableTransformer<T, T> fixSchedulerFlowable() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 简化RX线程处理
     */
    public static <T> ObservableTransformer<T, T> fixScheduler() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 生成Observable
     */
    public static <T> Flowable<T> createDataFlowable(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    /**
     * 生成Observable
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }


    /**
     * 统一返回结果处理
     */
    public static <T extends IData> ObservableTransformer<BaseResponse<T>, T> handleResult() {
        return new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseResponse<T> baseResponse) throws Exception {
                        if (baseResponse.isSuccess()) {
                            T data = baseResponse.getData();
                            if (baseResponse.getData() == null) {
                                throw new NullDataException("请求成功,但数据为空!!!");
                            }
                            data.setMsg(baseResponse.getMsg());
                            return createData(data);
                        } else {
                            throw new RequestFailedException("请求失败,错误码为:" + baseResponse.getCode(),baseResponse.getCode(),baseResponse.getMsg());
                        }
                    }
                });
            }
        };
    }


    /**
     * 统一返回结果处理
     */
    public static <T extends IData> FlowableTransformer<BaseResponse<T>, T> handleResultFlowable() {
        return new FlowableTransformer<BaseResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(BaseResponse<T> baseResponse) throws Exception {
                        if (baseResponse.isSuccess()) {
                            T data = baseResponse.getData();
                            if (baseResponse.getData() == null) {
                                throw new NullDataException("请求成功,但数据为空!!!");
                            }
                            data.setMsg(baseResponse.getMsg());
                            return createDataFlowable(data);
                        } else {
                            throw new RequestFailedException("请求失败,错误码为:" + baseResponse.getCode(),baseResponse.getCode(),baseResponse.getMsg());
                        }
                    }
                });
            }
        };
    }
}
