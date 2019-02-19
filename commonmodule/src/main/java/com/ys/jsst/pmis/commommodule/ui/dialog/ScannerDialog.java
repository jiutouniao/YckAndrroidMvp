//package com.ys.jsst.pmis.commommodule.ui.dialog;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.graphics.Color;
//import android.os.Handler;
//import android.view.View;
//
//import com.ys.jsst.pmis.commommodule.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import me.dm7.barcodescanner.zbar.BarcodeFormat;
//import me.dm7.barcodescanner.zbar.Result;
//import me.dm7.barcodescanner.zbar.ZBarScannerView;
//
///**
// * Name: ScannerDialog
// * Date: 2017-8-24  15:00
// * Desc: 扫一扫
// *
// * @author zengzheng
// */
//public class ScannerDialog implements ZBarScannerView.ResultHandler{
//
//    private Activity mActivity;
//
//    private AlertDialog mScannerDialog;
//
//    private ZBarScannerView mScannerView;
//
//
//    public ScannerDialog(Activity mActivity, OnHandleResultListener onHandleResultListener) {
//
//        this.mActivity = mActivity;
//        this.onHandleResultListener = onHandleResultListener;
//
//        mScannerView = new ZBarScannerView(mActivity);
//    }
//
//
//    public ScannerDialog config(){
//        //自动对焦
//        mScannerView.setAutoFocus(true);
//        //识别的各种码
//        List<BarcodeFormat> ALL_FORMATS = new ArrayList<>();
//        //ALL_FORMATS.add(BarcodeFormat.UPC_A);
//        //ALL_FORMATS.add(BarcodeFormat.UPC_E);
//        //ALL_FORMATS.add(BarcodeFormat.EAN_13);
//        //ALL_FORMATS.add(BarcodeFormat.EAN_8);
//        //ALL_FORMATS.add(BarcodeFormat.RSS_14);
//        //ALL_FORMATS.add(BarcodeFormat.CODE_39);
//        //ALL_FORMATS.add(BarcodeFormat.CODE_93);
//        //ALL_FORMATS.add(BarcodeFormat.CODE_128);
//        //ALL_FORMATS.add(BarcodeFormat.ITF);
//        ALL_FORMATS.add(BarcodeFormat.CODABAR);
//        ALL_FORMATS.add(BarcodeFormat.QRCODE);
//        mScannerView.setFormats(ALL_FORMATS);
//
//        mScannerView.setBackgroundColor(Color.BLACK);
//
//        //处理结果
//        mScannerView.setResultHandler(this);
//
//        return this;
//    }
//
//    public ScannerDialog show(View view) {
//            mScannerDialog = new AlertDialog.Builder(mActivity, R.style.Theme_AppCompat_Light_DialogWhenLarge)
//                    .setView(mScannerView)
//                    .setCancelable(true)
//                    .setOnCancelListener(new DialogInterface.OnCancelListener() {
//                        @Override
//                        public void onCancel(DialogInterface dialog) {
//                            mScannerView.stopCamera();
//                            mScannerDialog.dismiss();
//                        }
//                    })
//                    .create();
//        mScannerDialog.show();
//        mScannerView.startCamera();
//        return this;
//    }
//
//    @Override
//    public void handleResult(Result result) {
//        onHandleResultListener.handeResult(result.getContents());
//        mScannerView.stopCamera();
//        mScannerDialog.dismiss();
//
//
//        // Note: 不知道为啥就是要这句 没这句连续操作就会识别不出
//        //作者原话
//        // * Wait 2 seconds to resume the preview.
//        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
//        // * I don't know why this is the case but I don't have the time to figure out.
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mScannerView.resumeCameraPreview(ScannerDialog.this);
//            }
//        }, 2000);
//    }
//
//    private OnHandleResultListener onHandleResultListener;
//
//    public interface OnHandleResultListener{
//        void handeResult(String result);
//    }
//}
