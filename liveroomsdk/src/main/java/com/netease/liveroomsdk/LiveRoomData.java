package com.netease.liveroomsdk;

import com.netease.basecomponent.business.entity.IData;

/**
 * Created by jiangcheng on 2018/3/1.
 */

public class LiveRoomData implements IData {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
