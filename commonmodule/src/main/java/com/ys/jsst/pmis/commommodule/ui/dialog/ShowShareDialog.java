//package com.ys.jsst.pmis.commommodule.ui.dialog;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.Gravity;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.ys.jsst.pmis.commommodule.R;
//
//
///**
// * description:	确认对话框
// * User: shaobing
// * Date: 2016/6/27
// * Time: 18:09
// */
//public class ShowShareDialog extends Dialog {
//    private TextView tvTheme;
//    private TextView tvVote;
//    private LinearLayout llytDialog;
//    //上下文
//    private Activity activity;
//    //接口回调
//    private OnDialogListener mListener;
//
//    private Handler mHandler = new Handler();
//    private TextView tvShuping;
//
//    /**
//     * @param activity  上下文
//     * @param mListener 回调
//     */
//    public ShowShareDialog(Activity activity, OnDialogListener mListener) {
//        super(activity, R.style.CustomDialog);
//        this.activity = activity;
//        this.mListener = mListener;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.book_dialog_card1);
//        /**************************************************************************************/
//        this.setCanceledOnTouchOutside(true);// 设置点击屏幕Dialog不消失 true消失  false不消失
//        this.setCancelable(true);              //设置点击返回按钮消失   true 消失   false 不消失
//        Window dialogWindow = this.getWindow();
//        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        dialogWindow.setAttributes(lp);
//        dialogWindow.setGravity(Gravity.BOTTOM);
//        setOwnerActivity((Activity) activity);
//        initView();
//        initData();
//        initEvent();
//    }
//
//    private void initView() {
//        tvTheme = (TextView) findViewById(R.id.tv_theme);
//        tvVote = (TextView) findViewById(R.id.tv_vote);
//        tvShuping = (TextView) findViewById(R.id.tv_shuping);
//        llytDialog = (LinearLayout) findViewById(R.id.llyt_dialog);
//    }
//
//    private void initData() {
//        enterAnima();
//    }
//
//
//    private void initEvent() {
//        tvTheme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                exitAnima();
//                if (mListener != null) {
//                    mHandler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mListener.onDialog(0);
//                            if(mHandler!=null){
//                                mHandler.removeCallbacksAndMessages(null);
//                            }
//                        }
//                    },300);
//                }
//            }
//        });
//        tvVote.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                exitAnima();
//                if (mListener != null) {
//                    mHandler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mListener.onDialog(1);
//                            if(mHandler!=null){
//                                mHandler.removeCallbacksAndMessages(null);
//                            }
//                        }
//                    },300);
//                }
//            }
//        });
//
//        tvShuping.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                exitAnima();
//                if (mListener != null) {
//                    mHandler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mListener.onDialog(2);
//                            if(mHandler!=null){
//                                mHandler.removeCallbacksAndMessages(null);
//                            }
//                        }
//                    },300);
//                }
//            }
//        });
//    }
//
//    public void hide() {
//        this.dismiss();
//    }
//    /**
//     * 进入动画
//     */
//    private void enterAnima() {
//        llytDialog.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.dialog_fade_in));
//    }
//    /**
//     * 退出动画
//     */
//    private void exitAnima() {
//        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.dialog_fade_out);
//        llytDialog.startAnimation(animation);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                CardDialog1.this.dismiss();
//            }
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//    }
//
//    /**
//     * 对话框回调接口
//     */
//    public interface OnDialogListener {
//        void onDialog(int messsage);
//    }
//}