package com.netease.basecomponent;

import android.app.Application;
import android.content.Context;

/**
 * 基础的application
 * Created by jiangcheng on 2018/2/28.
 */

public class BaseApplication extends Application {

    public static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
    }


    public static Context getAppContext() {
        return sAppContext;
    }

}
