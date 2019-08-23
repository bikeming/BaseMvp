package com.bikeming.basemvp.demo;

import com.bikeming.basemvp.BasePresenter;
import com.bikeming.basemvp.BaseResponse;
import com.bikeming.basemvp.ResponseConsumer;

/**
 * @ClassName: com.bikeming.basemvp.demo
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 13:58
 * @Version:1.0
 */
public class LoginPrensent extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresent {

    @Override
    public void getLoginResponse() {
        String name = "北城中学班牌管理员";
        String pwd = "cbbccbbc";
        addObservable(getApiService(ApiService.class).goLogin(name, pwd),
                new ResponseConsumer<BaseResponse>() {
                    @Override
                    public void acceptSuccess(BaseResponse result) {
                        mvpView.loginSuccess(result.code+"");
                    }
                });
    }
}