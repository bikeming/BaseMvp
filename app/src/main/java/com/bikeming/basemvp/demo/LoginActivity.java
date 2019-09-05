package com.bikeming.basemvp.demo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bikeming.basemvp.R;
import com.bikeming.basemvp.aop.CheckIsLogined;
import com.bikeming.basemvp.base.BaseActivity;
import com.bikeming.basemvp.utils.SpUtil;
import com.bikeming.basemvp.utils.ToastUtil;
import com.billy.android.loading.Gloading;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ClassName: com.bikeming.basemvp.demo
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 14:07
 * @Version:1.0
 */
public class LoginActivity extends BaseActivity<LoginPrensent> implements LoginContract.LoginView {

    @BindView(R.id.tv)
    TextView data;
    @BindView(R.id.login)
    Button mLogin;
    @BindView(R.id.check_aop)
    Button mCheckAop;
    @BindView(R.id.clear_login)
    Button mClearLogin;
    @BindView(R.id.start)
    Button mStart;


    @Override
    protected LoginPrensent createPresenter() {
        return new LoginPrensent();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

    }

    @CheckIsLogined(loginType = 0)
    @OnClick(R.id.check_aop)
    public void onViewClicked() {
        ToastUtil.showToast("hhhhhhhhhhh");
    }

    @OnClick({R.id.login, R.id.clear_login, R.id.start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                SpUtil.setIsLogined(true);
                break;

            case R.id.clear_login:
                SpUtil.setIsLogined(false);

                break;
            case R.id.start:
                showPageLoading();
                mPresenter.getLoginResponse("fengzi", "123456777");
                break;
        }
    }

    @Override
    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            mHolder = Gloading.getDefault().wrap(data).withRetry(new Runnable() {
                @Override
                public void run() {
                    onLoadRetry();
                }
            });
        }
    }

    @Override
    protected void onLoadRetry() {
//        showPageLoading();
        mPresenter.getLoginResponse("fengzi", "123456");
    }

    @Override
    public void loginSuccess(String s) {
        showPageLoadSuccess();
        data.setText(s);
    }

    @Override
    public void loginError(String s) {
        showPageLoadFailed();
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }


}
