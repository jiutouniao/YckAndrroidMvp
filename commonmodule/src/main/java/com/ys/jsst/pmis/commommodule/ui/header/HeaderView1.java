package com.ys.jsst.pmis.commommodule.ui.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;
import com.ys.jsst.pmis.commommodule.R;

import pl.droidsonroids.gif.GifImageView;

/**
 * 描述：下拉刷新标题头
 * 作者：shaobing
 * 时间： 2017/2/17 09:41
 */
public class HeaderView1 extends LinearLayout implements IHeaderView {

    /**
     * 加载动画
     */
    private GifImageView gifImageView;
    private View mView;

    public HeaderView1(Context context) {
        super(context);
        initView(context);
    }

    public HeaderView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HeaderView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        mView = LayoutInflater.from(context).inflate(R.layout.item_refresh_head,null);
        gifImageView = (GifImageView) mView.findViewById(R.id.gv_image);
        this.addView(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
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
