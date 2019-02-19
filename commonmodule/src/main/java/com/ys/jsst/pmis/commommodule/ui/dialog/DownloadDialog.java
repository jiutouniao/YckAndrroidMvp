package com.ys.jsst.pmis.commommodule.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ys.jsst.pmis.commommodule.R;

/**
 * Created by yanshu on 2016/12/30.
 */

public class DownloadDialog extends Dialog {

    ProgressBar pbLoading;
    private Context mContext;

    TextView tvContext;

    private String tvHint;

    public DownloadDialog(Context mContext) {
        super(mContext, R.style.CustomDialog);
        // TODO Auto-generated constructor stub
        this.mContext = mContext;
    }

    public DownloadDialog(Context context, String tvHint) {
        this(context);
        this.tvHint = tvHint;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_download);
        /**************************************************************************************/
        this.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失 true消失  false不消失
        this.setCancelable(false); //点击返回
        initView();
        initData();
        initEvent();
    }
    private void initView() {
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.CENTER);
        setOwnerActivity((Activity) mContext);
        pbLoading = (ProgressBar) findViewById(R.id.pb_loading);
        tvContext = (TextView) findViewById(R.id.tv_hint);
    }


    private void initData() {
        if (!TextUtils.isEmpty(tvHint)) {
            tvContext.setText(tvHint);
        }
    }
    private void initEvent() {

    }
    public void setProgress(float pro){
        pbLoading.setProgress((int)pro);
    }
    public void hide() {
        this.dismiss();
    }

}
