package com.bikeming.basemvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.billy.android.loading.Gloading;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 16:41
 * @Version:1.0
 */
public abstract class BaseFragemnt<P extends BasePresenter> extends RxFragment implements BaseView {

    private static final String TAG = "BaseFragemnt";

    protected P mPresenter;

    protected abstract P createPresenter();

    public abstract int getContentViewId();

    protected abstract void init();

    protected BaseActivity mActivity;

    protected View mContentView;

    protected Gloading.Holder mHolder;

    private Unbinder mBind;

    protected boolean isFristVisible = true;

    protected boolean isVisibleToUser;

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
                mBind = ButterKnife.bind(this, mContentView);
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
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (mBind != null) {
            mBind.unbind();
            mBind = null;
        }
        mContentView = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Activity内部通过show和hide方法切换Fragment时，引发的状态变迁
     *
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isVisible() && isResumed()) {
            //界面刷新操作，如网络请求
        }
    }

    /**
     * 此方法不是生命周期方法 ，不自动调用  用于fragment懒加载
     * 不过调用顺序不确定  所以必须配合handler<weakhandler></>使用
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser) {
            userVisible();
            if (isFristVisible) {
                isFristVisible = false;
                userFristVisible();
            }
        } else {
            userInvisible();
        }
    }

    /**
     * 不可见时调用
     */
    protected void userInvisible() {
        Log.d(TAG, "userInvisible");

    }

    /**
     * 用户可见时 调用
     *
     * Fragment依托于Activity，其内部的OnResume和OnPause方法真正归属于其依托的Activity
     * 在Activity可见性变化的时候，才会调用这两个方法；
     * 所以 这种模式下不走onresume()和OnPause()
     * <p>
     * 如果在Activity中包含一个ViewPager + 多个Fragment的结构，在Fragment的切换过程中
     * ，因为Activity一直显示，所以Fragment切换是不会调用OnResume和OnPause方法的
     * ，当然第一次创建Fragment的时候是会调用的。
     * <p>
     * 解决方式  setUserVisibleHint(boolean isVisibleToUser)
     */
    protected void userVisible() {
        Log.d(TAG, "userVisible");

    }

    /**
     * 懒加载 第一次可见时 调用
     */
    protected void userFristVisible() {
        Log.d(TAG, "userFristVisible");
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
