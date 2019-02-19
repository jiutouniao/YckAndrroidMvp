package com.ys.jsst.pmis.commommodule.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by shaobing on 2018/12/24.
 */

public class InterruptRelativeLayout extends RelativeLayout{


    /***
     * 是否拦截
     */
    private boolean isInterrupt;

    public boolean isInterrupt() {
        return isInterrupt;
    }

    public void setInterrupt(boolean interrupt) {
        isInterrupt = interrupt;
    }

    public InterruptRelativeLayout(Context context) {
        super(context);
    }

    public InterruptRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InterruptRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(isInterrupt==true){
            return  true;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
