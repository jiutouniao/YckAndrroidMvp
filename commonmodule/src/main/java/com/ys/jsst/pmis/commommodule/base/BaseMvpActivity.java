package com.ys.jsst.pmis.commommodule.base;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.githang.statusbar.StatusBarCompat;
import com.ys.jsst.pmis.commommodule.base.mvp.BasePresenter;
import com.ys.jsst.pmis.commommodule.base.mvp.Iview;
import com.ys.jsst.pmis.commommodule.ui.dialog.LoadDialog;

/**
 * description:Activity基类
 * Date: 2016/6/15
 * Time: 16:17
 */
public abstract class BaseMvpActivity<B extends ViewDataBinding,P extends BasePresenter> extends AppCompatActivity implements Iview {
    private static final String TAG = BaseMvpActivity.class.getSimpleName();

    //界面
    public B mViewBinding;
   //MVP中P模块
    public P mPresenter;
    private BaseAttribute attribute = new BaseAttribute();
    private LoadDialog mCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置每个Activity为竖屏模式
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //初始化绑定
        onInitAttribute(attribute);
        if (attribute.mLayoutId > 0) {
            mViewBinding = DataBindingUtil.setContentView(this, attribute.mLayoutId);
        }
        if (setStatusColor()){
            //设置标题栏颜色
            StatusBarCompat.setStatusBarColor(this, getSatusColor(), true);
        }
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }
        RunningActivityManager.getInstance().addActivity(this);

    }

    protected int getSatusColor() {
        return 0xFF4990e2;
    }

    protected boolean setStatusColor() {
        return true;
    }

    protected abstract void onInitAttribute(BaseAttribute attribute);

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //避免activity里面添加fragment时，在待机过程中出现异常
//        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
        RunningActivityManager.getInstance().removeActivity(this);
        dismissDialog();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void showError() {
        dismissDialog();
    }

    @Override
    public void showNoNetwork() {
        dismissDialog();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void showDialog() {
        mCustomDialog = new LoadDialog(this);
        mCustomDialog.show();
    }

    public void dismissDialog() {
        if (mCustomDialog != null) {
            mCustomDialog.dismiss();
            mCustomDialog = null;
        }
    }



    /**
     * 清除 editText 的焦点
     *
     * @param v   焦点所在 View
     * @param ids 输入框
     */
    public void clearViewFocus(View v, int... ids) {
        if (null != v && null != ids && ids.length > 0) {
            for (int id : ids) {
                if (v.getId() == id) {
                    v.clearFocus();
                    break;
                }
            }
        }


    }

    /**
     * 隐藏键盘
     *
     * @param v   焦点所在 View
     * @param ids 输入框
     * @return true 代表焦点在 edit 上
     */
    public boolean isFocusEditText(View v, int... ids) {
        if (v instanceof EditText) {
            EditText tmp_et = (EditText) v;
            for (int id : ids) {
                if (tmp_et.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    // 是否触摸在指定 view 上面, 对某个控件过滤
    public boolean isTouchView(View[] views, MotionEvent ev) {
        if (views == null || views.length == 0) return false;
        int[] location = new int[2];
        for (View view : views) {
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }

}
