package com.soft.yck.home.presenter;

import com.soft.yck.home.bean.BookPageListBean;
import com.soft.yck.home.model.HttpModule;
import com.soft.yck.home.param.PartyParam;
import com.soft.yck.home.view.HomeView;
import com.ys.jsst.pmis.commommodule.base.mvp.ApiCallBack;
import com.ys.jsst.pmis.commommodule.base.mvp.BasePresenter;
import com.ys.jsst.pmis.commommodule.http.ApiManager;


/**
 * 登录数据
 */
public class HomePresenter extends BasePresenter<HomeView> {

    public void stackBook(final PartyParam param,final int index){

        addSubscribe(ApiManager.getsRetrofit().create(HttpModule.class).getBookList(param), new ApiCallBack<BookPageListBean> (){

            @Override
            public void onSuccess(BookPageListBean bean) {
                if(mMvpView!=null){
                    mMvpView.showStackBook(bean,index);
                }
            }
            @Override
            public void onFailure(String errorMsg) {
                if(mMvpView!=null){
                    mMvpView.showError();
                }
            }

            @Override
            public void onNoNetwork() {
                if(mMvpView!=null){
                    mMvpView.showNoNetwork();
                }
            }
        });
    }



}
