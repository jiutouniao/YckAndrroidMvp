package com.ys.jsst.pmis.commommodule.ui.header;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.ui.widget.SuperSwipeRefreshLayout;
import com.ys.jsst.pmis.commommodule.util.DateTimeUtils;
import com.ys.jsst.pmis.commommodule.util.StringUtils;


/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-5-23 09:35
 */
public class refreshUtils {
    // Header View
    private TextView textView;
    private ImageView imageView;
    private TextView textView4;

    // Footer View
    private TextView footerTextView;
    private ImageView footerImageView;
    static Context mContext;
    private boolean isNoMore;
    private static refreshUtils utils;
    private String refreshTimes;

    private refreshUtils() {
    }

    public static refreshUtils getRefreshUtils() {
        if (utils == null) {
            utils = new refreshUtils();
        }
        return utils;
    }

    /**
     * @param context      上下文
     * @param refresh      刷新控件
     * @param refreshTimes sharepren 里面保存该页刷新时间的键
     * @param listener     刷新监听
     */

    public void setRefresh(Context context, final SuperSwipeRefreshLayout refresh, final String refreshTimes, final onrefreshLinstener listener) {
        mContext = context;
        isNoMore = false;
        this.refreshTimes = refreshTimes;
        refresh.setHeaderViewBackgroundColor(0xffffffff);
        refresh.setHeaderView(createHeaderView());// add headerView
        refresh.setFooterView(createFooterView());
        refresh.setTargetScrollWithLayout(true);
        long refreshTime = SharedPreferenceUtils.getRefreshTime(refreshTimes);
        //        Log.d("refreshUtils", "refreshTimes   " + refreshTimes + "   refreshTime " + refreshTime);
        //        if (refreshTime == 0)
        //            setRefreshTime(System.currentTimeMillis());
        //        else
        setRefreshTime(refreshTime);
        refresh
                .setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {

                    @Override
                    public void onRefresh() {
                        textView.setText("正在刷新");
                        imageView.setVisibility(View.GONE);
                        isNoMore = false;
                        listener.onOkRefresh();


                    }

                    @Override
                    public void onPullDistance(int distance) {

                        //                        Log.d("refreshUtils", "distance:" + distance);
                        // pull distance
                        if (distance == 0) {
                            long refreshTime = SharedPreferenceUtils.getRefreshTime(refreshTimes);
                            //                            Log.d("refreshUtils", "refreshTimes  OnPullRefreshListener " + refreshTimes + "   refreshTime " + refreshTime);
                            //                        if (refreshTime == 0)
                            //                            textView4.setText("尚未更新");
                            //                        else
                            setRefreshTime(refreshTime);
                        }
                    }

                    @Override
                    public void onPullEnable(boolean enable) {
                        textView.setText(enable ? "松开刷新" : "下拉刷新");
                        imageView.setVisibility(View.GONE);
                        imageView.setRotation(enable ? 180 : 0);

                    }
                });

        refresh.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {

            @Override
            public void onLoadMore() {
                if (isNoMore) {
                    refresh.setLoadMore(false);
                } else {
                    footerTextView.setText("正在加载...");
                    footerImageView.setVisibility(View.GONE);
                    //                            new Handler().postDelayed(new Runnable() {
                    //
                    //                                @Override
                    //                                public void run() {
                    //                                    footerImageView.setVisibility(View.VISIBLE);
                    //                                    footerProgressBar.setVisibility(View.GONE);
                    //                                    refresh.setLoadMore(false);
                    listener.onOkLoadmore();
                    //                                }
                    //                            }, 5000);
                }


            }

            @Override
            public void onPushEnable(boolean enable) {
                if (isNoMore) {
                    footerTextView.setText("没有更多的数据");
                    footerImageView.setVisibility(View.GONE);

                } else {
                    footerTextView.setText(enable ? "松开加载" : "上拉加载更多...");
                    footerImageView.setVisibility(View.GONE);
                    footerImageView.setRotation(enable ? 0 : 180);
                }
            }


            @Override
            public void onPushDistance(int distance) {
                // TODO Auto-generated method stub

            }

        });

    }

    private View createFooterView() {
        View footerView = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_footer_test, null);
        footerImageView = (ImageView) footerView
                .findViewById(R.id.footer_image_view);
        footerTextView = (TextView) footerView
                .findViewById(R.id.footer_text_view);
        footerImageView.setVisibility(View.GONE);
        footerImageView.setImageResource(R.drawable.down_arrow);
        footerImageView.setRotation(180);
        footerTextView.setText("上拉加载更多...");
        return footerView;
    }

    private View createHeaderView() {
        View headerView = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_head_test, null);
        textView = (TextView) headerView.findViewById(R.id.text_view);
        textView4 = (TextView) headerView.findViewById(R.id.text_view4);
        textView.setText("下拉刷新");
        imageView = (ImageView) headerView.findViewById(R.id.image_view);
        imageView.setVisibility(View.GONE);
        imageView.setImageResource(R.drawable.down_arrow);
        return headerView;
    }

    public interface onrefreshLinstener {
        void onOkRefresh();

        void onOkLoadmore();
    }

    public void setHeadText(String s) {
        //        textView2.setText(s);
    }

    public void setFooterNoMore(boolean b) {
        isNoMore = b;
    }

    public void setRefreshTime(long time) {
        if (time == 0) {
            textView4.setText("最近更新:  " + DateTimeUtils.getChangehm(DateTimeUtils.getTime()));
            SharedPreferenceUtils.setRefreshTime(refreshTimes, System.currentTimeMillis());
        } else {
            String refreshTime = DateTimeUtils.getRefreshTime(time);
            if (StringUtils.isNotEmpty(refreshTime)) {

                textView4.setText("最近更新:  " + refreshTime);
            }
        }
    }

}
