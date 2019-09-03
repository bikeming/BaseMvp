package com.bikeming.basemvp.base.net;

import com.bikeming.basemvp.ApiDefine;
import com.bikeming.basemvp.BuildConfig;
import com.bikeming.basemvp.base.net.Interceptors.AddCookiesInterceptor;
import com.bikeming.basemvp.base.net.Interceptors.ReceivedCookiesInterceptor;
import com.bikeming.basemvp.MApp;
import com.bikeming.basemvp.utils.GsonUtil;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 10:41
 * @Version:1.0
 */
public class RetrofitManager {

    private static final int OUT_TIME = 60;
    private static final int CONNECT_TIMES = 2000;

    private RetrofitManager() {

    }

    private static volatile Retrofit retrofit;

    public static <T> T getApiService(Class<T> apiService) {
        return getRetrofit().create(apiService);
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null)
            synchronized (RetrofitManager.class) {
                if (retrofit == null)
                    retrofit = getBaseRetrofit(ApiDefine.baseUrl, false);
            }

        return retrofit;
    }

    private static Retrofit getBaseRetrofit(String baseUrl, boolean isHttps) {

        Retrofit mRetrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonUtil.getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient(isHttps))
                .build();
        return mRetrofit;
    }

    private static OkHttpClient getOkHttpClient(boolean isHttps) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMES, TimeUnit.SECONDS);
        builder.readTimeout(OUT_TIME, TimeUnit.SECONDS);
        builder.writeTimeout(OUT_TIME, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        if (isHttps) {
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });

        }
        //打印网络日志
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        //Cookies存取
        builder.addInterceptor(new ReceivedCookiesInterceptor(MApp.getINSTANCE()));
        builder.addInterceptor(new AddCookiesInterceptor(MApp.getINSTANCE()));
        //全局添加请求参数
//        builder.addInterceptor(new AddQueryParameterInterceptor());
        return builder.build();
    }
}
