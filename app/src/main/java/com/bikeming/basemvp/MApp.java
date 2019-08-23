package com.bikeming.basemvp;

import android.app.Application;

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
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static MApp getINSTANCE() {
        return INSTANCE;
    }

}