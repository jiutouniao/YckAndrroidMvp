package com.ys.jsst.pmis.commommodule.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * description: 禁止viewpager 左右滑动
 * Date: 2016/7/4 14:03
 * User: shaobing
 */
public class MyViewPaper extends ViewPager {

    /**
     * 是否禁止滑动标志
     */
    private boolean mDisableSroll = true;

    public MyViewPaper(Context context) {
        super(context);
    }

    public MyViewPaper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDisableScroll(boolean bDisable)
    {
        mDisableSroll = bDisable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(mDisableSroll)
        {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(mDisableSroll)
        {
            return false;
        }
        return super.onTouchEvent(ev);
    }


}