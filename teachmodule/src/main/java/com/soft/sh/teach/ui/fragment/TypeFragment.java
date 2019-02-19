package com.soft.sh.teach.ui.fragment;

import com.soft.sh.teach.R;
import com.soft.sh.teach.databinding.FragmentTypeBinding;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.base.BaseFragment;

public class TypeFragment extends BaseFragment<FragmentTypeBinding> {

    public void initToolBar() {
    }

    @Override
    public void initView(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.fragment_type;
    }

    @Override
    public void initData() {
        initToolBar();

    }

    @Override
    public void initEvent() {
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
