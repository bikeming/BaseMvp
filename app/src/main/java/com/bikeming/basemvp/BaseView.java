package com.bikeming.basemvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 11:44
 * @Version:1.0
 */
public interface BaseView {

    //显示正在加载view
    void showLoading(String message);

    // 关闭正在加载view

    void hideLoading();

    //防止内存泄漏
    LifecycleTransformer bindLifecycle();
}
