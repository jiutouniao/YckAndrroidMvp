package com.ssdy.people.read.login.ui.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.soft.xiren.db.ebook.bean.LoginDbBean;
import com.ssdy.people.read.login.R;
import com.ssdy.people.read.login.bean.LoginBean;
import com.ssdy.people.read.login.databinding.LoginActivityLoginsBinding;
import com.ssdy.people.read.login.presenter.LoginPresenter;
import com.ssdy.people.read.login.ui.widegt.LoginUtils;
import com.ssdy.people.read.login.view.LoginView;
import com.ys.jsst.pmis.commommodule.base.AppContext;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.base.BaseMvpActivity;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.StringUtils;
import com.ys.jsst.pmis.commommodule.util.ToastUtil;
import org.litepal.crud.DataSupport;
import java.util.List;


/**
 * 登陆界面
 * Created by amos on 2017/10/10.
 */

public class LoginsActivity extends BaseMvpActivity<LoginActivityLoginsBinding,LoginPresenter> implements LoginView{



    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    @Override
    protected void onInitAttribute(BaseAttribute attribute) {
        mPresenter = new LoginPresenter();
        attribute.mLayoutId = R.layout.login_activity_logins;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initEvent();
    }
    private void initData() {

    }

    private void initEvent() {
        mViewBinding.cetUserId.setText("guest_008");
        mViewBinding.cetPassWord.setText("123456");
        handleLogin();
        //登陆
        mViewBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                mPresenter.login(mViewBinding.cetUserId.getText().toString(), mViewBinding.cetPassWord.getText().toString());
            }
        });

        //用户名/手机号
        mViewBinding.cetUserId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                handleLogin();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //密码
        mViewBinding.cetPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                handleLogin();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //明密文密码显示
        mViewBinding.ivSeePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUtils.getInstance().ciphertextDisplay(mViewBinding.ivSeePassword, mViewBinding.cetPassWord);
            }
        });
    }


    private void handleLogin(){
        if(StringUtils.isNotEmpty(mViewBinding.cetUserId.getText().toString()) && StringUtils.isNotEmpty( mViewBinding.cetPassWord.getText().toString()) &&
                mViewBinding.cetPassWord.getText().toString().length()>=6 && mViewBinding.cetPassWord.getText().toString().length()<=20){
            mViewBinding.tvLogin.setBackgroundResource(R.drawable.login_shape_login_corner_affirm_bg);
            mViewBinding.tvLogin.setEnabled(true);
        }else{
            mViewBinding.tvLogin.setBackgroundResource(R.drawable.login_shape_login_corner_deny_bg);
            mViewBinding.tvLogin.setEnabled(false);
        }
    }

    @Override
    public void showError() {
        LogUtil.e("showError");
        dismissDialog();
    }

    @Override
    public void showNoNetwork() {
        LogUtil.e("showNoNetwork");
        dismissDialog();
        ToastUtil.showShortToast(LoginsActivity.this,"网络连接失败，请重新连接网络");
    }

    @Override
    public void showLogin(LoginBean bean) {
        dismissDialog();
        if (bean.getRetCode().equals("SUCCESS")) {
            saveSharedInfo(bean);
        } else {
            ToastUtil.showLongToast(LoginsActivity.this, getString(R.string.login_failure));
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * @param bean 登录返回的bean
     */
    private void saveSharedInfo(LoginBean bean) {
        //获取返回的数据并保存
        SharedPreferenceUtils.saveUser_id(bean.getUser_id());
        SharedPreferenceUtils.savePassWord(bean.getPassword());
        SharedPreferenceUtils.saveHeadImage(bean.getHead_image());
        SharedPreferenceUtils.saveNickName(bean.getNickname());
        SharedPreferenceUtils.saveToken(bean.getToken());
        SharedPreferenceUtils.saveSex(bean.getSex());
        SharedPreferenceUtils.saveSelfIntroduction(bean.getSelf_introduction());
        SharedPreferenceUtils.saveExperience(bean.getExperience() + "");
        SharedPreferenceUtils.saveScore(bean.getScore() + "");
        SharedPreferenceUtils.saveReadTime(bean.getRead_time() + "");
        SharedPreferenceUtils.saveReadCount(bean.getRead_count() + "");
        SharedPreferenceUtils.saveTestCount(bean.getTest_count() + "");
        SharedPreferenceUtils.saveSignCount(bean.getSign_count());
        SharedPreferenceUtils.saveSignDays(bean.getSign_days());
        SharedPreferenceUtils.saveDoId(bean.getCo_id()); //保存组织机构
        List<LoginDbBean> all = DataSupport.findAll(LoginDbBean.class);
        if (all.size() == 0) {
            LoginDbBean bean1 = new LoginDbBean();
            bean1.setToken_desc(bean.getToken());
            bean1.setToken("token");
            bean1.setUser_id(bean.getUser_id());
            bean1.save();
        }else {
            ContentValues values = new ContentValues();
            values.put("token_desc", bean.getToken());
            values.put("user_id", bean.getUser_id());
            LoginDbBean.updateAll(LoginDbBean.class, values, "token = ?", "token");
        }
        //跳转首页
        Intent intent = new Intent().setClassName(AppContext.getmAppContext(),"com.soft.sh.MainActivity");
        startActivity(intent);
//        //跳转首页
        finish();
    }

}
