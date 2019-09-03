package com.bikeming.basemvp.base;

import com.bikeming.basemvp.utils.NetWorkUtil;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.functions.Consumer;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 15:36
 * @Version:1.0
 */
public abstract class LocalExceptionConsumer<T extends Throwable> implements Consumer<T> {
    @Override
    public void accept(T t) throws Exception {
        String errorMessage = "";
        int errorCode = 0;
        if (!NetWorkUtil.isNetworkAvailable()) {//网络是否可用
            errorMessage = "网络异常，请检查网络重试";
        } else if (t instanceof SocketException) {//请求异常
            errorMessage = "网络异常，请检查网络重试";
        } else if (t instanceof UnknownHostException) {//网络异常
            errorMessage = "请求失败，请稍后重试...";
        } else if (t instanceof SocketTimeoutException) {//请求超时
            errorMessage = "请求超时";
        } else {
            errorMessage = "未知错误，请重试";
        }
//        else if (t instanceof ServerException) {//服务器返回异常
//            errorMessage = t.getMessage();
//            errorCode = ((ServerException) t).getErrorCode();
//        }
        onError(errorCode, errorMessage);
    }

    abstract void onError(int errorCode, String message);
}
