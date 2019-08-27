package com.bikeming.basemvp;

import android.annotation.SuppressLint;

import com.bikeming.basemvp.utils.ToastUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 11:47
 * @Version:1.0
 */
public abstract class BasePresenter<V extends BaseView> {
    /**
     * 绑定的view
     */
    protected V mvpView;
    private CompositeDisposable compositeDisposable;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    protected void attachView(V mvpView) {
        this.mvpView = mvpView;
        compositeDisposable = new CompositeDisposable();
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    protected void detachView() {
        this.mvpView = null;
        //退出页面的时候移除所有网络请求
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached() {
        return mvpView != null;
    }

    /**
     * 获取连接的view
     */
    public V getView() {
        return mvpView;
    }

    protected <T> T getApiService(Class<T> apiService) {
        return RetrofitManager.getApiService(apiService);
    }

    @SuppressLint("CheckResult")
    protected void addObservable(Observable o, ResponseConsumer onAccept) {
        observe(o).subscribe(onAccept, new LocalExceptionConsumer<Throwable>() {
            @Override
            void onError(int errorCode, String message) {
                ToastUtil.showToast(message);
            }
        });
    }

    protected void addObservable(Observable observable, Observer observer) {
        observe(observable).subscribe(observer);
    }

    private <T> Observable observe(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //防止RxJava内存泄漏
                .compose(mvpView.bindLifecycle());
    }
}
