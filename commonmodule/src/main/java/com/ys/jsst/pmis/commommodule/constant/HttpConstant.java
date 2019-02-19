package com.ys.jsst.pmis.commommodule.constant;

import android.text.TextUtils;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

/**
 * Created by shaobing on 2017/3/31.
 */

public class HttpConstant {

     public static final String GET_URL = "http://172.16.0.103:83/read3/rest/"; //三校电子阅读

    //
    //文件路径 图片 视屏 银屏
    public static final String FILE_PATH_URL = "common/download_file?user_id=%1$s&token=%2$s&path=%3$s";
    //头条url地址
    public static final String HEADLINE_PATH_URL = GET_URL + "api/common/show_headline?resource_id=%1$s&key=123";

    //文件路径 图片 视屏 音频下载不需要token验证
    public static final String No_Token_Url = GET_URL + "api/common/get_image?file_path=%1$s";


    //重做状态
    public static final String REDO_COMPLETE_FLAG = "3";
    public static final String EACH_PAGE_DATA = "10";
    public static final int MAX_TIME_OUT = 5000;
    public static final String TELL_PHONE = "0751-82073448";

    /**
     * 获取文件的路径
     *
     * @param path 文件路径
     * @return
     */
    public static String getFilePath(String path) {
        LogUtil.d("getFilePath :" + String.format(GET_URL + FILE_PATH_URL, SharedPreferenceUtils.getUser_id(), SharedPreferenceUtils.getToken(), path));
        if (!TextUtils.isEmpty(path) && path.startsWith("http")) {
            return path;
        } else
            return String.format(GET_URL + FILE_PATH_URL, SharedPreferenceUtils.getUser_id(), SharedPreferenceUtils.getToken(), path);
    }


    /**
     * 获取资源，不需要token验证
     * @param path 文件路径
     * @return
     */
    public static String gePathNoToken(String path) {
        return String.format(No_Token_Url, path);
    }
}
