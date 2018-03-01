package com.netease.liveroomsdk;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.netease.basecomponent.business.mvp.BaseActivity;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public class TestLiveRoomActivity extends BaseActivity<LiveRoomPresenter> implements LiveRoomContract.ILiveView {

   private Button mBtnTest;
   private TextView mTvShow;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_liveroom;
    }

    @Override
    public void onInitViews() {
       mBtnTest = findViewById(R.id.tv_test);
       mTvShow = findViewById(R.id.tv_show);
    }

    @Override
    public void onSetViewListeners() {
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShow.setText("");
                mTvShow.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPresenter().getLiveRoomData("123");
                    }
                },2000);
            }
        });
    }

    @Override
    public void onUIReady() {
        // 开始请求数据
        getPresenter().getLiveRoomData("123");
    }


    @Override
    protected LiveRoomPresenter createPresenter() {
        return new LiveRoomPresenter(this, false);
    }


    @Override
    public void showLiveData(LiveRoomResponse data) {
        mTvShow.setText(data.getData().getName());
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView() {

    }
}
