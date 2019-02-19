package com.ys.jsst.pmis.commommodule.presenter;

import com.ys.jsst.pmis.commommodule.base.BaseBean;
import com.ys.jsst.pmis.commommodule.bean.BookDetailsBean;
import com.ys.jsst.pmis.commommodule.bean.BrowseBean;
import com.ys.jsst.pmis.commommodule.http.ApiManager;
import com.ys.jsst.pmis.commommodule.http.HttpController;
import com.ys.jsst.pmis.commommodule.http.HttpPayModel;
import com.ys.jsst.pmis.commommodule.http.OnRequestListener;
import com.ys.jsst.pmis.commommodule.http.OnResponsetListener;
import com.ys.jsst.pmis.commommodule.param.AddBrowseParam;
import com.ys.jsst.pmis.commommodule.param.AddReadParam;
import com.ys.jsst.pmis.commommodule.param.BooKBarListParam;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-9-20 16:27
 */
public class PayPresenter {


    /**
     * 判断当前资源是否收藏
     * @param param
     * @param listener
     */
    public static void getBookData1(final BooKBarListParam param, final OnRequestListener<BookDetailsBean> listener) {
        HttpController.getIntance().httpT(ApiManager.getsRetrofit().create(HttpPayModel.class).getBookData1(param), 16, listener);
    }

    /**
     *  加入阅读
     * @param param
     * @param listener
     */
    public  static void  addRead(final AddReadParam param, final OnResponsetListener<BaseBean> listener){
        HttpController.getIntance().httpNoDialog(ApiManager.getsRetrofit().create(HttpPayModel.class).addRead(param), 2,listener);
    }

    /**
     *上传浏览次数
     */
    public  static void  addBrowse(final AddBrowseParam param, final OnResponsetListener<BrowseBean> listener){
        HttpController.getIntance().httpNoDialog(ApiManager.getsRetrofit().create(HttpPayModel.class).addBrowse(param), 2,listener);
    }
}
