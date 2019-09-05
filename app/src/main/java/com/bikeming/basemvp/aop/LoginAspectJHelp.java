package com.bikeming.basemvp.aop;

import android.content.Context;

/**
 * @ClassName: com.bikeming.basemvp.aop
 * @Description:
 * @author: fjm
 * @date: 2019/9/5 14:17
 * @Version:1.0
 */
public class LoginAspectJHelp {

    private static LoginAspectJHelp instance;

    private Context applicationContext;

    private ILogin iLogin;

    private LoginAspectJHelp() {
    }

    public static LoginAspectJHelp getInstance() {
        if (instance == null) {
            synchronized (LoginAspectJHelp.class) {
                if (instance == null) {
                    instance = new LoginAspectJHelp();
                }
            }
        }
        return instance;
    }

    public void init(Context context, ILogin iLogin) {
        setApplicationContext(context.getApplicationContext());
        setiLogin(iLogin);
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    private void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }


    public ILogin getiLogin() {
        return iLogin;
    }

    private void setiLogin(ILogin iLogin) {
        this.iLogin = iLogin;
    }
}
