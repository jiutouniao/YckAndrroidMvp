package com.ys.jsst.pmis.commommodule.util.mobLogin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.ys.jsst.pmis.commommodule.R;
import com.ys.jsst.pmis.commommodule.ui.dialog.LoadDialog;


public class LoginApi implements Callback {
    private static final int MSG_AUTH_CANCEL = 1;
    private static final int MSG_AUTH_ERROR = 2;
    private static final int MSG_AUTH_COMPLETE = 3;

    private OnLoginListener loginListener;
    private String platform;
    private Context context;
    private Handler handler;
    private LoadDialog mLoadingDialog;
    public static final String LOG_TAG = LoginApi.class.getSimpleName();

    public LoginApi() {
        handler = new Handler(Looper.getMainLooper(), this);
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setOnLoginListener(OnLoginListener login) {
        this.loginListener = login;
    }

    public void login(final Context context) {
        this.context = context;
        mLoadingDialog = new LoadDialog(context);
        if (platform == null) {
            return;
        }
       /* //初始化SDK
        if (!(context instanceof MobApplication)) {
            MobSDK.init(context.getApplicationContext());
        }*/

        //微信配置
        // (用代码配置微信的信息主要是因为shareSDK.xml的信息读取不到，不知道是不是因为在不同的module的原因)
       /* HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppId", "wx0820c469c890f5d0");
        hashMap.put("AppSecret", "e5cfaa4cb7d31e28229100cec618f5b0");
        hashMap.put("BypassApproval", false);
        hashMap.put("Enable", true);
        hashMap.put("Id", 4);
        hashMap.put("SortId", 4);
        hashMap.put("path", "pages/index/index.html?id=1");
        hashMap.put("userName", "gh_afb25ac019c9");
        ShareSDK.setPlatformDevInfo(Wechat.NAME, hashMap);

        //获取平台信息
        Platform plat = ShareSDK.getPlatform(platform);

        if (plat == null) {
            return;
        }

        //判断客户端是否存在
        if (!plat.isClientValid()) {//如果未安装微信客户端，暂不支持网页登陆微信
            if (plat.getDb().getPlatformNname().equals(Wechat.NAME)) {
                ToastUtil.showShortToast(context, context.getString(R.string.not_installed_Wechat));
                return;
            }
        }
        //弹出dialog，调起第三方登录
        mLoadingDialog.show();

        //如果已经授权了，再次进入取消授权
        if (plat.isAuthValid()) {
            plat.removeAccount(true);
        }

        //使用SSO授权，有客户端，通过客户端登陆，没有客户端，通过网页登录
        plat.SSOSetting(false);
        plat.setPlatformActionListener(new PlatformActionListener() {
            public void onComplete(Platform plat, int action, HashMap<String, Object> res) {
                if (action == Platform.ACTION_USER_INFOR) {//用于自动登录
                    Message msg = new Message();
                    msg.what = MSG_AUTH_COMPLETE;
                    msg.arg2 = action;
                    msg.obj = new Object[]{plat.getName(), res};
                    handler.sendMessage(msg);
                }
            }

            public void onError(Platform plat, int action, Throwable t) {
                if (action == Platform.ACTION_USER_INFOR) {//用于自动登录
                    Message msg = new Message();
                    msg.what = MSG_AUTH_ERROR;
                    msg.arg2 = action;
                    msg.obj = t;
                    handler.sendMessage(msg);
                }
                t.printStackTrace();
            }

            public void onCancel(Platform plat, int action) {
                if (action == Platform.ACTION_USER_INFOR) {//用于自动登录
                    Message msg = new Message();
                    msg.what = MSG_AUTH_CANCEL;
                    msg.arg2 = action;
                    msg.obj = plat;
                    handler.sendMessage(msg);
                }
            }
        });
        plat.showUser(null);//授权并获取用户信息*/
    }

    /**
     * 处理操作结果
     */
    public boolean handleMessage(Message msg) {
        mLoadingDialog.dismiss();
        switch (msg.what) {
            case MSG_AUTH_CANCEL: // 取消
                Toast.makeText(context, context.getString(R.string.author_login_cancel), Toast.LENGTH_SHORT).show();
                break;
            case MSG_AUTH_ERROR://登录失败
                Throwable t = (Throwable) msg.obj;
                Toast.makeText(context, context.getString(R.string.login_error), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
                break;
            case MSG_AUTH_COMPLETE: // 成功
               /* Object[] objs = (Object[]) msg.obj;
                String plat = (String) objs[0];
                HashMap<String, Object> res = (HashMap<String, Object>) objs[1];
                Platform platform = ShareSDK.getPlatform(plat);
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(platform.getDb().getUserId());
                userInfo.setUserName(platform.getDb().getUserName());
                userInfo.setSex(platform.getDb().getUserGender().equals("m") ? "1" : "2");
                userInfo.setHeadUrl(platform.getDb().getUserIcon());
                userInfo.setPlatform(plat);
                loginListener.onLogin(userInfo, res);*/
                break;
        }
        return false;
    }
}
