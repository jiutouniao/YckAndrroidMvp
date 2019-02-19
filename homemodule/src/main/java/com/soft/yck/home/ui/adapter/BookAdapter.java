package com.soft.yck.home.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.soft.yck.home.R;
import com.soft.yck.home.bean.Bookbean;
import com.soft.yck.home.databinding.StackItemListBinding;
import com.ys.jsst.pmis.commommodule.constant.HttpConstant;
import com.ys.jsst.pmis.commommodule.presenter.TextViewPresenter;
import com.ys.jsst.pmis.commommodule.util.StringUtils;

import java.util.List;

/**
 * description:党建
 * User: shaobing
 * Date: 2016-06-07
 * Time: 18:35
 */
public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    //选项链接
    private List<Bookbean> mList;

    private OnItemClickListener mListener;
    /**
     * 设置onItemClick监听
     * @param mListener listener
     */
    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public BookAdapter(Context mContext, List<Bookbean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setData(List<Bookbean> mList ) {
        this.mList = mList;

        this.notifyDataSetChanged();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private StackItemListBinding binding;

        public ViewHolder1(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = (StackItemListBinding) binding;
        }
        public StackItemListBinding getBinding() {
            return binding;
        }
        public void setBinding(StackItemListBinding binding) {
            this.binding = binding;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        StackItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.stack_item_list, viewGroup, false);
        return new ViewHolder1(binding);
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if (mList==null || mList.size()<=position){
           return;
       }
        if (viewHolder instanceof ViewHolder1) {
            //名称
            TextViewPresenter.setText(((ViewHolder1) viewHolder).getBinding().tvTitle,mList.get(position).getResource_name());
            //图片
            Glide.with(mContext)
                    .load(HttpConstant.getFilePath(mList.get(position).getThumb_pic()))
                    .placeholder(R.drawable.read_shape_gray)
                    .thumbnail(0.1f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(((ViewHolder1) viewHolder).getBinding().ivImage);

            //作者
            TextViewPresenter.setText(((ViewHolder1) viewHolder).getBinding().tvName,mList.get(position).getAuthor());
            //描述
            if(StringUtils.isEmpty(mList.get(position).getResource_desc())){
                ((ViewHolder1) viewHolder).getBinding().tvDesc.setText("暂无描述");
            }else{
                ((ViewHolder1) viewHolder).getBinding().tvDesc.setText(mList.get(position).getResource_desc());
            }
            //数量
            ((ViewHolder1) viewHolder).getBinding().tvNumber.setText(mList.get(position).getResource_browse_count()+"人看过");
            //点击跳转详情
            ((ViewHolder1) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int pos = viewHolder.getPosition();
                        mListener.onItemClick(pos);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(mList==null){return 0;}
        return mList.size();
    }

    /**
     * description: 设置item点击监听
     * User: shaobing
     * Date: 2016/6/12
     * Time: 17:08
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }




}
