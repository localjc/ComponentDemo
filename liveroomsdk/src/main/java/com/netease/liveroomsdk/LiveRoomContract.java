package com.netease.liveroomsdk;

import com.netease.basecomponent.mvp.m.IModelCallback;
import com.netease.basecomponent.mvp.v.IView;
import com.netease.liveroomsdk.domain.LiveRoomData;

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
        void showLiveData(LiveRoomData data);

        /**
         * 显示空页面
         */
        void showEmptyView();

        void showErrorView();
    }

    public interface ILiveModelCallback extends IModelCallback<LiveRoomData> {

    }
}
