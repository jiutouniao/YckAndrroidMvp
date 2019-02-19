package com.ys.jsst.pmis.commommodule.presenter;


import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ys.jsst.pmis.commommodule.util.LogUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 图片加载帮助类
 */
public class GlidePresenter {



    static String encode="";

    /***
     * 采用glide 加载方形图片， 防止第一次不显示
     * @param context
     * @param imageUrl
     * @param errorImageId
     * @param imageView
     */
    public static void loadRectImage(final Context context, final String imageUrl, int errorImageId, final ImageView imageView, RequestListener listener) {
        LogUtil.d("loadRectImage : "+ imageUrl);

        try {
            Glide.with(context)
                    .load(imageUrl)
                    .asBitmap()
                    .centerCrop()
                    .listener(listener)
                    .placeholder(errorImageId)
                    .error(errorImageId)
                    .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    /***
//     * 采用glide 加载圆形图片， 防止第一次不显示
//     * @param context
//     * @param imageUrl
//     * @param errorImageId
//     * @param imageView
//     */
//    public static void loadRectImage(final Context context, final String imageUrl, int errorImageId, final ImageView imageView, RequestListener listener) {
//        LogUtil.d("loadRectImage : "+ imageUrl);
//
//        try {
//            Glide.with(context)
//                    .load(imageUrl)
//                    .asBitmap()
//                    .centerCrop()
//                    .listener(listener)
//                    .placeholder(errorImageId)
//                    .error(errorImageId)
//                    .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
//                    .into(new BitmapImageViewTarget(imageView) {
//                        @Override
//                        protected void setResource(Bitmap resource) {
//                            try {
//                                RoundedBitmapDrawable circularBitmapDrawable =
//                                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
//                                circularBitmapDrawable.setCircular(true);
//                                imageView.setImageDrawable(circularBitmapDrawable);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    /***
     * 采用glide 加载方形图片， 防止第一次不显示
     * @param context
     * @param imageUrl
     * @param errorImageId
     * @param imageView
     */
    public static void loadRectImage(final Context context, final String imageUrl, int errorImageId, final ImageView imageView) {
        LogUtil.d("loadRectImage : "+ imageUrl);

        try {
            Glide.with(context)
                    .load(imageUrl)
                    .asBitmap()
                    .centerCrop()
                    .placeholder(errorImageId)
                    .error(errorImageId)
                    .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    /***
//     * 采用glide 加载圆形图片， 防止第一次不显示
//     * @param context
//     * @param imageUrl
//     * @param errorImageId
//     * @param imageView
//     */
//    public static void loadRectImage(final Context context, final String imageUrl, int errorImageId, final ImageView imageView) {
//        LogUtil.d("loadRectImage : "+ imageUrl);
//
//        try {
//            Glide.with(context)
//                    .load(imageUrl)
//                    .asBitmap()
//                    .centerCrop()
//                    .placeholder(errorImageId)
//                    .error(errorImageId)
//                    .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
//                    .into(new BitmapImageViewTarget(imageView) {
//                        @Override
//                        protected void setResource(Bitmap resource) {
//                            try {
//                                RoundedBitmapDrawable circularBitmapDrawable =
//                                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
//                                circularBitmapDrawable.setCircular(true);
//                                imageView.setImageDrawable(circularBitmapDrawable);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /***
     * 采用glide 加载方形图片， 不加载默认图片
     * @param context
     * @param imageUrl
     * @param imageView
     */
    public static void loadRectImage(final Context context, final String imageUrl , final ImageView imageView) {
        LogUtil.d("loadRectImage : "+ imageUrl);

        try {
            Glide.with(context)
                    .load(imageUrl)
                    .asBitmap()
                    .centerCrop()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    /***
//     * 采用glide 加载圆形图片， 不加载默认图片
//     * @param context
//     * @param imageUrl
//     * @param imageView
//     */
//    public static void loadRectImage(final Context context, final String imageUrl , final ImageView imageView) {
//        LogUtil.d("loadRectImage : "+ imageUrl);
//
//        try {
//            Glide.with(context)
//                    .load(imageUrl)
//                    .asBitmap()
//                    .centerCrop()
//                    .into(new BitmapImageViewTarget(imageView) {
//                        @Override
//                        protected void setResource(Bitmap resource) {
//                            try {
//                                RoundedBitmapDrawable circularBitmapDrawable =
//                                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
//                                circularBitmapDrawable.setCircular(true);
//                                imageView.setImageDrawable(circularBitmapDrawable);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    /***
     * 采用glide 加载图片， 防止第一次不显示
     * @param context
     * @param imageUrl
     * @param errorImageId
     * @param imageView
     */
    public static void loadImage(Context context,  String imageUrl, int errorImageId, final ImageView imageView) {

        //后台链接错误，去掉带的参数
        /*LogUtil.d("loadImage 0 : "+ imageUrl);
        int index = imageUrl.indexOf("?");
        if(index>0){
            imageUrl=imageUrl.substring(0,index);
        }
        LogUtil.d("loadImage : "+ imageUrl);*/

        String[] split = imageUrl.split("=");
        if (split != null && split.length > 1) {
            try {
                encode = URLEncoder.encode(split[1], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            imageUrl = split[0] + "=" + encode;
        }
        try {
            Glide.with(context)
                    .load(imageUrl)
//                    .thumbnail(0.1f) //加载缩略图
                    .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
//                    .animate(R.anim.item_alpha_in) //加载进入动画
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            LogUtil.e("GlidePresenter : " ,e);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            LogUtil.e("GlidePresenter : "+isFromMemoryCache +"   "+ isFirstResource+"  " );

                            return false;
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    // 展示在控件中大小图片尺寸和原图都会缓存
                    .placeholder(errorImageId)
                    .error(errorImageId)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * 自适应宽度加载图片。保持图片的长宽比例不变，通过修改imageView的高度来完全显示图片。
     * loadIntoUseFitWidth(mContext, url, R.drawable.blank, holder.imageView);
     * @param context
     * @param imageUrl
     * @param errorImageId
     * @param imageView
     */
    public static void loadIntoUseFitWidth(Context context, final String imageUrl, int errorImageId, final ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        if (imageView == null) {
                            return false;
                        }
                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
                        params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
                        imageView.setLayoutParams(params);
                        return false;
                    }
                })
                .placeholder(errorImageId)
                .error(errorImageId)
                .into(imageView);
    }








}
