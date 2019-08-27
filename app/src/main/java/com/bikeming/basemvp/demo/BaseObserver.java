package com.bikeming.basemvp.demo;


import android.util.Log;

import com.bikeming.basemvp.BaseResponse;
import com.bikeming.basemvp.BaseView;
import com.bikeming.basemvp.utils.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;


/**
 * @ClassName: com.app.mymvp.base.subscribe
 * @Description: 基类观察者
 * @author: fjm
 * @date: 2018/5/29 9:55
 * @Version:1.0
 */

public abstract class BaseObserver<T extends BaseResponse, V extends BaseView> implements Observer<T> {

    protected V mView;

    private Disposable disposable;

    public abstract void onSuccess(T result);

    protected void onFailed(String msg) {
        ToastUtil.showToast(msg);
    }

    public BaseObserver(V view) {
        mView = view;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.disposable = d;
        mView.showLoading();
    }

    @Override
    public void onNext(T baseResponse) {

        if (baseResponse.errorCode == 0) {
            onSuccess(baseResponse);
        } else {
            onFailed(baseResponse.errorMsg);
        }
    }

    @Override
    public void onError(Throwable e) {

        try {
            if (e instanceof SocketTimeoutException) {//请求超时
                onFailed("请求超时,请稍后再试");
            } else if (e instanceof ConnectException) {//网络连接超时
                onFailed("网络连接超时,请检查网络状态");
            } else if (e instanceof SSLHandshakeException) {//安全证书异常
                onFailed("安全证书异常");
            } else if (e instanceof HttpException) {//请求的地址不存在
                int code = ((HttpException) e).code();
                if (code == 504) {
                    onFailed("网络异常，请检查您的网络状态");
                } else if (code == 404) {
                    onFailed("请求的地址不存在");
                } else {
                    onFailed("请求失败");
                }
            } else if (e instanceof UnknownHostException) {//域名解析失败
                onFailed("域名解析失败");
            } else {
                onFailed("error:" + e.getMessage());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            Log.e("OnSuccessAndFaultSub", "error:" + e.getMessage());
            if (disposable != null && !disposable.isDisposed()) { //事件完成取消订阅
                disposable.dispose();
            }
            mView.hideLoading();

        }

    }

    @Override
    public void onComplete() {
        //事件完成取消订阅
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        mView.hideLoading();

    }


}
