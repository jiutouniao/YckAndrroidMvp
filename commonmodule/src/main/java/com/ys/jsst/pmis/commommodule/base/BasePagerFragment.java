package com.ys.jsst.pmis.commommodule.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ys.jsst.pmis.commommodule.util.LogUtil;

/**
 * description:fragment基类
 * Date: 2016/6/15
 * Time: 16:17
 */
public abstract class BasePagerFragment<B extends ViewDataBinding> extends Fragment {

  public B mViewBinding;
  private BaseAttribute attribute =new BaseAttribute();

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
   * 界面初始化
   *
   * @return
   */
  public abstract void initView(BaseAttribute attribute);

  /**
   * 数据初始化
   */
  protected void initData() {}

  /**
   * 事件初始化
   */
  protected void initEvent() {}

}