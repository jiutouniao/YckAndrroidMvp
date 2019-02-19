package com.ys.jsst.pmis.commommodule.http;

/**
 * description:网络加载回调方法
 * Date: 2016/9/12 14:27
 * User: shaobing
 */
public interface OnResponsetListener<T> {
    /**
     * 对不同的请求进行不同的返回
     * @param code 返回类型
     * @param bean  返回值
     */
    void onSuccessAndUpdateUI(int code, T bean);

    /**
     * 错误的回调
     * @param message 回调
     */
    void onError(String message);

    /**
     * 没有网络
     */
    void onNoNetwork();


}
