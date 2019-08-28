package com.bikeming.basemvp.demo;

import com.bikeming.basemvp.BaseObserver;
import com.bikeming.basemvp.BasePresenter;
import com.bikeming.basemvp.BaseResponse;
import com.bikeming.basemvp.utils.GsonUtil;

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
        String name = "fengzi";
        String pwd = "1234567";
//        addObservable(getApiService(ApiService.class).goLogin(name, pwd),
//                new ResponseConsumer<BaseResponse<LoginResponse>>() {
//                    @Override
//                    public void acceptSuccess(BaseResponse<LoginResponse> result) {
//                        mvpView.loginSuccess(GsonUtil.getJson(result.data));
//                    }
//                });

        addObservable(getApiService(ApiService.class).goLogin(name, pwd),
                new BaseObserver<BaseResponse, LoginContract.LoginView>(getView()) {
                    @Override
                    public void onSuccess(BaseResponse result) {
                        mvpView.loginSuccess(GsonUtil.getJson(result.data));

                    }

                    @Override
                    protected void onFailed(String msg) {
                        mvpView.loginError(msg);
                    }
                });
    }
}
