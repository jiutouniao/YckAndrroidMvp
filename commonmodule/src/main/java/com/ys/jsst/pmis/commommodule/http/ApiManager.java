package com.ys.jsst.pmis.commommodule.http;

import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.soft.xiren.db.ebook.bean.PartyItem;
import com.ys.jsst.pmis.commommodule.base.RunningActivityManager;
import com.ys.jsst.pmis.commommodule.constant.HttpConstant;
import com.ys.jsst.pmis.commommodule.constant.RouterConstant;
import com.ys.jsst.pmis.commommodule.http.logging.Level;
import com.ys.jsst.pmis.commommodule.http.logging.LoggingInterceptor1;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description: 网络请求类
 * Date: 2016/9/9 17:49
 * User: shaobing
 */
public class ApiManager {
    private static final String TAG = "ApiManager";
    /**
     * 实例化Retrofit
     */
    private static Retrofit sRetrofit;
    private static ApiManager mApiManager;
    public static ApiManager getInstance() {
        if (mApiManager == null) {
            mApiManager = new ApiManager();
        }
        return mApiManager;
    }

    /**
     * 初始化OkHttp3的客户端
     */
    private static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor1.Builder()
                .loggable(LogUtil.sIsDebug)
                .setLevel(Level.BODY)
                .log(Platform.INFO)
                .request("全民阅读 Request")
                .response("全民阅读 Response")
                .build())
            .cache(new Cache(new File("C://okhttp"), 10 * 1024 * 102))//缓存
            .retryOnConnectionFailure(true)
            .connectTimeout(HttpConstant.MAX_TIME_OUT, TimeUnit.SECONDS)//设置超时时间
            .readTimeout(HttpConstant.MAX_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(HttpConstant.MAX_TIME_OUT, TimeUnit.SECONDS)
            .build();
    /**
     * OkHttp3 的监听
     */
    private static class LogIntercepor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.e(TAG, "-------------------------begin---------------------------");
            Log.v(TAG, "request:" + request.toString());
            long t1 = System.nanoTime();
            okhttp3.Response response = chain.proceed(chain.request());
            long t2 = System.nanoTime();
            Log.v(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            //token 过时时退出
            if (content.equals("{\"success\":false,\"result\":null,\"errorCode\":\"authError\",\"errorMsg\":null}")){
                ARouter.getInstance().build(RouterConstant.loginActivity)
                       .withString("isQuit","true")
                       .navigation();
                //删除书库的分类标签数据
                DataSupport.deleteAll(PartyItem.class, "type = ?", "1");
                SharedPreferenceUtils.saveToken("");
                RunningActivityManager.getInstance().finishAllActivity();
            }
            Log.e(TAG, "--------------------------end--------------------------");
            return response.newBuilder().body(okhttp3.ResponseBody.create(mediaType, content)).build();
        }
    }


    /**
     * 初始化Retrofit
     */
    public static Retrofit getsRetrofit(){
        if(sRetrofit==null){
            sRetrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(HttpConstant.GET_URL)
                    .addConverterFactory(GsonConverterFactory.create())//加入json解析
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
                    .build();
        }
        return sRetrofit;
    }
}
