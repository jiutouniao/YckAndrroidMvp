package com.soft.yck.home.ui.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.soft.yck.home.R;
import com.soft.yck.home.bean.Bookbean;
import com.soft.yck.home.databinding.StackItemListBinding;
import com.ys.jsst.pmis.commommodule.base.MyBaseHolder;
import com.ys.jsst.pmis.commommodule.constant.HttpConstant;
import com.ys.jsst.pmis.commommodule.util.StringUtils;

/**
 * description:书架1
 * 2017-9-11
 * User: jiangdong
 */
public class HomeHolder extends MyBaseHolder<Bookbean, StackItemListBinding> {

    private Context mContext;

    public HomeHolder(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    @Override
    protected int itemResId() {
        return R.layout.stack_item_list;
    }

    @Override
    protected void onBindViewHolder1(final @NonNull ViewHolder<StackItemListBinding> holder, @NonNull final Bookbean item) {
        if (holder == null || item == null){
            return;
        }
        //名称
        holder.binding.tvTitle.setText(item.getResource_name());
        //图片
        Glide.with(mContext)
                .load(HttpConstant.getFilePath(item.getThumb_pic()))
                .placeholder(R.drawable.read_shape_gray)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into( holder.binding.ivImage);
        //作者
        holder.binding.tvName.setText(item.getAuthor());

        //描述
        if(StringUtils.isEmpty(item.getResource_desc())){
            holder.binding.tvDesc.setText("暂无描述");
        }else{
            holder.binding.tvDesc.setText(item.getResource_desc());
        }
        //数量
        holder.binding.tvNumber.setText(item.getResource_browse_count()+"人看过");
        //点击跳转详情
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

}
