package com.ys.jsst.pmis.commommodule.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

/**
 * description:	加载动画框
 * User: shaobing
 * Date: 2016/6/27
 * Time: 18:09
 */
public class LoadDialog extends Dialog {

    private static LoadDialog dialog;

    public static void showDiaLog(Activity context) {
        try {
            LogUtil.d("showDiaLog   " + context  + "  "+ context.isFinishing() +"  "+dialog);
            if(context!=null && !context.isFinishing()){
                if (dialog == null) {
                    if (context != null) {
                        dialog = new LoadDialog(context);
                        dialog.show();
                    }
                }else{
                    if (!dialog.isShowing()) {
                        dialog.show();
                    }
                }
            }else{

            }
        }catch ( Exception  e){
            LogUtil.e("showDiaLog",e);
        }
    }

    public static void hideDiaLog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog= null;
        }
    }


    public LoadDialog(Context activity) {
        super(activity, R.style.CustomDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_load);
        /**************************************************************************************/
        this.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失 true消失  false不消失
        this.setCancelable(true);              //设置点击返回按钮消失   true 消失   false 不消失
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.CENTER);
        initView();
        initData();
        initEvent();
    }

    private void initView() {

    }

    private void initData() {

    }

    private void initEvent() {

    }

}