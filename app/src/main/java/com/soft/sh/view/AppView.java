package com.soft.sh.view;

import com.soft.sh.bean.UpdateBean;
import com.ys.jsst.pmis.commommodule.base.mvp.Iview;


/**ydc 首页
 * Created by Administrator on 2017/7/6.
 */

public interface AppView extends Iview {
    void showLatestApp(UpdateBean bean);
}
