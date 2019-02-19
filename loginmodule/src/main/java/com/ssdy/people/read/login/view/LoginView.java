package com.ssdy.people.read.login.view;

import com.ssdy.people.read.login.bean.LoginBean;
import com.ys.jsst.pmis.commommodule.base.mvp.Iview;


/**ydc 登录返回接口
 * Created by Administrator on 2017/7/6.
 */

public interface LoginView extends Iview {
    void showLogin(LoginBean bean);
}
