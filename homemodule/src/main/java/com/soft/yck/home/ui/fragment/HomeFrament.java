package com.soft.yck.home.ui.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.soft.yck.home.R;
import com.soft.yck.home.bean.BookPageListBean;
import com.soft.yck.home.bean.Bookbean;
import com.soft.yck.home.databinding.HomeFragmentBookBinding;
import com.soft.yck.home.param.PartyParam;
import com.soft.yck.home.presenter.HomePresenter;
import com.soft.yck.home.ui.adapter.BookAdapter;
import com.soft.yck.home.ui.holder.HomeHolder;
import com.soft.yck.home.view.HomeView;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.base.BaseMvpFragment;
import com.ys.jsst.pmis.commommodule.base.ShListView;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 描述：一般的书架
 * 作者：shaobing
 * 时间： 2017/4/14 20:20
 */
public class HomeFrament extends BaseMvpFragment<HomeFragmentBookBinding,HomePresenter>implements HomeView {

    private Items items;
    private MultiTypeAdapter adapter;
    private String mClassifyId;

    public static HomeFrament getInstance(String classifyId) {
        HomeFrament bookFrament = new HomeFrament();
        Bundle bundle = new Bundle();
        bundle.putString("classifyId", classifyId);
        bookFrament.setArguments(bundle);
        return bookFrament;
    }

    @Override
    public void initView(BaseAttribute attribute) {
        mPresenter = new HomePresenter();
        attribute.mLayoutId = R.layout.home_fragment_book;
    }

    private void initToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mViewBinding.inclueToolBar.toolBar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
//            mViewBinding.inclueToolBar.toolBar.setNavigationIcon(R.drawable.ic_back);
            mViewBinding.inclueToolBar.tvToolBarTitle.setText("书架");
            setHasOptionsMenu(true);
        }
    }

    @Override
    public void initData() {
        initToolbar();
        //判断是否需要从bundle里获取数据
        Bundle bundle = getArguments();
        if (bundle == null)
            return;
        mClassifyId = bundle.getString("classifyId");
        mClassifyId="999914712";
        items = new Items();
        adapter = new MultiTypeAdapter(items);
        adapter.register(Bookbean.class, new HomeHolder(getActivity()));
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mViewBinding.shList.initRecyclerView(mLayoutManager,adapter)
                .setAutoLoadMore(true) //是否自动刷
                .setEnableLoadmore(true)//是否加载更多
                .setEnableRefresh(true)//是否刷新
                .setData(new ShListView.OnUpdateDataListenr() {
                    @Override
                    public void onData(int index) {
                        handleResource(index);
                    }
                });
        showDialog();
        handleResource(0);
    }

    /**
     * 初始化数据
     * @param index
     */
    private void handleResource(final int index) {
        PartyParam param = new PartyParam();
        param.setToken(SharedPreferenceUtils.getToken());
        param.setType("0");
        param.setUser_id(SharedPreferenceUtils.getUser_id());
        param.setClassify_id(mClassifyId);
        param.setPage_index_resource(index);
        LogUtil.e("mPresenter : "+mPresenter);
        if(mPresenter!=null)
        mPresenter.stackBook(param,index);
    }

    @Override
    public void initEvent() {

    }


    @Override
    public void showError() {
        LogUtil.e("showError");
        dismissDialog();
        mViewBinding.shList.endSuccess(0,items.size());
    }

    @Override
    public void showNoNetwork() {
        LogUtil.e("showNoNetwork");
        dismissDialog();
        mViewBinding.shList.endNoNet();
    }

    @Override
    public void showStackBook(BookPageListBean bean,int index) {
        if ("SUCCESS".equals(bean.getRetCode())) {
            //1.判断第一页数据将列表清空
            if (index == 0) {items.clear();}
            //2.加载数据,加载之前要做非空判断
            if(bean.getResource()==null) bean.setResource(new ArrayList<Bookbean>());
            items.addAll(bean.getResource());
           adapter.notifyDataSetChanged();
            //3.判断无数据 、加载完毕状态
            mViewBinding.shList.endSuccess(bean.getResource().size(),items.size());
        }else{
            //请求数据返回error,则直接当做当前页返回0条数据
            mViewBinding.shList.endSuccess(0,items.size());
        }
        dismissDialog();
    }
}
