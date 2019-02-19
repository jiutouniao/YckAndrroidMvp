package com.ys.jsst.pmis.commommodule.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import com.ys.jsst.pmis.commommodule.R;

/**
 * description:	加载对话框
 * User: shaobing
 * Date: 2016/6/27
 * Time: 18:09
 */
public class LoadingDialog extends Dialog {
    private Context mContext;
    private String tvHint;

    public LoadingDialog(Context mContext) {
        super(mContext, R.style.CustomDialog);
        // TODO Auto-generated constructor stub
        this.mContext = mContext;
    }

    public LoadingDialog(Context context , String tvHint){
        this(context);
        this.tvHint = tvHint;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        /**************************************************************************************/
        this.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失 true消失  false不消失
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);
        dialogWindow.setType((WindowManager.LayoutParams.TYPE_TOAST));
        dialogWindow.setGravity(Gravity.CENTER);
        setOwnerActivity((Activity) mContext);
    }

    private void initData() {

    }


    private void initEvent() {

    }

    public void hide() {
        this.dismiss();
    }

}