package com.soft.sh.app.ui.fragment;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.soft.sh.app.R;
import com.soft.sh.app.databinding.AppFragmentAppBinding;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.base.BaseFragment;

public class AppFragment extends BaseFragment<AppFragmentAppBinding> {

    public static AppFragment getInstance() {
        AppFragment bookFrament = new AppFragment();
        return bookFrament;
    }

    private void initToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mViewBinding.toolBar.toolBar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
//            mViewBinding.inclueToolBar.toolBar.setNavigationIcon(R.drawable.ic_back);
            mViewBinding.toolBar.tvToolBarTitle.setText("应用");
            setHasOptionsMenu(true);
        }
    }

    @Override
    public void initView(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.app_fragment_app;
    }

    @Override
    public void initData() {
        initToolbar();
    }

    @Override
    public void initEvent() {
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
