package com.ys.jsst.pmis.commommodule.base;

import android.support.multidex.MultiDexApplication;

/**
 * description:基本 application类文件
 * Date: 2016/9/8 18:04
 * User: shaobing
 */
public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.init(getApplicationContext());
    }

}
