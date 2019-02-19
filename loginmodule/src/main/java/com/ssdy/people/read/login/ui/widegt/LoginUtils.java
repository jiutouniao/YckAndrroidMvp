package com.ssdy.people.read.login.ui.widegt;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;
import com.ssdy.people.read.login.R;
import com.ys.jsst.pmis.commommodule.util.StringUtils;

/**
 * 登陆相关类
 * Created by amos on 2017/10/11.
 */

public class LoginUtils {

    private static final String TAG = "LoginUtils";
    private static final LoginUtils mInstance = new LoginUtils();

    private LoginUtils() {

    }

    public static LoginUtils getInstance() {
        if (mInstance == null) {
            throw new NullPointerException("LoginUtils is null");
        }
        return mInstance;
    }

  /**
     * 光标移到最后一位
     *
     * @param editText editText
     */
    public void setEditTextCursorLocationEnd(EditText editText) {
        editText.setSelection(getTextInfo(editText).length());
    }

    /**
     * 获取用户输入信息
     */
    public String getTextInfo(EditText text) {
        return text.getText().toString().trim();
    }


    /**
     * 设置是否明文显示
     */
    public void ciphertextDisplay(ImageView iv, EditText et) {
        String isSee =(String) iv.getTag();
        if (StringUtils.isNotEmpty(isSee) && isSee.equals("true")) {
            iv.setTag("false");
            iv.setImageResource(R.drawable.ic_close_eyes);
            et.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }else {
            iv.setTag("true");
            iv.setImageResource(R.drawable.ic_open_eyes);
            et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        setEditTextCursorLocationEnd(et);
    }
}
