package com.bikeming.basemvp.base;


import com.bikeming.basemvp.BaseResponse;
import com.bikeming.basemvp.utils.ToastUtil;

import io.reactivex.functions.Consumer;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 15:54
 * @Version:1.0
 */
public abstract class ResponseConsumer<R extends BaseResponse> implements Consumer<R> {

    public abstract void acceptSuccess(R result);

    @Override
    public void accept(R response) throws Exception {

        if (response == null) {
            ToastUtil.showToast("服务器数据异常");
            return;
        }
        if (response.errorCode == 0) {
            acceptSuccess(response);
        } else {
            ToastUtil.showToast(response.errorMsg);
        }
    }
}
