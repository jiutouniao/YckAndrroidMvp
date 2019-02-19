package com.soft.sh.presenter;

import com.soft.sh.bean.UpdateBean;
import com.soft.sh.model.HttpModel;
import com.soft.sh.param.UpdateParam;
import com.soft.sh.view.AppView;
import com.ys.jsst.pmis.commommodule.base.mvp.ApiCallBack;
import com.ys.jsst.pmis.commommodule.base.mvp.BasePresenter;
import com.ys.jsst.pmis.commommodule.http.ApiManager;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;


/**
 * 首页
 */
public class AppPresenter extends BasePresenter<AppView> {

    public void getLatestApp(String app_name){
        UpdateParam param = new UpdateParam();
        param.setToken(SharedPreferenceUtils.getToken());
        param.setUser_id(SharedPreferenceUtils.getUser_id());
        param.setApp_name(app_name);
        addSubscribe(ApiManager.getsRetrofit().create(HttpModel.class).getLatestApp(param), new ApiCallBack<UpdateBean>(){

            @Override
            public void onSuccess(UpdateBean bean) {
                if(mMvpView!=null){
                    mMvpView.showLatestApp(bean);
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
