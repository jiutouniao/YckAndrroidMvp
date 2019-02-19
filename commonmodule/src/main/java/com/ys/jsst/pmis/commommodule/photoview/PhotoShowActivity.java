package com.ys.jsst.pmis.commommodule.photoview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.base.BaseActivity;
import com.ys.jsst.pmis.commommodule.base.BaseAttribute;
import com.ys.jsst.pmis.commommodule.constant.HttpConstant;
import com.ys.jsst.pmis.commommodule.databinding.ActivityPhotoShowBinding;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created on 2016/7/19.
 * Author:crs
 * Description:XXX
 */
public class PhotoShowActivity extends BaseActivity<ActivityPhotoShowBinding>{

    private int position;
    private String[] mDatas;
    private int mType =-1;


    @Override
    protected void onInitAttribute(BaseAttribute attribute) {

        attribute.mLayoutId = R.layout.activity_photo_show;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //不显示程序的标题栏
        requestWindowFeature( Window.FEATURE_NO_TITLE );

        //不显示系统的标题栏
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        super.onCreate(savedInstanceState);

        initView();
    }

    protected void initView() {

        getFrontPageData();
        initViews();
    }



    private void initViews() {


        mViewBinding.hViewPager.setAdapter(new ImageAdapter());
        //为ViewPager当前page的数字
        mViewBinding.hViewPager.setCurrentItem(position);
        mViewBinding.hViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewBinding.photoNum.setText((position+1)+"/"+mDatas.length);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void getFrontPageData() {
        //点击图片的位置
        position = getIntent().getIntExtra("position", 0);
//        mType = getIntent().getIntExtra(Constants.TYPE, -1);
        System.out.println(mType);
        //获取传递过来的图片地址
        mDatas = getIntent().getStringArrayExtra("mImages");
        mViewBinding.photoNum.setText((position+1)+"/"+mDatas.length);
        Log.d("PhotoShowActivity", "mDatas:" + new Gson().toJson(mDatas));
    }



    public class ImageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return null == mDatas ? 0 : mDatas.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //创建显示图片的控件
            PhotoView photoView = new PhotoView(container.getContext());
            //设置背景颜色
            photoView.setBackgroundColor(Color.BLACK);
            //把photoView添加到viewpager中，并设置布局参数
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //加载当前PhtotoView要显示的数据
            String url = mDatas[position];
            if (!TextUtils.isEmpty(url)) {
                //使用使用Glide进行加载图片进行加载图片

//                GlidePresenter.loadIntoUseFitWidth(PhotoShowActivity.this,url,R.drawable.);
                Glide.with(PhotoShowActivity.this).load(HttpConstant.getFilePath(url)).into(photoView);
            }

            //图片单击事件的处理
            photoView.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
                @Override
                public void onViewTap(View view, float x, float y) {
                    finish();
                }
            });
            return photoView;
        }

    }
}
