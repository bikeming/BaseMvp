package com.bikeming.basemvp.base.net.Interceptors;

import android.content.Context;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Copyright © 企业科技有限公司. All rights reserved.
 *
 * @ClassName: com.uniview.airimos.android_ts_sdk_sample
 * @Description:
 * @author: 封金明
 * @date: 2018/4/12 19:41
 * @Version:1.0
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    private Context context;

    public ReceivedCookiesInterceptor(Context context) {
        this.context = context;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            PreferenceManager.getDefaultSharedPreferences(context).edit()
                    .putStringSet("PREF_COOKIES", cookies)
                    .apply();
        }

        return originalResponse;
    }
}