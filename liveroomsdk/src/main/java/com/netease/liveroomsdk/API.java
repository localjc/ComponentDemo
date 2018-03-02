package com.netease.liveroomsdk;


import com.netease.basecomponent.business.entity.BaseResponse;
import com.netease.liveroomsdk.domain.LiveRoomData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 苏杭 on 2018/3/1 10:33.
 */

public interface API {
    @GET("/api/home/v2/hot")
    Observable<BaseResponse<LiveRoomData>> getLiveRoomData(@Query("pageNo") int pageNo,@Query("pageSize") int pageSize);
}
