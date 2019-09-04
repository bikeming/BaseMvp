package com.bikeming.basemvp.demo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.bikeming.basemvp.R;
import com.bikeming.basemvp.base.BaseActivity;
import com.billy.android.loading.Gloading;

/**
 * @ClassName: com.bikeming.basemvp.demo
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 14:07
 * @Version:1.0
 */
public class LoginActivity extends BaseActivity<LoginPrensent> implements LoginContract.LoginView {

    private TextView data;
    private TextView start;

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
        data = (TextView) findViewById(R.id.tv);
        start = (TextView) findViewById(R.id.start);
        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPageLoading();
                mPresenter.getLoginResponse("fengzi","123456777");
            }
        });
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
        mPresenter.getLoginResponse("fengzi","123456");
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
