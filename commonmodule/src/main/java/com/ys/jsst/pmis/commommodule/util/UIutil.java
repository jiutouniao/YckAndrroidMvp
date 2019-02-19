package com.ys.jsst.pmis.commommodule.util;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ys.jsst.pmis.commommodule.constant.RouterConstant;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-7-20 22:10
 */
public class UIutil {
    public static final String WX_APP_ID = "wx0820c469c890f5d0";
//    public static final String WX_APP_ID = "wx78ea242680e49b87";
//     AppSecret="19664c82bb693f79c80add4f0491a1cd"
    private static Handler handler;
    private static Context mContext;
    public static final String Cpu_Abi = "CPUABI";
    private static IWXAPI api;

    public static void init(Application application) {
        if (handler == null)
            handler = new Handler();

        mContext = application;
        api = WXAPIFactory.createWXAPI(application, null);
        api.registerApp(WX_APP_ID);

    }

    public static Context getContext() {
        return mContext;
    }

    public static IWXAPI getIWXAPI() {
        return api;
    }


    public static void postDelayed(Runnable runnable, long time) {
        handler.postDelayed(runnable, time);
    }

    public static String getString(int id) {
        return mContext.getString(id);
    }

    /**
     *
     * @return  false 停止执行  true 继续执行
     */

    public static boolean checkLogin() {
        if (isGuest()) {
            ARouter.getInstance().build(RouterConstant.loginActivity).navigation();
            return false;
        }
        return true;
    }

    /**
     *
     * @return  false 停止执行  true 继续执行
     */

    public static boolean isGuest() {
        if (!StringUtils.isNotEmpty(SharedPreferenceUtils.getUser_id()) || SharedPreferenceUtils.getUser_id().equals(SharedPreferenceUtils.getDeveiceId())) {
            return true;
        }
        return false;
    }
}
