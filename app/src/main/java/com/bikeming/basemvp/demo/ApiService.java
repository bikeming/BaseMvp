package com.bikeming.basemvp.demo;

import com.bikeming.basemvp.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ClassName: com.bikeming.basemvp.demo
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 14:03
 * @Version:1.0
 */
public interface ApiService {
    @GET("user/login.do")
    Observable<BaseResponse<LoginResponse>> goLogin(@Query("name") String name, @Query("pwd") String pwd);
}
