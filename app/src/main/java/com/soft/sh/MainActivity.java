package com.soft.sh;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.widget.RadioGroup;

import com.soft.sh.app.ui.fragment.AppFragment;
import com.soft.sh.bean.UpdateBean;
import com.soft.sh.databinding.AppActivityMainBinding;
import com.soft.sh.my.ui.fragment.MyFragment;
import com.soft.sh.presenter.AppPresenter;
import com.soft.sh.teach.ui.fragment.TeachFragment;
import com.soft.sh.utils.RuntimeRationale;
import com.soft.sh.utils.RuntimeRationale2;
import com.soft.sh.view.AppView;
import com.soft.yck.home.ui.fragment.HomeFrament;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.base.BaseMvpActivity;
import com.ys.jsst.pmis.commommodule.sharepreference.SharedPreferenceUtils;
import com.ys.jsst.pmis.commommodule.util.IntegerUtil;
import com.ys.jsst.pmis.commommodule.util.LogUtil;
import com.ys.jsst.pmis.commommodule.util.manager.UpdateManager;

import java.util.List;

public class MainActivity extends BaseMvpActivity<AppActivityMainBinding,AppPresenter>implements AppView {

    // 申请多个权限。
    private String[]  mPermissions ={Permission.WRITE_EXTERNAL_STORAGE,Permission.READ_EXTERNAL_STORAGE,Permission.CAMERA};
    private Fragment mFragment1;
    private Fragment mFragment2;
    private Fragment mFragment3;
    private Fragment mFragment4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPermission(false);
        initView();
        initData();
        initEvent();
    }

    @Override
    protected void onInitAttribute(BaseAttribute attribute) {
        mPresenter = new AppPresenter();
        attribute.mLayoutId = R.layout.app_activity_main;


    }

    private void initView() {

    }

    private void initData() {
        mViewBinding.rgMainRadio.check(mViewBinding.rgMainRadio.getChildAt(0).getId());
        handleFragment(1);
        //获取最近版本
//        mPresenter.getLatestApp("read_android");
    }

    private void initEvent() {
        mViewBinding.rgMainRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.rb_1) {
                    handleFragment(1);
                } else if (checkedId == R.id.rb_2) {
                    handleFragment(2);
                } else if (checkedId == R.id.rb_3) {
                    handleFragment(3);
                }else if (checkedId == R.id.rb_4) {
                    handleFragment(4);
                }
            }
        });
    }


    private void handleFragment(int state) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
        hideFragment(mFragment1);
        hideFragment(mFragment2);
        hideFragment(mFragment3);
        hideFragment(mFragment4);
        switch (state) {
            case 1: {
                if (mFragment1 == null) {
                    mFragment1 = HomeFrament.getInstance("");
                    addFragment(mFragment1, R.id.flyt_read);
                } else {
                    showFragment(mFragment1);
                }
                break;
            }
            case 2: {
                if (mFragment2 == null) {
                    mFragment2 = AppFragment.getInstance();
                    addFragment(mFragment2, R.id.flyt_read);
                } else {
                    showFragment(mFragment2);
                }
                break;
            }
            case 3: {
                if (mFragment3 == null) {
                    mFragment3 =  TeachFragment.getInstance();
                    addFragment(mFragment3, R.id.flyt_read);
                } else {
                    showFragment(mFragment3);
                }
                break;
            }
            case 4: {
                if (mFragment4 == null) {
                    mFragment4 = MyFragment.getInstance();
                    addFragment(mFragment4, R.id.flyt_read);
                }
                showFragment(mFragment4);
                break;
            }
            default: {
                if (mFragment1 == null) {
                    mFragment1 =  HomeFrament.getInstance("");
                    addFragment(mFragment1, R.id.flyt_read);
                }
                showFragment(mFragment1);
                break;
            }
        }
    }

    /**
     * 隐藏不该显示的Fragment
     *
     * @param fragment--要隐藏的Fragment
     */
    private void hideFragment(Fragment fragment) {
        LogUtil.d("hideFragment " + fragment);
        if (fragment != null) {
            FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
            mFragmentTransaction.hide(fragment);
            mFragmentTransaction.commit();
        }
    }

    /**
     * 显示的Fragment
     *
     * @param fragment--要显示的Fragment
     */
    private void showFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
            mFragmentTransaction.show(fragment);
            mFragmentTransaction.commit();
        }
    }

    /**
     * 添加fragment
     *
     * @param fragment
     * @param containerId
     */
    private void addFragment(Fragment fragment, int containerId) {
        if (fragment != null) {
            FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
            mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            mFragmentTransaction.add(containerId, fragment);
            mFragmentTransaction.commit();
        }
    }

    /**
     *
     * @param flag true代表拒绝权限之后请求权限， false刚刚进入请求权限
     */
    public void getPermission(boolean flag){
        AndPermission.with(this)
                .runtime()
                .permission(mPermissions)
                .rationale(flag?new RuntimeRationale2():new RuntimeRationale())//new RuntimeRationale()
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> permissions) {
                        LogUtil.e("showSettingDialog(MainActivity.this, permissions)======"+permissions.get(0));
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
                        LogUtil.e("onAction --->onDenied");
                        showDialog();
                    }
                })
                .start();
    }


    public void showDialog(){
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("警告！")
                .setMessage("禁止权限将导致App无法运行。")
                .setPositiveButton("重新获取", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPermission(true);
                    }
                })
                .setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }

    @Override
    public void showLatestApp(UpdateBean bean) {
        if (bean == null || bean.getData() == null) return;
        if ("SUCCESS".equals(bean.getRetCode())) {
            UpdateManager manager = new UpdateManager(this);
            manager.checkUpdate(IntegerUtil.getInteger(bean.getData().getVersion_code()), false);
            SharedPreferenceUtils.saveVersion(bean.getData().getVersion_code());
            SharedPreferenceUtils.saveVersionPath(bean.getData().getPath());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
