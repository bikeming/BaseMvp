package com.bikeming.basemvp.base.net.Interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class TimeOutCacheIntercepter implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
//        String cacheControl = request.cacheControl().toString();
//        if (TextUtils.isEmpty(cacheControl)) {
//            cacheControl = "public,max-age=60";
//        }
        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                // max-age 是一种特例，既包含缓存策略又包含缓存过期时间
                .header("Cache-Control", "max-age=" + 60)
                .build();
    }
}
