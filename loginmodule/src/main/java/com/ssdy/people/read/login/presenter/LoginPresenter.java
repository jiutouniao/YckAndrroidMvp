package com.ssdy.people.read.login.presenter;

import com.ssdy.people.read.login.bean.LoginBean;
import com.ssdy.people.read.login.model.LoginModel;
import com.ssdy.people.read.login.param.LoginParam;
import com.ssdy.people.read.login.view.LoginView;
import com.ys.jsst.pmis.commommodule.base.mvp.ApiCallBack;
import com.ys.jsst.pmis.commommodule.base.mvp.BasePresenter;
import com.ys.jsst.pmis.commommodule.http.ApiManager;


/**
 * 登录数据
 */
public class LoginPresenter  extends BasePresenter<LoginView> {

    public void login(String userId, String password) {
        LoginParam loginParam = new LoginParam();
        loginParam.setUser_id(userId);
        loginParam.setPassword(password);
        addSubscribe(ApiManager.getsRetrofit().create(LoginModel.class).login(loginParam), new ApiCallBack<LoginBean> (){

            @Override
            public void onSuccess(LoginBean bean) {
                if(mMvpView!=null){
                    mMvpView.showLogin(bean);
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
