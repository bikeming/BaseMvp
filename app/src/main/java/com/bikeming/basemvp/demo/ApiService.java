package com.bikeming.basemvp.demo;

import com.bikeming.basemvp.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @ClassName: com.bikeming.basemvp.demo
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 14:03
 * @Version:1.0
 */
public interface ApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseResponse> goLogin(@Field("username") String name, @Field("password") String pwd);
}
