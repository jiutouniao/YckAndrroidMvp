package com.soft.sh.my.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.soft.sh.my.R;
import com.soft.sh.my.databinding.MyFragmentMyBinding;
import com.soft.sh.my.ui.activity.FeedbackActivity;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.base.BaseFragment;

public class MyFragment extends BaseFragment<MyFragmentMyBinding> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public static MyFragment getInstance() {
        MyFragment bookFrament = new MyFragment();
        return bookFrament;
    }



    public void initToolBar() {

    }


    @Override
    public void initView(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.my_fragment_my;

    }

    @Override
    public void initData() {
    }

    @Override
    public void initEvent() {
        mViewBinding.tvMyOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //意见反馈
                Intent intent = new Intent(getActivity(), FeedbackActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
