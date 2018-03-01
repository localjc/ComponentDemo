package com.netease.liveroomsdk;

import com.netease.basecomponent.business.mvp.BaseModel;

/**
 * 直播Model类，
 * Created by jiangcheng on 2018/2/28.
 */

public class LiveRoomModel extends BaseModel {


    /**
     * @param roomId
     */
    public void requestLiveroomData(String roomId) {

        // 模拟请求过程，请求过程

        mModelCallback.showLoading();

        LiveRoomResponse response = new LiveRoomResponse();
        response.setCode(200);
        response.setMsg("请求成功");

        LiveRoomData data = new LiveRoomData();
        data.setName("哈哈哈哈哈哈  :  姜诚");

        response.setData(data);

        mModelCallback.onSuccess(response);

        mModelCallback.dismissLoading();
    }


}
