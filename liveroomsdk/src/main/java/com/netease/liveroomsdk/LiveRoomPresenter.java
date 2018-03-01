package com.netease.liveroomsdk;

import com.netease.basecomponent.business.mvp.BasePresenter;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public class LiveRoomPresenter extends BasePresenter<LiveRoomContract.ILiveView,
        LiveRoomModel, LiveRoomResponse> implements LiveRoomContract.ILiveModelCallback {

    /**
     * 之所以需要传递这两个参数，是因为创建P层 地方在V中，所以将V 传入到P层
     * 并将V 层的类型传入
     *
     * @param view
     * @param isFragment
     */
    public LiveRoomPresenter(LiveRoomContract.ILiveView view, boolean isFragment) {
        super(view, isFragment);
    }

    @Override
    public LiveRoomModel createModel() {
        return new LiveRoomModel();
    }


    public void getLiveRoomData(String roomId) {
        mModel.requestLiveroomData(roomId);
    }

    @Override
    public void onSuccess(LiveRoomResponse data) {
        if (mView != null) {
            mView.showLiveData(data);
        }
    }

    @Override
    public void onFail() {
        if (mView != null) {
            mView.showErrorView();
        }
    }

    @Override
    public void onNoResponseData() {
        if (mView != null) {
            mView.showEmptyView();
        }
    }
}
