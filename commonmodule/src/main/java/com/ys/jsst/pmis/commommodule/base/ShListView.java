package com.ys.jsst.pmis.commommodule.base;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.ui.footer.FooterView;
import com.ys.jsst.pmis.commommodule.ui.header.HeaderView;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.StringUtils;

import me.drakeet.multitype.MultiTypeAdapter;


/**
 * 描述:下拉列表界面
 * 包含没有网络、没有数据、下拉刷新
 * 作者：邵兵
 * 日期：2017/9/21 10:01
 */
public class ShListView extends LinearLayout {
    //有数据
    public static final int HAS_DATA = 0;
    //没数据
    public static final int NO_DATA = 1;
    //没网络
    public static final int NO_NETWORK = 2;
    //没有更多数据
    public static final int NO_MORE_DATA = 3;
    //根布局
    private View mView;
    //刷新控件
    private TwinklingRefreshLayout refresh;
    //列表控件
    private RecyclerView recyclerView;
    //没有数据布局
    private RelativeLayout rlNoData;
    //没有网络布局
    private LinearLayout llytNoNetwork;
    //底部布局
    private FooterView footerView;
    //头部布局
    private HeaderView mHeaderView;
    //是否正在刷新
    private boolean isRefreshing;
    //没有更多数据
    private boolean isNoMoreData;
    //没有更多数据 默认为0
    private int index;
    private String key;

    public void setTime(String key){
        this.key = key;
        mHeaderView.setKey();
    }


    public ShListView(Context context) {
        super(context);
        initView(context);
        initData(context);
        initEvent();
    }

    public ShListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context);
        initEvent();
    }

    public ShListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initData(context);
        initEvent();
    }

    /**
     * 初始化下拉刷新
     *
     * @param context
     */
    private void initView(Context context) {
        try {
            mView = LayoutInflater.from(context).inflate(R.layout.item_base_list, null);
            refresh = (TwinklingRefreshLayout) mView.findViewById(R.id.refresh);
            recyclerView = (RecyclerView) mView.findViewById(R.id.rv_list);
            rlNoData = (RelativeLayout) mView.findViewById(R.id.rl_no_data);
            llytNoNetwork = (LinearLayout) mView.findViewById(R.id.llyt_no_network);
            this.addView(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initData(Context context) {
        try {
            mHeaderView = new HeaderView(context);
            refresh.setHeaderView(mHeaderView);
            footerView = new FooterView(context);
            refresh.setBottomView(footerView);
            isRefreshing = false;
            isNoMoreData = false;
            index = 0;
        } catch (Exception e) {
            LogUtil.e("", e);
        }

    }

    /**
     * 下拉回调
     */
    private void initEvent() {
        refresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                try {
                    if(isRefreshing)return;
                    isRefreshing = true;
                    isNoMoreData = false;
                    if (footerView != null) footerView.setMessage(getContext().getString(R.string.longding));
                    if(dataListenr!=null){
                        index=0;
                        dataListenr.onData(index);
                    }
                } catch (Exception e) {
                    LogUtil.e("onRefresh  ", e);
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                try {
                    if(isRefreshing)return;
                    isRefreshing = true;
                    if(isNoMoreData){
                        if (footerView != null) footerView.setMessage(getContext().getString(R.string.longding_no_more));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(refresh!=null){
                                    refresh.finishRefreshing();
                                    refresh.finishLoadmore();
                                }
                                isRefreshing = false;
                            }
                        },500);
                    }else{
                        if(dataListenr!=null){
                            index++;
                            dataListenr.onData(index);
                        }
                    }
                } catch (Exception e) {
                    LogUtil.e("onRefresh  ", e);
                }
            }


            @Override
            public void onPullDownReleasing(TwinklingRefreshLayout refreshLayout, float fraction) {
                super.onPullDownReleasing(refreshLayout, fraction);
                Log.d("BaseListView", "fraction:" + fraction);
                try {
                    if (fraction == 0.0f) {
                        if (StringUtils.isNotEmpty(key)) {
                            mHeaderView.setRefreshTime(SharedPreferenceUtils.getRefreshTime(key));
                            SharedPreferenceUtils.setRefreshTime(key, System.currentTimeMillis());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /***
     * 初始化适配器
     * @param layout
     * @param adapter
     * @return
     */
    public ShListView initRecyclerView(RecyclerView.LayoutManager layout, RecyclerView.Adapter adapter) {
        try {
            recyclerView.setLayoutManager(layout);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
        return this;
    }
    /***
     * 初始化适配器
     * @param layout
     * @param adapter
     * @return
     */
    public ShListView initRecyclerView(RecyclerView.LayoutManager layout,MultiTypeAdapter adapter) {
        try {
            recyclerView.setLayoutManager(layout);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
        return this;
    }
    /**
     * 是否允许下拉刷新
     */
    public ShListView setEnableRefresh(boolean enableRefresh1) {
        try {
            refresh.setEnableRefresh(enableRefresh1);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
        return this;

    }

    /**
     * 是否允许加载更多
     */
    public ShListView setEnableLoadmore(boolean enableLoadmore1) {
        try {
            refresh.setEnableLoadmore(enableLoadmore1);
            refresh.setOverScrollRefreshShow(false);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
        return this;

    }

    /**
     * 设置禁止下拉越界
     * */
    public ShListView setEnableOverScroll(boolean enableOverScroll){
        try {
            refresh.setEnableOverScroll(enableOverScroll);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
        return this;

    }

    /**
     * 设置是否自动加载更多操作
     */
    public ShListView setAutoLoadMore(boolean autoLoadMore) {
        try {
            refresh.setAutoLoadMore(autoLoadMore);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
        return this;
    }



    /**
     * 0.代表有数据  1.代表没有数据   2. 代表没有   3.没有更多数据
     * @param flag
     */
    private void handView(int flag) {
        try {
            switch (flag) {
                case 0: {
                    if (recyclerView.getVisibility() != VISIBLE) {
                        recyclerView.setVisibility(VISIBLE);
                    }
                    if (rlNoData.getVisibility() == VISIBLE) {
                        rlNoData.setVisibility(GONE);
                    }
                    if (llytNoNetwork.getVisibility() == VISIBLE) {
                        llytNoNetwork.setVisibility(GONE);
                    }
                    if (footerView != null)
                        footerView.setMessage(getContext().getString(R.string.longding));
                    break;
                }
                case 1: {
                    recyclerView.setVisibility(GONE);
                    rlNoData.setVisibility(VISIBLE);
                    llytNoNetwork.setVisibility(GONE);
                    break;
                }
                case 2: {
                    recyclerView.setVisibility(GONE);
                    rlNoData.setVisibility(GONE);
                    llytNoNetwork.setVisibility(VISIBLE);
                    break;
                }
            }
            isRefreshing = false;
        } catch (Exception e) {
            LogUtil.e("handView", e);
        }
    }

    /***
     *数据操作结束
     * @param currentNumber 当前页码的页码数
     * @param allNumber     总的页码数
     */
    public void endSuccess(int currentNumber,int allNumber) {
        try {
            if(allNumber==0){
                handView(ShListView.NO_DATA);
            }else{
                if(currentNumber<10){
                    handView(ShListView.NO_MORE_DATA);
                    isNoMoreData=true;
                }else{
                    handView(ShListView.HAS_DATA);
                }
            }
            refresh.finishRefreshing();
            refresh.finishLoadmore();
            isRefreshing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     *操作结束没网络
     */
    public void endNoNet() {
        try {
            handView(NO_NETWORK);
            refresh.finishRefreshing();
            refresh.finishLoadmore();
            isRefreshing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置数据
     */
    private OnUpdateDataListenr dataListenr;

    public ShListView setData(OnUpdateDataListenr dataListenr) {
        this.dataListenr = dataListenr;
        return this;
    }

    public interface OnUpdateDataListenr{
        void onData(int index);
    }


}
