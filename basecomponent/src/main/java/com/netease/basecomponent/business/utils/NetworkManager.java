package com.netease.basecomponent.business.utils;

import com.netease.basecomponent.business.entity.BaseResponse;
import com.netease.basecomponent.business.entity.IData;
import com.netease.basecomponent.business.mvp.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 苏杭 on 2018/3/1 11:45.
 */

public class NetworkManager {
    public <T> T getRetrofit(Class<T> aClass) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://live.ent.163.com").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(aClass);
    }

    public <T extends IData> void subscribe(Consumer<T> consumer, Observable<BaseResponse<T>> observable) {
        observable.compose(RxUtil.<BaseResponse<T>>fixScheduler()).compose(RxUtil.<T>handleResult()).subscribe(consumer, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
            }
        });
    }

    public <T extends IData> void subscribe(Consumer<T> consumer, Observable<BaseResponse<T>> observable,Scheduler scheduler) {
        observable.compose(RxUtil.<BaseResponse<T>>fixScheduler()).compose(RxUtil.<T>handleResult()).subscribe(consumer, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
            }
        });
    }
}
