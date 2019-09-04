package com.bikeming.basemvp.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.bikeming.basemvp.R;
import com.billy.android.loading.Gloading;
import com.gyf.immersionbar.ImmersionBar;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 13:44
 * @Version:1.0
 */
public abstract class BaseActivity<P extends BasePresenter> extends RxFragmentActivity implements BaseView {

    private static final String TAG = "BaseActivity";

    protected P mPresenter;

    private Unbinder mUnbinder;

    protected abstract P createPresenter();

    public abstract int getContentViewId();

    protected abstract void init();

    protected Gloading.Holder mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());
        //初始化沉浸式
        initImmersionBar();

        mUnbinder = ButterKnife.bind(this);

        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        init();
    }

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {
        //设置共同沉浸式样式
        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.colorPrimary)
                .keyboardEnable(true)//解决软键盘与底部输入框冲突问题
                .init();
    }

    @Override
    protected void onDestroy() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    @Override
    public LifecycleTransformer bindLifecycle() {
        LifecycleTransformer lifecycle = bindToLifecycle();
        return lifecycle;
    }

    /**
     * BaseObserver中回调
     * 子类可以自由重写该方法展示加载进度条
     *
     * @param
     */
    @Override
    public void showLoading() {
        Log.d(TAG, "baseActivity showLoading");
    }

    @Override
    public void hideLoading() {
        Log.d(TAG, "baseActivity hideLoading");

    }

    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.getDefault().wrap(this).withRetry(new Runnable() {
                @Override
                public void run() {
                    onLoadRetry();
                }
            });
        }
    }

    protected void onLoadRetry() {

    }

    public void showPageLoading() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoading();
    }

    public void showPageLoadSuccess() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadSuccess();
    }

    public void showPageLoadFailed() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadFailed();
    }

    public void showPageEmpty() {
        initLoadingStatusViewIfNeed();
        mHolder.showEmpty();
    }
}
