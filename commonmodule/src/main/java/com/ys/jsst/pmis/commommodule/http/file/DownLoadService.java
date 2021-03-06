package com.ys.jsst.pmis.commommodule.http.file;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.base.RunningActivityManager;
import com.ys.jsst.pmis.commommodule.constant.HttpConstant;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.ui.dialog.DownloadDialog;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.manager.fileload.FileCallback;
import com.ys.jsst.pmis.commommodule.util.manager.fileload.FileResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import static android.support.v4.content.FileProvider.getUriForFile;


/**
 * Created by zs on 2016/7/8.
 */
public class DownLoadService extends Service {

    /**
     * 目标文件存储的文件夹路径
     */
    private String destFileDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File
            .separator + "M_DEFAULT_DIR";
    /**
     * 目标文件存储的文件名
     */
    private String destFileName = "shan_yao.apk";

    private Context mContext;
    private int preProgress = 0;
    private int NOTIFY_ID = 1000;
    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private Retrofit.Builder retrofit;
    //下载进度对话框
    private DownloadDialog mDownloadDialog;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mContext = this;
        loadFile();
        mDownloadDialog = new DownloadDialog(RunningActivityManager.getInstance().getTopActivity(), getString(R.string.loading_apk));
        mDownloadDialog.show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 下载文件
     */
    private void loadFile() {
        try {
            initNotification();
        } catch (Exception e) {
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder();
        }
        Map<String, String> map = new HashMap<>();
        map.put("user_id", SharedPreferenceUtils.getUser_id());
        map.put("token", SharedPreferenceUtils.getToken());
        map.put("path", SharedPreferenceUtils.getVersionPath());
        LogUtil.d("map  : " + new Gson().toJson(map));
        retrofit.baseUrl(HttpConstant.GET_URL)
                .client(initOkHttpClient())
                .build()
                .create(IFileLoad.class)
                .loadFile(map)
                .enqueue(new FileCallback(destFileDir, destFileName) {

                    @Override
                    public void onSuccess(File file) {
                        Log.e("zs", "请求成功");
                        try {
                            // 安装软件
                            cancelNotification();
                            installApk(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onLoading(long progress, long total) {
                        Log.e("zs", progress + "----" + total);
                        try {
                            updateNotification(progress * 100 / total);
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("zs", "请求失败");
                        try {
                            cancelNotification();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public interface IFileLoad {
        @GET("common/download_file")
        Call<ResponseBody> loadFile(@QueryMap Map<String, String> option);
    }

    /**
     * 安装软件
     *
     * @param file
     */
    private void installApk(File file) {
        Uri uri;
        Intent install = new Intent(Intent.ACTION_VIEW);
        install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //android 7.0 api24 系统回收了文件夹访问的权限，使用Uri.fromFile 生成的"file://"开头的uri都会报FileUriExposedException错误
        if (Build.VERSION.SDK_INT >= 24) {
            uri = getUriForFile(this, "com.ssdy.people.readlib.downloadfileprovider", file);
            install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                    | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(file);
        }
        install.setDataAndType(uri, "application/vnd.android.package-archive");
        // 执行意图进行安装
        mContext.startActivity(install);
    }

    /**
     * 初始化OkHttpClient
     *
     * @return
     */
    private OkHttpClient initOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(100000, TimeUnit.SECONDS);
        builder.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse
                        .newBuilder()
                        .body(new FileResponseBody(originalResponse))
                        .build();
            }
        });
        return builder.build();
    }

    /**
     * 初始化Notification通知
     */
    public void initNotification() throws Exception {
        builder = new NotificationCompat.Builder(mContext)
                .setSmallIcon(R.mipmap.lib_ic_launcher)
                .setContentText(getString(R.string.percent0))
                .setContentTitle(getString(R.string.data_loading))
                .setProgress(100, 0, false);
        notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, builder.build());
    }

    /**
     * 更新通知
     */
    public void updateNotification(long progress) throws Exception {
        int currProgress = (int) progress;
        if (preProgress < currProgress) {
            builder.setContentText(progress + getString(R.string.percent));
            builder.setProgress(100, (int) progress, false);
            if (mDownloadDialog != null) {
                mDownloadDialog.setProgress(progress);
            }
            if (progress == 100) {
                builder.setContentTitle(getString(R.string.download_over));
                if (mDownloadDialog != null) {
                    mDownloadDialog.dismiss();
                }
            }
            notificationManager.notify(NOTIFY_ID, builder.build());
        }
        preProgress = (int) progress;
    }

    /**
     * 取消通知
     */
    public void cancelNotification() throws Exception {
        notificationManager.cancel(NOTIFY_ID);
    }
}
