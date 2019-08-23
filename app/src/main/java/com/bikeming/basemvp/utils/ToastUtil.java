package com.bikeming.basemvp.utils;

import android.widget.Toast;

import com.bikeming.basemvp.MApp;

/**
 * @ClassName: com.bikeming.basemvp.utils
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 15:46
 * @Version:1.0
 */
public class ToastUtil {
    /**
     * @param context
     * 上下文环境
     * @param message
     * toast 的信息
     */
    private static Toast mToast = null;

    public static final void showToast(String message) {
        if (null == mToast) {
            mToast = Toast.makeText(MApp.getINSTANCE(), message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.show();

    }


    public static final void showToast(int message) {

        if (null == mToast) {
            mToast = Toast.makeText(MApp.getINSTANCE(), message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.show();

    }

}
