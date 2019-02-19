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
import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

/**
 * 描述:
 *      包含没有网络、没有数据、列表加载
 * 作者：邵兵
 * 日期：2017/9/21 10:01
 */
public class BaseNListView extends LinearLayout{

    //有数据
    public static final int HAS_DATA= 0;
    //没数据
    public static final int NO_DATA= 1;
    //没网络
    public static final int NO_NETWORK= 2;

    private View mView;

    private RecyclerView recyclerView;

    private RelativeLayout rlNoData;

    private LinearLayout llytNoNetwork;

    public BaseNListView(Context context) {
        super(context);
        initView(context);
    }

    public BaseNListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BaseNListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化下拉刷新
     * @param context
     */
    private void initView(Context context){
        mView = LayoutInflater.from(context).inflate(R.layout.item_base_network_list,null);
        recyclerView = (RecyclerView) mView.findViewById(R.id.rv_list);
        rlNoData = (RelativeLayout) mView.findViewById(R.id.rl_no_data);
        llytNoNetwork = (LinearLayout) mView.findViewById(R.id.llyt_no_network);
        this.addView(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    /**
     * 初始化RecyclerView
     * @param layout
     * @param adapter
     */
    public void initRecyclerView(RecyclerView.LayoutManager layout, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){
        try {
            recyclerView.setLayoutManager(layout);
            recyclerView.setAdapter(adapter);
        }catch (Exception e){LogUtil.e("",e);}
    }


    public RecyclerView getRecyclerView(){
        return recyclerView;
    }

    /**
     *   0.代表有数据  1.代表没有数据   2. 代表没有   3.没有更多数据
     * @param flag
     */
    public void handView(int flag){
        try {
            switch (flag){
                case 0:{
                    if(recyclerView.getVisibility()!=VISIBLE){
                        recyclerView.setVisibility(VISIBLE);
                    }
                    if(rlNoData.getVisibility()==VISIBLE){
                        rlNoData.setVisibility(GONE);
                    }
                    if(llytNoNetwork.getVisibility()==VISIBLE){
                        llytNoNetwork.setVisibility(GONE);
                    }
                    break;
                }
                case 1:{
                    recyclerView.setVisibility(GONE);
                    rlNoData.setVisibility(VISIBLE);
                    llytNoNetwork.setVisibility(GONE);
                    break;
                }
                case 2:{
                    recyclerView.setVisibility(GONE);
                    rlNoData.setVisibility(GONE);
                    llytNoNetwork.setVisibility(VISIBLE);
                    break;
                }
            }
        }catch (Exception e){
            LogUtil.e("handView",e);
        }
    }


}
