package com.netease.liveroomsdk;

import com.netease.basecomponent.business.entity.BaseResponse;

/**
 * Created by jiangcheng on 2018/3/1.
 */
public class LiveRoomResponse extends BaseResponse<LiveRoomData> {

    @Override
    public boolean hasData() {
        return getData() != null;
    }
}
