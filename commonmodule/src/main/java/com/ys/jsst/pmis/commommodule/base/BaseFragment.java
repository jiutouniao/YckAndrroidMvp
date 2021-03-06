package com.ys.jsst.pmis.commommodule.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ys.jsst.pmis.commommodule.ui.dialog.LoadDialog;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

import org.greenrobot.eventbus.Subscribe;

/**
 * description:fragment基类
 * Date: 2016/6/15
 * Time: 16:17
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

  public B mViewBinding;
  private BaseAttribute attribute =new BaseAttribute();
  private LoadDialog mCustomDialog;

  /*
   * 返回一个需要展示的View
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    initView(attribute);
    mViewBinding = DataBindingUtil.inflate(inflater,attribute.mLayoutId, container, false);
    return mViewBinding.getRoot();
  }
  /*
   * 当Activity初始化之后可以在这里进行一些数据的初始化操作
   */
  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    LogUtil.d("onActivityCreated");
    super.onActivityCreated(savedInstanceState);
    initData();
    initEvent();
  }


  /**
   * 显示对话框
   */
  public void showDialog() {

    LogUtil.d("getActivity()  :"+getContext());
    if(getContext()!=null){
      mCustomDialog = new LoadDialog(getContext());
      mCustomDialog.show();
    }

  }



  /**
   * 取消对话框
   */
  public void dismissDialog() {
    if (mCustomDialog != null) {
        mCustomDialog.dismiss();
        mCustomDialog = null;
    }
  }


  @Override
  public void onDestroyView() {
    super.onDestroyView();
    dismissDialog();
  }

  /**
   * 子类实现此抽象方法返回View进行展示
   *
   * @return
   */
  public abstract void initView(BaseAttribute attribute);

  /**
   * 子类在此方法中实现数据的初始化
   */
  protected void initData() {}

  /**
   * 子类可以复写此方法初始化事件
   */
  protected void initEvent() {}

}