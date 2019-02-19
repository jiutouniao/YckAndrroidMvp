package com.ys.jsst.pmis.commommodule.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.ui.footer.FooterView;
import com.ys.jsst.pmis.commommodule.ui.header.HeaderView;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.StringUtils;

/**
 * 描述:下拉列表界面
 * 包含没有网络、没有数据、下拉刷新
 * 作者：邵兵
 * 日期：2017/9/21 10:01
 */
public class BaseSwipeMenuRecyclerView extends LinearLayout {

    //有数据
    public static final int HAS_DATA = 0;
    //没数据
    public static final int NO_DATA = 1;
    //没网络
    public static final int NO_NETWORK = 2;
    //没有更多数据
    public static final int NO_MORE_DATA = 3;
    private View mView;

    private BaseListAttribute attribute = new BaseListAttribute();

    private TwinklingRefreshLayout refresh;

    private SwipeMenuRecyclerView recyclerView;

    private RelativeLayout rlNoData;

    private LinearLayout llytNoNetwork;

    private FooterView footerView;

    private OnBaseListListener listener;
    private HeaderView mHeaderView;
    private String key;


    public void setOnBaseListListener(OnBaseListListener onBaseListListener) {
        this.listener = onBaseListListener;
    }

    public void setTime(String key) {
        this.key = key;
        mHeaderView.setKey();

    }


    public BaseSwipeMenuRecyclerView(Context context) {
        super(context);
        initView(context);
        initData(context);
        initEvent();
    }

    public BaseSwipeMenuRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context);
        initEvent();
    }

    public BaseSwipeMenuRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        mView = LayoutInflater.from(context).inflate(R.layout.item_base_list, null);
        refresh = (TwinklingRefreshLayout) mView.findViewById(R.id.refresh);
        recyclerView = (SwipeMenuRecyclerView) mView.findViewById(R.id.rv_list);
        rlNoData = (RelativeLayout) mView.findViewById(R.id.rl_no_data);
        llytNoNetwork = (LinearLayout) mView.findViewById(R.id.llyt_no_network);
        this.addView(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public void initRecyclerView(RecyclerView.LayoutManager layout, SwipeMenuAdapter adapter, SwipeMenuCreator swipeMenuCreator, OnSwipeMenuItemClickListener menuItemClickListener) {
        try {
            recyclerView.setLayoutManager(layout);
            // 设置菜单创建器。
            recyclerView.setSwipeMenuCreator(swipeMenuCreator);
            // 设置菜单Item点击监听。
            recyclerView.setSwipeMenuItemClickListener(menuItemClickListener);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
    }

    /**
     * 是否允许下拉刷新
     */
    public void setEnableRefresh(boolean enableRefresh1) {
        try {
            refresh.setEnableRefresh(enableRefresh1);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
    }

    /**
     * 是否允许加载更多
     */
    public void setEnableLoadmore(boolean enableLoadmore1) {
        try {
            refresh.setEnableLoadmore(enableLoadmore1);
            refresh.setOverScrollRefreshShow(false);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
    }

    /**
     * 设置禁止下拉越界
     * */
    public void  setEnableOverScroll(boolean enableOverScroll){
        try {
            refresh.setEnableOverScroll(enableOverScroll);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
    }

    /**
     * 设置是否自动加载更多操作
     */
    public void setAutoLoadMore(boolean autoLoadMore) {
        try {
            refresh.setAutoLoadMore(autoLoadMore);
        } catch (Exception e) {
            LogUtil.e("", e);
        }
    }


    private void initData(Context context) {
        try {
            mHeaderView = new HeaderView(context);
            refresh.setHeaderView(mHeaderView);

            footerView = new FooterView(context);
            refresh.setBottomView(footerView);
            refresh.setEnableRefresh(attribute.enableRefresh);
            refresh.setEnableLoadmore(attribute.enableLoadmore);
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
                    if (StringUtils.isNotEmpty(key)) {
                        mHeaderView.setRefreshTime(SharedPreferenceUtils.getRefreshTime(key));
                        SharedPreferenceUtils.setRefreshTime(key, System.currentTimeMillis());
                    }

                    if (footerView != null)
                        footerView.setMessage(getContext().getString(R.string.longding));
                    if (listener != null) {
                        listener.onRefreshing(recyclerView);
                    }

                } catch (Exception e) {
                    LogUtil.e("onRefresh  ", e);
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                try {
                    if (listener != null) {
                        listener.onLoadMoreing(recyclerView);
                    }
                } catch (Exception e) {
                    LogUtil.e("onRefresh  ", e);
                }
            }
        });
    }

    /**
     * 没有更多数据了
     */
    public void noMoreData() {
        try {
            if (footerView != null)
                footerView.setMessage(getContext().getString(R.string.longding_no_more));
        } catch (Exception e) {
            LogUtil.e("", e);
        }
    }

    /**
     * 结束刷新
     */
    public void finishRefresh() {
        try {
            if (refresh != null) {
                refresh.finishRefreshing();
                refresh.finishLoadmore();
            }
        } catch (Exception e) {
            LogUtil.e("", e);
        }
    }

    /**
     * 0.代表有数据  1.代表没有数据   2. 代表没有网络
     *
     * @param flag
     */
    public void handView(int flag) {
        try {
            switch (flag) {
                case 0: {
                    if (refresh.getVisibility() != VISIBLE) {
                        refresh.setVisibility(VISIBLE);
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
                    refresh.setVisibility(GONE);
                    rlNoData.setVisibility(VISIBLE);
                    llytNoNetwork.setVisibility(GONE);
                    break;
                }
                case 2: {
                    refresh.setVisibility(GONE);
                    rlNoData.setVisibility(GONE);
                    llytNoNetwork.setVisibility(VISIBLE);
                    break;
                }
            }
        } catch (Exception e) {
            LogUtil.e("handView", e);
        }

    }

    public SwipeMenuRecyclerView getRecyclerView() {
        return recyclerView;
    }

    /**
     * 设置回调
     */
    public interface OnBaseListListener {

        void onRefreshing(RecyclerView recyclerView);

        void onLoadMoreing(RecyclerView recyclerView);
    }


}
