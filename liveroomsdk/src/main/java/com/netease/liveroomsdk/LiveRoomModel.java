package com.netease.liveroomsdk;

import com.netease.basecomponent.business.mvp.BaseModel;

/**
 * 直播Model类，
 * Created by jiangcheng on 2018/2/28.
 */

public class LiveRoomModel extends BaseModel {


    /**
     *
     * @param roomId
     */
    public void requestLiveroomData(String roomId) {

        // 模拟请求过程，请求过程

        mModelCallback.showLoading();
        mModelCallback.onSuccess("直播间数据请求成功了。返回");
        mModelCallback.dismissLoading();
    }



}
