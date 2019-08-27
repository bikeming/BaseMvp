package com.bikeming.basemvp;

import android.os.Bundle;
import android.util.Log;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

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

    protected abstract P createPresenter();

    public abstract int getContentViewId();

    protected abstract void init();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());

//        mUnbinder = ButterKnife.bind(this);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
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
}
