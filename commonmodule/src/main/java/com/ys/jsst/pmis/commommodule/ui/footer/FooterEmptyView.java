package com.ys.jsst.pmis.commommodule.ui.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.lcodecore.tkrefreshlayout.IBottomView;

/**
 * 描述：上拉刷新底部菜单
 * 作者：shaobing
 * 时间： 2017/2/17 09:49
 */
public class FooterEmptyView extends LinearLayout implements IBottomView {

    public FooterEmptyView(Context context) {
        super(context);
        initView(context);
    }

    public FooterEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public FooterEmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context){

    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingUp(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void reset() {

    }


}
