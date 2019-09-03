package com.bikeming.basemvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.billy.android.loading.Gloading;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 16:41
 * @Version:1.0
 */
public abstract class BaseFragemnt<P extends BasePresenter> extends RxFragment implements BaseView {

    protected P mPresenter;

    protected abstract P createPresenter();

    public abstract int getContentViewId();

    protected abstract void init();

    protected BaseActivity mActivity;

    protected View mContentView;

    protected Gloading.Holder mHolder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            if (getContentViewId() != 0) {
                mContentView = inflater.inflate(getContentViewId(), null);
//                mBind = ButterKnife.bind(this, mContentView);
            }
        } else {
            ViewParent parent = mContentView.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(mContentView);
            }
        }
        initLoadingStatusViewIfNeed();
//        return mContentView;
        return mHolder.getWrapper();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        init();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        mContentView = null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public LifecycleTransformer bindLifecycle() {
        LifecycleTransformer lifecycle = bindToLifecycle();
        return lifecycle;
    }

    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.getDefault().wrap(mContentView).withRetry(new Runnable() {
                @Override
                public void run() {
                    onLoadRetry();
                }
            });
        }
    }

    protected void onLoadRetry() {
        init();
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