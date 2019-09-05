package com.bikeming.basemvp.utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.bikeming.basemvp.MApp;
import com.bikeming.basemvp.demo.LoginResponse;

/**
 * @ClassName: com.fulan.classboard.utils
 * @Description: SharedPreferences
 * @author: fjm
 * @date: 2018/5/31 17:30
 * @Version:1.0
 */

public class SpUtil {

    private static SharedPreferences sSP;
    private static SharedPreferences sSP2;
    private static final String SP_LOGIN_NAME = "SP_LOGIN_NAME";
    private static final String SP_LOGIN_RESPONSE = "SP_LOGIN_RESPONSE";
    private static final String SP_CLASS_INFO = "SP_CLASS_INFO";
    private static final String SP_FUNCCLASS_INFO = "SP_FUNCCLASS_INFO";
    private static final String SP_LOGIN_PWD = "SP_LOGIN_PWD";
    private static final String PREFERENCE_NAME = "preference_name";
    private static final String PREFERENCE_NAME2 = "preference_name2";
    private static final String AUTOLOGIN_IS = "autologin_is";
    private static final String APPTYPE = "APPTYPE";
    private static final boolean AUTOLOGIN = false;


    public static SharedPreferences createSp() {
        if (sSP == null) {
            synchronized (SpUtil.class) {
                if (sSP == null) {
                    sSP = MApp.getINSTANCE().getSharedPreferences(PREFERENCE_NAME,
                            Context.MODE_PRIVATE);
                }
            }

        }
        return sSP;
    }

    public static SharedPreferences createSp2() {
        if (sSP2 == null) {
            synchronized (SpUtil.class) {
                if (sSP2 == null) {
                    sSP2 = MApp.getINSTANCE().getSharedPreferences(PREFERENCE_NAME2,
                            Context.MODE_PRIVATE);
                }
            }

        }
        return sSP2;
    }

    public static void clear() {
        createSp().edit().clear().apply();
    }

    public static void remove(String key) {
        createSp().edit().remove(key).apply();
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = createSp().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key) {
        return createSp().getString(key, "");
    }

    /**
     * 处理自动登录
     *
     * @param isLogined
     */
    public static void setIsLogined(boolean isLogined) {
        SharedPreferences.Editor editor = createSp().edit();
        editor.putBoolean(AUTOLOGIN_IS, isLogined);
        editor.apply();
    }

    public static boolean getIsLogined() {
        return createSp().getBoolean(AUTOLOGIN_IS, false);
    }

    /**
     * APP类型
     * type==1:电子班牌
     * type==2:功能教室
     *
     * @return
     */
    public static int getAppType() {
        return createSp().getInt(APPTYPE, 0);
    }

    public static void setAppType(int appType) {
        SharedPreferences.Editor editor = createSp().edit();
        editor.putInt(APPTYPE, appType);
        editor.apply();
    }

    /**
     * 登录信息存取
     *
     * @param loginResponse
     */
    public static void putLoginResponse(LoginResponse loginResponse) {
        SharedPreferences.Editor editor = createSp().edit();
        editor.putString(SP_LOGIN_RESPONSE, GsonUtil.getJson(loginResponse));
        editor.apply();
    }

    public static LoginResponse getLoginResponse() {
        String str_loginResponse = createSp().getString(SP_LOGIN_RESPONSE, "");
        return GsonUtil.fromJson(str_loginResponse, LoginResponse.class);
    }

}
