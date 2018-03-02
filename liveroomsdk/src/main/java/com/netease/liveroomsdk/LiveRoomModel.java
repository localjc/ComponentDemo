package com.netease.liveroomsdk;

import com.netease.basecomponent.business.mvp.BaseModel;
import com.netease.liveroomsdk.domain.LiveRoomData;

/**
 * 直播Model类，
 * Created by jiangcheng on 2018/2/28.
 */

public class LiveRoomModel extends BaseModel<LiveRoomContract.ILiveModelCallback, LiveRoomData> {


    /**
     * @param roomId
     */
    public void requestLiveroomData(String roomId) {
        mModelCallback.showLoading();
        API retrofit = mNetworkManager.getRetrofit(API.class);
        subscribe(retrofit.getLiveRoomData(1,10));
    }

    @Override
    public void onNext(LiveRoomData liveRoomData) {
        super.onNext(liveRoomData);
        mModelCallback.dismissLoading();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        mModelCallback.dismissLoading();
    }
}
