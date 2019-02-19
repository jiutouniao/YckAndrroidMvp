package com.ys.jsst.pmis.commommodule.base;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.ys.jsst.pmis.commommodule.R;

/**
 * 描述：dialog 基础对话框
 * 作者：邵兵
 * 日期：2017/8/3 11:41
 */
public abstract class BaseDialog<B extends ViewDataBinding> extends Dialog implements Dialog.OnDismissListener{

    public B mViewBinding;
    private BaseAttribute attribute = new BaseAttribute();

    private Context mContext;

    public BaseDialog(Context context) {
        super(context);
        mContext = context;
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
    }

    protected abstract void onInitAttribute(BaseAttribute attribute);

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化绑定
        onInitAttribute(attribute);
        if (attribute.mLayoutId > 0) {
            mViewBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),attribute.mLayoutId,null,false);
            setContentView(mViewBinding.getRoot());
        }
        initView();
        enterAnima();
        initData();
        initEvent();
    }


    @Override
    protected void onStart() {
        super.onStart();
        setOnDismissListener(this);
    }

    public void showDialog(){
        if(isShowing())return;
        show();
    }

    public void closeDialog(){
        if(!isShowing())return;
        exitAnima();
    }


    @Override
    public void onDetachedFromWindow() {
        exitAnima();
        super.onDetachedFromWindow();
    }

    /**
     * 进入动画
     */
    public void enterAnima() {
        mViewBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(mContext,
                attribute.mEnterAnimId>0?attribute.mEnterAnimId:  R.anim.dialog_fade_in));
    }
    /**
     * 退出动画
     */
    public void exitAnima() {
        Animation animation = AnimationUtils.loadAnimation(mContext,
                attribute.mExitAnimId>0?attribute.mExitAnimId:  R.anim.dialog_fade_out);
        mViewBinding.getRoot().startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                BaseDialog.this.dismiss();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
