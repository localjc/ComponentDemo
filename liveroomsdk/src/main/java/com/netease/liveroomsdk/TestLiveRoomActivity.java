package com.netease.liveroomsdk;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.netease.basecomponent.business.mvp.BaseActivity;
import com.netease.basecomponent.business.view.MintLoadingView;
import com.netease.basecomponent.mvp.v.ILoading;

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
                getPresenter().getLiveRoomData("123");
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
    protected ILoading createLoading() {
        return new MintLoadingView();
    }

    @Override
    public void showLiveData(String data) {
        mTvShow.setText(data);
    }
}
