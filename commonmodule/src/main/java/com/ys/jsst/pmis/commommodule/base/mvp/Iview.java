package com.ys.jsst.pmis.commommodule.base.mvp;

/**
 * @Description MVP之V层 是所有VIEW的基类，其他类可以继承该类
 * @Author ydc
 * @CreateDate 2016/10/10
 * @Version 1.0
 */
public interface Iview<T> {

    /***
     * 数据加载异常
     */
   void showError();

    /***
     * 数据加载异常
     */
    void showNoNetwork();

}