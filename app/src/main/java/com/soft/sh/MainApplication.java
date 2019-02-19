package com.soft.sh;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.ys.jsst.pmis.commommodule.base.BaseApplication;

import org.litepal.LitePal;


/**
 * Created by guanjie on 2017/3/16.
 */
public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        //初始化数据库
        LitePal.initialize(this);

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }


}
