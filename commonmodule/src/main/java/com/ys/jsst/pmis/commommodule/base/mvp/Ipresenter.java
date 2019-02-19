package com.ys.jsst.pmis.commommodule.base.mvp;

import rx.Observable;
import rx.Subscriber;

/**
 * @Description MVP的P层
 * @Author ydc
 * @CreateDate 2016/10/10
 * @Version 1.0
 */
public interface Ipresenter<T extends Iview> {

    /**
     * @description 关联P与V（绑定，VIEW销毁适合解绑）
     * @author ydc
     * @createDate
     * @version 1.0
     */
    void attachView(T view);

    /**
     * @description 取消关联P与V（防止内存泄漏）
     * @author ydc
     * @createDate
     * @version 1.0
     */
    void detachView();

    /**
     * @description RX订阅
     * @author ydc
     * @createDate
     * @version 1.0
     */
    void addSubscribe(Observable observable, Subscriber subscriber);

    /**
     * @description RX取消订阅
     * @author ydc
     * @createDate
     * @version 1.0
     */
    void unsubscribe();

}
