package com.ssdy.people.read.login.model;

import com.ssdy.people.read.login.bean.LoginBean;
import com.ssdy.people.read.login.param.LoginParam;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yanshu on 2016/12/7.
 */

public interface LoginModel {

    /**
     * 登录
     * */
    @POST("login/login")
    Observable<LoginBean> login(@Body LoginParam param);

}
