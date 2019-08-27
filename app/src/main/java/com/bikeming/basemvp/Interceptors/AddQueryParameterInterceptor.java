package com.bikeming.basemvp.Interceptors;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName: com.bikeming.basemvp.Interceptors
 * @Description: Retrofit提供了两种方式设置请求参数。
 * 第一种就是直接添加@Query注解
 * 还有一种方式是通过Interceptor实现,这种方式比较适用于所有的请求都需要添加的参数
 * @author: fjm
 * @date: 2019/8/27 10:00
 * @Version:1.0
 */
public class AddQueryParameterInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder builder = request.url().newBuilder();
        HttpUrl httpUrl = builder.addQueryParameter("token", "test").build();
        return chain.proceed(request.newBuilder().url(httpUrl).build());
    }
}
