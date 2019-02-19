package com.ys.jsst.pmis.commommodule.ui.widget;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
/**
 * 描述：能够保证在ScrollView 中添加RecyclerView不会出问题
 * 作者：shaobing
 * 时间： 2017/2/17 09:49
 */
public class MyNestedScrollView extends NestedScrollView {
    private int downX;
    private int downY;
    private int mTouchSlop;
    private OnScrollMessageListener mListener;
    private int mDistance;

    public MyNestedScrollView(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /**
     * 回调接口，返回滑动的结果
     * @param mListener
     */
    public void setOnScrollMessageListener(OnScrollMessageListener mListener)
    {
        this.mListener = mListener;
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        LinearLayout mLinearLayout  = (LinearLayout) this.getChildAt(0);
        mDistance = (mLinearLayout.getChildAt(mLinearLayout.getChildCount()-1).getBottom()-mLinearLayout.getChildAt(0).getTop()) -( b-t);;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) e.getRawX();
                downY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }
        }
        return super.onInterceptTouchEvent(e);
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
//        LogUtil.i("t+oldt:"+t+"  "+oldt+"  "+mListener+"  "+mDistance);
        if(mListener != null)
        {
            if(oldt>t)
            {
                mListener.onScrollMessage(true,mDistance,t);
            }
            else
            {
                mListener.onScrollMessage(false,mDistance,t);
            }

//            if(t<mDistance*0.2) {   //显示动画
//                mListener.onScrollMessage(true,mDistance,t);
//            }
//            else {
//                mListener.onScrollMessage(false,mDistance,t);
//            }
        }
    }
    /**
     * description: 主要用来返回滚动的距离和ScrollView 隐藏的高度
     * User: shaobing
     * Date: 2016/6/16
     * Time: 8:53
     */
    public interface OnScrollMessageListener
    {
        void  onScrollMessage(boolean flag, int distance, int scrollY);
    }
}
