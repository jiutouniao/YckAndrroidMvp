package com.ys.jsst.pmis.commommodule.http;

import android.app.Activity;

import com.google.gson.Gson;
import com.ys.jsst.pmis.commommodule.base.AppContext;
import com.ys.jsst.pmis.commommodule.ui.dialog.LoadDialog;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.NetworkUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shaobing on 2017/3/31.
 */

public class HttpController<T> {

    private static HttpController mHttpController;

    public static HttpController getIntance() {
        if (mHttpController == null) {
            mHttpController = new HttpController();
        }
        return mHttpController;
    }

    /**
     * 基本模板
     *
     * @param observable 观察者
     * @param index      当前返回值ID
     * @param listener   回调监听
     */
    public static void http(Observable<String> observable, final int index, final OnRequestListener<String> listener) {

        LogUtil.d("listener" + listener);
        if (!NetworkUtils.isNetworkConnected(AppContext.getmAppContext())) {

            LogUtil.d("listener   111111" + listener + new Gson().toJson(listener));

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
                            listener.onError(e.getMessage() == null ? "on error" : e.getMessage());
                            listener.onHideLoading();
                        }
                    }

                    @Override
                    public void onNext(String message) {
                        try {
                            if (listener != null) {
                                listener.onSuccessAndUpdateUI(index, message);
                                listener.onHideLoading();
                            }
                        }catch (Exception e){
                            LogUtil.e("onSuccessAndUpdateUI ",e);
                        }


                    }
                });
    }

    /**
     * 基本模板
     *
     * @param observable 观察者
     * @param index      当前返回值ID
     * @param listener   回调监听
     */
    public void httpT(Observable<T> observable, final int index, final OnRequestListener<T> listener) {
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
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("HttpController -> onError  ", e);
                        if (listener != null) {
                            listener.onHideLoading();
                            listener.onError(e.getMessage() == null ? "on error" : e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(T message) {
                        try {
                            if (listener != null) {
                                listener.onSuccessAndUpdateUI(index, message);
                                listener.onHideLoading();
                            }
                        }catch (Exception e){
                            LogUtil.e("onSuccessAndUpdateUI ",e);
                        }
                    }
                });
    }


    /**
     * 基本模板
     *
     * @param observable 观察者
     * @param index      当前返回值ID
     * @param listener   回调监听
     */
    public void httpNoDialog(Observable<T> observable, final int index, final OnResponsetListener<T> listener) {
        if (!NetworkUtils.isNetworkConnected(AppContext.getmAppContext())) {
            if (listener != null) {
                listener.onNoNetwork();
            }
            return;
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("HttpController -> onError  ", e);
                        if (listener != null) {
                            listener.onError(e.getMessage() == null ? "on error" : e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(T message) {
                        try {
                            if (listener != null) {
                                listener.onSuccessAndUpdateUI(index, message);
                            }
                        }catch (Exception e){
                            LogUtil.e("onSuccessAndUpdateUI ",e);
                        }


                    }
                });
    }


    /**
     * 有对话框的网络请求
     *
     * @param observable
     * @param listener
     */
    public void httpByDialog(final Activity activity, Observable<T> observable, final OnResponsetListener<T> listener) {
        if (!NetworkUtils.isNetworkConnected(AppContext.getmAppContext())) {
            if (listener != null) {
                listener.onNoNetwork();
            }
            return;
        }
        //显示对话框
            LoadDialog.showDiaLog(activity);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("HttpController -> onError  ", e);
                        if (listener != null) {
                            listener.onError(e.getMessage() == null ? "on error" : e.getMessage());
                        }
                        LoadDialog.hideDiaLog();
                    }

                    @Override
                    public void onNext(T message) {
                        try {
                            if (listener != null) {
                                listener.onSuccessAndUpdateUI(0, message);
                            }
                        }catch (Exception e){
                            LogUtil.e("onSuccessAndUpdateUI ",e);
                        }
                        LoadDialog.hideDiaLog();
                    }
                });
    }

    /**
     * 没有对话框
     *
     * @param observable
     * @param index
     * @param listener
     */
    public void httpNoDialog(Observable<T> observable, final int index, final OnRequestListener<T> listener) {
        if (!NetworkUtils.isNetworkConnected(AppContext.getmAppContext())) {
            if (listener != null) {
                listener.onNoNetwork();
            }
            return;
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("HttpController -> onError  ", e);
                        if (listener != null) {
                            listener.onError(e.getMessage() == null ? "on error" : e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(T message) {
                        try {
                            if (listener != null) {
                                listener.onSuccessAndUpdateUI(index, message);
                            }
                        }catch (Exception e){
                            LogUtil.e("onSuccessAndUpdateUI ",e);
                        }
                    }
                });
    }

    /**
     * @param call
     * @param destFileName
     * @param listener
     */
    public void loadFile(Call<ResponseBody> call, final String destFileName, final OnFiletListener listener) {
        if (!NetworkUtils.isNetworkConnected(AppContext.getmAppContext())) {
            if (listener != null) {
                listener.onNoNetwork();
            }
            return;
        }
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    File file = saveFile(response, destFileName);
                    if (listener != null) {
                        listener.onSuccess(file);
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError("on error");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtil.e("HttpController -> onError  ", t);
                if (listener != null) {
                    listener.onError(t.getMessage() == null ? "on error" : t.getMessage());
                }
            }
        });
    }

    public File saveFile(Response<ResponseBody> response, String destFileName) throws Exception {
        InputStream in = null;
        FileOutputStream out = null;
        byte[] buf = new byte[2048 * 10];
        int len;
        try {
            File dir = new File(destFileName);
            if (dir.exists()) {
                dir.delete();
            }
            in = response.body().byteStream();
            File file = new File(destFileName);
            out = new FileOutputStream(file);
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            return file;
        } finally {
            in.close();
            out.close();
        }
    }

}











