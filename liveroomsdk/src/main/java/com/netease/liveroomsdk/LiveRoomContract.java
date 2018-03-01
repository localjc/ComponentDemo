package com.netease.liveroomsdk;

import com.netease.basecomponent.mvp.m.IModelCallback;
import com.netease.basecomponent.mvp.v.IView;

/**
 * 直播界面的契约类，减少接口类过多的问题
 *
 * Created by jiangcheng on 2018/2/28.
 */

public class LiveRoomContract {


    public interface ILiveView extends IView {
        /**
         * 结合view 来展示数据
         * @param data
         */
        void showLiveData(String data);
    }

    public interface ILiveModel extends IModelCallback {

    }
}
