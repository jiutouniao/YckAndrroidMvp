package com.ys.jsst.pmis.commommodule.ui.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.IBottomView;
import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

/**
 * 描述：上拉刷新底部菜单
 * 作者：shaobing
 * 时间： 2017/2/17 09:49
 */
public class FooterView extends LinearLayout implements IBottomView {

   private TextView loadingText;
    public FooterView(Context context) {
        super(context);
        initView(context);
    }

    public FooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public FooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.item_footer_view,null);
        loadingText = (TextView) view.findViewById(R.id.tv_loading);
        this.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    /**
     * 更新上拉刷新数据
     * @param message
     */
    public void setMessage(String message ){
        if(loadingText!=null){
            loadingText.setText(message);
        }
        LogUtil.d(" loadingText----------> " + loadingText);
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
