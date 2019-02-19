package com.ys.jsst.pmis.commommodule.http;

/**
 * description:网络加载回调方法
 * Date: 2016/9/12 14:27
 * User: shaobing
 */
public interface OnRequestListener<T> {
    /**
     * 开始显示加载对话框
     */
    void onShowLoading();

    /**
     * 数据加载完毕隐藏加载对话框
     */

    void onHideLoading();
    /**
     * 对不同的请求进行不同的返回
     * @param code 返回类型
     * @param bean  返回值
     */
    void onSuccessAndUpdateUI(int code, T bean);

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
