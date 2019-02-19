package com.ys.jsst.pmis.commommodule.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.util.DisplayMetricsUtil;

/**
 * 图片轮播指示器
 * Created by amos on 2017/10/12.
 */

public class ViewPagerStateView extends LinearLayout {
    Context mContext;
    View[] mViews;
    int mNum;
    View mView;
    View mChildView;
    DisplayMetricsUtil displayMetricsUtil;

    public ViewPagerStateView(Context context) {
        super(context);
    }

    public ViewPagerStateView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        Init();
    }


    private void Init() {
        displayMetricsUtil = new DisplayMetricsUtil();
        mView = LayoutInflater.from(mContext).inflate(R.layout.layout_view_pager_state_view, this);
        //   mChildView = new ImageView(mContext);
    }


    public void setViewNum(int num, int position) {
        this.mNum = num;
        this.removeAllViews();
        this.setGravity(Gravity.CENTER);
        mViews = new View[mNum];
        for (int i = 0; i < mNum; i++) {
            mViews[i] = new ImageView(mContext);
            if (i == position) {
                mViews[i].setBackgroundResource(R.mipmap.icon_cycle_blue);
            } else {
                mViews[i].setBackgroundResource(R.drawable.icon_view_pager_state_off);
            }

            LayoutParams lp = new LayoutParams(displayMetricsUtil.dpToPixels(mContext, 8), displayMetricsUtil.dpToPixels(mContext, 8));
            lp.setMargins(displayMetricsUtil.dpToPixels(mContext, 5), 0, 0, 0);
            mViews[i].setLayoutParams(lp);
            this.addView(mViews[i]);
        }

    }


    public void setCurState(int p) {
        for (int i = 0; i < mNum; i++) {
            if (i == p) {
                mViews[i].setBackgroundResource(R.mipmap.icon_cycle_blue);
            } else {
                mViews[i].setBackgroundResource(R.drawable.icon_view_pager_state_off);
            }
        }
    }
}

