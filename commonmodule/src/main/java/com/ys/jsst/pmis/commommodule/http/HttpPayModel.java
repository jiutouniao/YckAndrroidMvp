package com.ys.jsst.pmis.commommodule.http;

import com.ys.jsst.pmis.commommodule.base.BaseBean;
import com.ys.jsst.pmis.commommodule.bean.BookDetailsBean;
import com.ys.jsst.pmis.commommodule.bean.BrowseBean;
import com.ys.jsst.pmis.commommodule.param.AddBrowseParam;
import com.ys.jsst.pmis.commommodule.param.AddReadParam;
import com.ys.jsst.pmis.commommodule.param.BooKBarListParam;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-9-20 16:28
 */
public interface HttpPayModel {

    /***
     * 判断当前资源是否已经收藏
     * @param option
     * @return
     */
    @POST("common/getInfo")
    Observable<BookDetailsBean> getBookData1(@Body BooKBarListParam option);


    /**
     * 加入阅读
     * @param  param 参数
     * @return 状态信息
     */
    @POST("read/add_to_read")
    Observable<BaseBean> addRead(@Body AddReadParam param);


    /**
     *上传浏览次数
     */
    @POST("read/addReadingPeople")
    Observable<BrowseBean> addBrowse(@Body AddBrowseParam option);

}
