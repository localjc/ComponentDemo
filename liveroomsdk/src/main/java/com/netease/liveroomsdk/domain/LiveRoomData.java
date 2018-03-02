package com.netease.liveroomsdk.domain;

import com.netease.basecomponent.business.entity.IData;

/**
 * Created by jiangcheng on 2018/3/1.
 */

public class LiveRoomData implements IData {

    private PageInfo pageInfo;
    private String msg;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
