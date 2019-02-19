package com.ys.jsst.pmis.commommodule.http;

import android.util.Log;

import com.ys.jsst.pmis.commommodule.base.AppContext;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.NetworkUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shaobing on 2017/3/31.
 */

public class HttpFileController {

    private static final String TAG = "HttpFileController";
    /**
     *
     * @param call
     * @param destFileName
     * @param listener
     */
    public static  void loadFile(Call<ResponseBody> call , final String destFileName, final OnFiletListener listener){
        if (!NetworkUtils.isNetworkConnected(AppContext.getmAppContext())) {
            if (listener != null) {
                listener.onNoNetwork();
            }
            return;
        }
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    boolean writtenToDisk = writeResponseBodyToDisk(response.body(),destFileName);
                    Log.d(TAG, "file download was a success? " + writtenToDisk);
                    if (listener != null) {
                        listener.onSuccess(null);
                    }
                } else {
                    Log.d(TAG, "server contact failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtil.e("HttpController -> onError  ",t);
                if (listener != null) {
                    listener.onError(t.getMessage()==null?"on error":t.getMessage());
                }
            }
        });
    }
    private static boolean writeResponseBodyToDisk(ResponseBody body, String destFileName) {
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(destFileName);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
}











