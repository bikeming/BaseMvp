package com.bikeming.basemvp.Interceptors;

import android.content.Context;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author David
 * @Date 2016/8/12
 * @Description ${TODO}
 */

/**
 * This interceptor put all the Cookies in Preferences in the Request.
 * Your implementation on how to get the Preferences may ary, but this will work 99% of the time.
 */
public class AddCookiesInterceptor implements Interceptor {
  public static final String PREF_COOKIES = "PREF_COOKIES";
  // We're storing our stuff in a database made just for cookies called PREF_COOKIES.
  // I reccomend you do this, and don't change this default value.
  private Context context;

  public AddCookiesInterceptor(Context context) {
    this.context = context;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request.Builder builder = chain.request().newBuilder();

    HashSet<String> preferences =
        (HashSet<String>) PreferenceManager.getDefaultSharedPreferences(context)
            .getStringSet(PREF_COOKIES, new HashSet<String>());

    for (String cookie : preferences) {
      builder.addHeader("Cookie", cookie);
    }
//    builder.addHeader("Cookie", SPUtil.getIntsance().getCookie());
    return chain.proceed(builder.build());
  }
}

