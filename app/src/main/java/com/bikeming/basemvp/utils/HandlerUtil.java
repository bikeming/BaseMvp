package com.bikeming.basemvp.utils;

import android.os.Looper;

/**
 * @ClassName: com.fulan.classboard.utils
 * @Description:
 * @author: fjm
 * @date: 2018/6/5 14:40
 * @Version:1.0
 */

public class HandlerUtil {

    private static volatile WeakHandler mHandler;


    public static final void post(Runnable runnable) {
        getHandler().post(runnable);
    }

    public static final void postDelayed(Runnable runnable, int delayed) {
        getHandler().postDelayed(runnable, delayed);
    }

    public static final void postDelayed(Runnable runnable) {
        getHandler().postDelayed(runnable, 200);
    }

    public static final void remove(Runnable runnable) {
        getHandler().removeCallbacks(runnable);
    }

    public static final void removeAllCallbacks(Object token) {
        getHandler().removeCallbacksAndMessages(token);
    }

    private static WeakHandler getHandler() {
        if (mHandler == null) {
            synchronized (HandlerUtil.class) {
                if (mHandler == null) {
                    mHandler = new WeakHandler(Looper.getMainLooper());
                }
            }
        }
        return mHandler;

    }


}
