package com.ys.jsst.pmis.commommodule.ui.header;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;
import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.util.DateTimeUtils;
import com.ys.jsst.pmis.commommodule.util.StringUtils;

/**
 * 描述：下拉刷新标题头
 * 作者：shaobing
 * 时间： 2017/2/17 09:41
 */
public class HeaderView extends LinearLayout implements IHeaderView {

    /**
     * 加载动画
     */
    private View mView;
    private TextView mRefresh_top;
    private TextView mRefresh_bottom;

    public HeaderView(Context context) {
        super(context);
        initView(context);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mView = LayoutInflater.from(context).inflate(R.layout.item_refresh_head_text, null);
        mRefresh_top = (TextView) mView.findViewById(R.id.refresh_head_top);
        mRefresh_bottom = (TextView) mView.findViewById(R.id.refresh_head_bottom);
        this.addView(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {
        //        Log.d("HeaderView", "fraction:" + fraction);
        if (fraction < 1) {
            mRefresh_top.setText("下拉可以刷新");
        } else {
            mRefresh_top.setText("松开立即刷新");
        }
    }

    public void setRefreshTime(long time) {
        Log.d("HeaderView", "time:" + time);
        if (time == 0) {
            return;
        }
        String refreshTime = DateTimeUtils.getRefreshTime(time);
        if (StringUtils.isNotEmpty(refreshTime)) {

            mRefresh_bottom.setText("最近更新:  " + refreshTime);
        }
    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onFinish(OnAnimEndListener animEndListener) {
        animEndListener.onAnimEnd();
    }

    @Override
    public void reset() {

    }


    public void setKey() {

        setRefreshTime( System.currentTimeMillis());

    }
}
