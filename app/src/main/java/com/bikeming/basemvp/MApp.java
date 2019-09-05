package com.bikeming.basemvp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.widget.Toast;

import com.bikeming.basemvp.aop.ILogin;
import com.bikeming.basemvp.aop.LoginAspectJHelp;
import com.bikeming.basemvp.ui.MainActivity;
import com.bikeming.basemvp.utils.SpUtil;
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

        LoginAspectJHelp.getInstance().init(this, new ILogin() {
            @Override
            public void login(Context applicationContext, int loginType) {
                switch (loginType) {
                    case 0:
                        startActivity(new Intent(applicationContext, MainActivity.class));
                        break;
                    case 1:
                        Toast.makeText(applicationContext, "您还没有登录，请登陆后执行", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(applicationContext, "执行失败，因为您还没有登录！", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public boolean isLogin() {
                return SpUtil.getIsLogined();
            }
        });
    }

    public static MApp getINSTANCE() {
        return INSTANCE;
    }

}