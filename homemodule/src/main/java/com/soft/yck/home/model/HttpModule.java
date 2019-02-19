package com.soft.yck.home.model;

import com.soft.yck.home.bean.BookPageListBean;
import com.soft.yck.home.param.PartyParam;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 描述：测试网络请求
 * 作者：shenrunzhou
 * 时间： 2017-04-26 11:06
 */
public interface HttpModule {



    //获取书本列表/reader/rest/classify/get_classify_list
    @POST("classify/get_resource_list")
    Observable<BookPageListBean>  getBookList(@Body PartyParam option);


}
