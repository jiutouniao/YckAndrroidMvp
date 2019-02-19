package com.ssdy.people.read.login.ui.activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.ssdy.people.read.login.R;
import com.ssdy.people.read.login.databinding.LoginActivitySplashBinding;
import com.ys.jsst.pmis.commommodule.base.BaseActivity;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


public class SplashActivity extends BaseActivity<LoginActivitySplashBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.timer(1500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                LoginsActivity.startActivity(SplashActivity.this);
                finish();
            }
        });
    }

    @Override
    protected void onInitAttribute(BaseAttribute attribute) {
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        attribute.mLayoutId = R.layout.login_activity_splash;
    }



}
