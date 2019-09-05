package com.bikeming.basemvp.aop;

import android.content.Context;

/**
 * @ClassName: com.bikeming.basemvp.aop
 * @Description:
 * @author: fjm
 * @date: 2019/9/5 14:16
 * @Version:1.0
 */
public interface ILogin {

    /**
     * 登录事件接收
     * @param applicationContext
     * @param loginType
     */
    void login(Context applicationContext, int loginType);

    /**
     * 判断是否登录
     * @param
     * @return
     */
    boolean isLogin();

}
