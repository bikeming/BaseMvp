package com.bikeming.basemvp;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.bikeming.basemvp.views.LoadingView.GlobalAdapter;
import com.bikeming.basemvp.views.TitleBar.TitleBar;
import com.bikeming.basemvp.views.TitleBar.style.TitleBarLightStyle;
import com.billy.android.loading.Gloading;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 11:15
 * @Version:1.0
 */
public class MApp extends Application {

    public static MApp INSTANCE;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        //LoadingView
        Gloading.initDefault(new GlobalAdapter());
        // 初始化 TitleBar 样式
        TitleBar.initStyle(new TitleBarLightStyle(this));
    }

    public static MApp getINSTANCE() {
        return INSTANCE;
    }

}