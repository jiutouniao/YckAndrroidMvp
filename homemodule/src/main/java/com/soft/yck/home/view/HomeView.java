package com.soft.yck.home.view;

import com.soft.yck.home.bean.BookPageListBean;
import com.ys.jsst.pmis.commommodule.base.mvp.Iview;


/**ydc 获取书架
 * Created by Administrator on 2017/7/6.
 */

public interface HomeView extends Iview {
    void showStackBook(BookPageListBean bean,int index);
}
