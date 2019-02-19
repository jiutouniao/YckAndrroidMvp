package com.ys.jsst.pmis.commommodule.ui.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;

/**
 * 描述：下拉刷新标题头
 * 作者：shaobing
 * 时间： 2017/2/17 09:41
 */
public class HeaderEmptyView extends LinearLayout implements IHeaderView {


    public HeaderEmptyView(Context context) {
        super(context);
        initView(context);
    }

    public HeaderEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HeaderEmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {
        
    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onFinish(OnAnimEndListener animEndListener) {

    }

    @Override
    public void reset() {

    }


}
