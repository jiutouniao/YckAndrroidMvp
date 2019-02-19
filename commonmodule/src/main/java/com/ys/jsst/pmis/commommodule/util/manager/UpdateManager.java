package com.ys.jsst.pmis.commommodule.util.manager;

import android.content.Context;
import android.content.Intent;

import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.http.file.DownLoadService;
import com.ys.jsst.pmis.commommodule.ui.dialog.DefaultDialog;
import com.ys.jsst.pmis.commommodule.util.DeviceUtils;

/**
 * Created by zs on 2016/7/7.
 */
public class UpdateManager {

    private Context mContext;

    public UpdateManager(Context context) {
        this.mContext = context;
    }
    /**
     * 检测软件更新
     */
    public void checkUpdate(int version, final boolean isToast) {
        /**
         * 在这里请求后台接口，获取更新的内容和最新的版本号
         */
        // 版本的更新信息
        String version_info = "更新内容\n" + "    1. 车位分享异常处理\n" + "    2. 发布车位折扣格式统一\n" + "    ";
        int mVersion_code = DeviceUtils.getVersionCode(mContext);// 当前的版本号
        if (version>mVersion_code) {
            // 显示提示对话
            showNoticeDialog(version_info);
        }else{
//                ToastUtil.showShortToast(mContext, AppContext.getmAppContext().getString(R.string.is_new));
        }
    }

    /**
     * 显示更新对话框
     *
     * @param version_info
     */

    private void showNoticeDialog(String version_info) {
        DefaultDialog defaultDialog=new DefaultDialog(mContext).setOnDefaultDialogListener(new DefaultDialog.OnDefaultDialogListener() {
            @Override
            public void onOk() {
                mContext.startService(new Intent(mContext, DownLoadService.class));
            }
            @Override
            public void onCancel() {

            }
        });


        defaultDialog.show();
        defaultDialog.setContentText(mContext.getString(R.string.setting_exit4));
    }
}
