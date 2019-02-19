package com.soft.sh.my.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.soft.sh.my.R;
import com.soft.sh.my.databinding.MyActivityFeedbackBinding;
import com.ys.jsst.pmis.commommodule.base.BaseActivity;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.ui.widget.EmojiFilter2;
import com.ys.jsst.pmis.commommodule.util.LengthFilter;
import com.ys.jsst.pmis.commommodule.util.ToastUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * description: 模块
 * 2017-11-15
 * User: jiangdong
 */
public class FeedbackActivity extends BaseActivity<MyActivityFeedbackBinding> {

    @Override
    protected void onInitAttribute(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.my_activity_feedback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
        initView();
        initData();
        initEvent();
    }

    public void initToolBar() {
        setSupportActionBar(mViewBinding.toolBar.toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            mViewBinding.toolBar.toolBar.setNavigationIcon(R.drawable.ic_back_black);
            mViewBinding.toolBar.ivToolBarRight.setVisibility(View.VISIBLE);
            mViewBinding.toolBar.tvToolBarRight.setVisibility(View.VISIBLE);
            mViewBinding.toolBar.tvToolBarRight.setText("确定");
            //            mViewBinding.toolBar.ivToolBarRight.setImageResource(R.drawable.seek);
            mViewBinding.toolBar.tvToolBarTitle.setText("意见反馈");
        }
    }

    public void initView() {
    }

    public void initData() {
        mViewBinding.etContent.setFilters(new InputFilter[]{new LengthFilter(this, 200), new EmojiFilter2()});
        mViewBinding.etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 200) {
                    mViewBinding.tvNum.setText("0字");
                } else {
                    int number = 200 - s.length();
                    mViewBinding.tvNum.setText(number + "字");
                }
            }
        });
    }

    public void initEvent() {
        //确定 上传多个图片
        mViewBinding.toolBar.tvToolBarRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mViewBinding.etContent.getText().toString())) {
                } else {
                    ToastUtil.showLongToast(FeedbackActivity.this, "请输入内容");
                }
            }
        });
        //选择图片
        mViewBinding.ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
