package com.ys.jsst.pmis.commommodule.http;

import java.io.File;

/**
 * description:网络加载回调方法
 * Date: 2016/9/12 14:27
 * User: shaobing
 */
public interface OnFiletListener {

    /**
     * 对不同的请求进行不同的返回
     */
    void onSuccess(File file);

    /**
     * 没有网络
     */
    void onNoNetwork();

    /**
     * 错误的回调
     * @param message 回调
     */
    void onError(String message);

}
