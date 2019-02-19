package com.ssdy.people.read.login;

import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ys.jsst.pmis.commommodule.base.BaseApplication;

import org.litepal.LitePal;

/**
 * Created by guanjie on 2017/3/16.
 */
public class MyApplication extends BaseApplication {
    private static Handler handler;
    private static MyApplication instance;
    private static int mainTid;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        handler = new Handler();
        mainTid = android.os.Process.myTid();
        LitePal.initialize(this);
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }

    public synchronized static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
