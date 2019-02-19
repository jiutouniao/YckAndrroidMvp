package com.ys.jsst.pmis.commommodule.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;

/** 
 * Name: MyBaseHolder  
 * Date: 2017-5-22  9:39  
 * Desc: wow
 * 
 * @author zengzheng
 */
public abstract class MyBaseHolder<B, M extends ViewDataBinding> extends ItemViewBinder {

  private Context mContext;

  public MyBaseHolder(Context mContext) {
    this.mContext = mContext;
  }

  public Context getmContext() {
    return mContext;
  }

  public void setmContext(Context mContext) {
    this.mContext = mContext;
  }

  public class ViewHolder<BINDING> extends RecyclerView.ViewHolder {
      public BINDING binding;

    public ViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = (BINDING) binding;
      }

    public BINDING getBinding() {
      return binding;
    }

    public void setBinding(BINDING binding) {
      this.binding = binding;
    }
  }

  @NonNull @Override protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater,
      @NonNull ViewGroup viewGroup) {
    M binding =
        DataBindingUtil.inflate(LayoutInflater.from(mContext), itemResId(), viewGroup,
            false);
    return new ViewHolder(binding);
  }

  @Override
  protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item) {
    onBindViewHolder1((ViewHolder<M>)holder,(B) item);
  }

  ///////////////////////////////////////////////////////////////////////////
  // 子类重写的方法
  ///////////////////////////////////////////////////////////////////////////
  protected abstract int itemResId();

  protected abstract void onBindViewHolder1(@NonNull ViewHolder<M> holder, @NonNull B item);
}
