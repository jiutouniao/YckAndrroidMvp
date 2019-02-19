package com.ys.jsst.pmis.commommodule.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:调用系统相册和拍照
 * Date: 2016/7/5 9:04
 * User: xiaobin
 */
public class ObtainAvatarUtil {
    public static final String LOG_TAG = ObtainAvatarUtil.class.getSimpleName();
    public static final int REQUEST_CAMERA_WITH_DATA = 0; // 拍照
    public static final int REQUEST_PHOTO_PICKED_DATA = 1; // 相册
    public static final int REQUEST_CROP_DATA = 2;//裁剪

    private static final int ratioX = 1;
    private static final int ratioY = 1;

    public static final String CROP_RESULT_DIR = FileUtils.getHeadDir()+"icon.jpg";
    private static ObtainAvatarUtil mObtainAvatarUtil;

    public static ObtainAvatarUtil getInstance() {
        if (null == mObtainAvatarUtil) {
            mObtainAvatarUtil = new ObtainAvatarUtil();
        }
        return mObtainAvatarUtil;
    }

    /**
     * 调用系统拍照功能
     *
     * @param activity
     */
    public void getPicFromCapture(Activity activity) {
        Intent intent = getCameraIntent();
        activity.startActivityForResult(intent, REQUEST_CAMERA_WITH_DATA);
    }

    /**
     * 调用系统拍照功能
     * @param activity
     * @param path 拍照路径
     */
    public  void getPicFromCapture(Activity activity, String path) {
        File cameraPhoto = new File(path);
        Uri photoUri = FileProvider.getUriForFile(
                activity,
                "com.ssdy.people.readlib.provider",
                cameraPhoto);
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,0.4);   //设置质量
        activity.startActivityForResult(intent, REQUEST_CAMERA_WITH_DATA);



        /*Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        activity.startActivityForResult(takePhotoIntent,  REQUEST_CAMERA_WITH_DATA);*/
    }


    public static Intent getCameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(CROP_RESULT_DIR)));
        return intent;
    }

    /**
     * 调用系统相册
     *
     * @param activity
     */
    public void getPicFromContent(Activity activity) {
        Intent intent = getPhotoPickIntent();
        activity.startActivityForResult(intent, REQUEST_PHOTO_PICKED_DATA);
    }



    /**
     * 用当前时间作为图片名字给图片命名
     */
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }


    /**
     * 获取相册intent
     */
    private Intent getPhotoPickIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI,"image/*");
        return intent;
    }

    /**
     * 启动gallery去剪辑这个照片
     * @param activity
     */
    public void doCropPhoto(Activity activity , Uri uri) {
        Intent intent = getCropImageIntent(uri);
        activity.startActivityForResult(intent, REQUEST_CROP_DATA);
    }

    /**
     * Constructs an intent for image cropping. 调用图片剪辑程序 剪裁后的图片跳转到新的界面
     *
     * @param photoUri
     */
    private Intent getCropImageIntent(Uri photoUri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(photoUri, "image/*");

        //crop = true是设置在开启Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        //是否去除面部检测， 如果你需要特定的比例去裁剪图片，那么这个一定要去掉，因为它会破坏掉特定的比例
        intent.putExtra("noFaceDetection", true);
        //是否需要保持比例
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", ratioX);
        intent.putExtra("aspectY", ratioY);
        intent.putExtra("outputX", 500);
        intent.putExtra("outputY", 500);
        //缩放避免裁剪后的黑边
        intent.putExtra("scale",true);
        intent.putExtra("scaleUpIfNeeded", true);
        //return-data = true 设置返回处理后的bitmap
        intent.putExtra("return-data", false);
//        FileUtils.createDirs(new File(CROP_RESULT_DIR).getParent());
        //MediaStore.EXTRA_OUTPUT 是处理图片的存放位置
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(CROP_RESULT_DIR)));
        LogUtil.d("mData--"+photoUri  + "========" +Uri.fromFile(new File(CROP_RESULT_DIR)) );
        return intent;
    }

    /**
     * 启动gallery去剪辑这个照片
     * @param activity
     */
    public void doCropPhoto2(Activity activity, String cachePath) {
        Intent intent = getCropImageIntent2(activity,cachePath);
        activity.startActivityForResult(intent, REQUEST_CROP_DATA);
    }
    /**
     * 根据文件裁剪图片
     * @param context
     * @return
     */
    private Intent getCropImageIntent2(Activity context, String cachePath) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        LogUtil.d("cachePath :"+cachePath);
        File cameraPhoto = new File(cachePath);
        Uri photoUri = FileProvider.getUriForFile(
                context,
                "com.ssdy.people.readlib.provider",
                cameraPhoto);
        intent.setDataAndType(photoUri, "image/*");
        //crop = true是设置在开启Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        //是否去除面部检测， 如果你需要特定的比例去裁剪图片，那么这个一定要去掉，因为它会破坏掉特定的比例
        intent.putExtra("noFaceDetection", true);
        //是否需要保持比例
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", ratioX);
        intent.putExtra("aspectY", ratioY);
        intent.putExtra("outputX",500);
        intent.putExtra("outputY",500);
        //return-data = true 设置返回处理后的bitmap
        intent.putExtra("return-data", false);
//        FileUtils.createDirs(new File(CROP_RESULT_DIR).getParent());
        //MediaStore.EXTRA_OUTPUT 是处理图片的存放位置
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        return intent;
    }


}
