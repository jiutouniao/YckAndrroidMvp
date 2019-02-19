package com.ys.jsst.pmis.commommodule.base.mvp;
import com.ys.jsst.pmis.commommodule.base.AppContext;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.NetworkUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.internal.util.SubscriptionList;
import rx.schedulers.Schedulers;

/**
 * @Description 抽象的公用Presenter
 * @Author ydc
 * @CreateDate 20170707
 * @Version 1.0
 */
public abstract class BasePresenter<T extends Iview> implements Ipresenter<T> {
    protected T mMvpView;//所有View
    protected SubscriptionList mSubscriptions;//rx注册中心

    /**
     * @description view绑定P的时候初始化
     * @author ydc
     * @createDate
     * @version 1.0
     */
    @Override
    public void attachView(T view) {
        this.mMvpView = view;
        this.mSubscriptions = new SubscriptionList();
    }

    /**
     * @description view失去绑定清除
     * @author ydc
     * @createDate
     * @version 1.0
     */
    @Override
    public void detachView() {
        unsubscribe();
        this.mMvpView = null;
        this.mSubscriptions = null;
    }

    @Override
    public void unsubscribe(){
        if (mSubscriptions != null) {
            mSubscriptions.unsubscribe();
        }
    }



    /**
     * @description 统一添加订阅关联被观察者和观察者
     * @author ydc
     * @createDate
     * @version 1.0
     */
    public void addSubscribe(Observable observable, Subscriber subscriber) {
        if( observable!=null && subscriber!=null ){
            if (mSubscriptions == null) {
                mSubscriptions = new SubscriptionList();
            }
            mSubscriptions.add(observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber));
        }
    }

}
