package com.bikeming.basemvp.demo;

import com.bikeming.basemvp.BaseView;

/**
 * @ClassName: com.bikeming.basemvp.demo
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 13:56
 * @Version:1.0
 */
public interface LoginContract {

    interface LoginPresent {
        void getLoginResponse();

    }

    interface LoginView extends BaseView {
        void loginSuccess(String s);

    }
}
