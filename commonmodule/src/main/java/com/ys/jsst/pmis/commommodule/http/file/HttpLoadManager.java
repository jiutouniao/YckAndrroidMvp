package com.ys.jsst.pmis.commommodule.http.file;

import com.ys.jsst.pmis.commommodule.base.AppContext;
import com.ys.jsst.pmis.commommodule.http.OnRequestListener;
import com.ys.jsst.pmis.commommodule.util.NetworkUtils;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 文件下载帮助类
 */
public class HttpLoadManager {

    private Retrofit.Builder retrofit;


    public interface HttpFileModel {
        @GET("apk_version/download_app")
        Call<ResponseBody> loadFile(@QueryMap Map<String, String> option);
    }

//    /**
//     * 获取头条列表接口相关信息
//     *  @param param
//     * @param listener
//     */
//    public static void getReadHeadlList(HeadListParam param, final OnRequestListener<HeadData> listener) {
//        HttpController.getIntance().httpT(ApiManager.getsRetrofit().create(HttpHeadModel.class).get_read_list(param), 1, listener);
//    }
//
//    public void getFile(){
//        HttpController.getIntance().httpT(ApiManager.getsRetrofit().create(HttpFileModel.class).loadFile(param), 1, listener)
//
//
//    }
//



    /**
     * 基本模板
     * @param observable 观察者
     * @param index      当前返回值ID
     * @param listener   回调监听
     */
    public static void http(Observable<String> observable, final int index, final OnRequestListener<String> listener){
        if (!NetworkUtils.isNetworkConnected(AppContext.getmAppContext())) {
            if (listener != null) {
                listener.onNoNetwork();
            }
            return;
        }
        if (listener != null) {
            listener.onShowLoading();
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (listener != null) {
                            listener.onError(e.getMessage()==null?"on error":e.getMessage());
                            listener.onHideLoading();
                        }
                    }

                    @Override
                    public void onNext(String message) {
                        if (listener != null) {
                            listener.onSuccessAndUpdateUI(index,message);
                            listener.onHideLoading();
                        }
                    }
                });
    }









}
