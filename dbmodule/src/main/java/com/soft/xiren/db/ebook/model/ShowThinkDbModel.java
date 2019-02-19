package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.ShowThinkBean;

import org.litepal.crud.DataSupport;

/**
 * 描述：是否显示想法
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class ShowThinkDbModel {


    /**
     * 获取Guide
     * @return
     */
    public static ShowThinkBean getIsHide(){
        ShowThinkBean bean = DataSupport
                .findLast(ShowThinkBean.class);
        if(bean==null){
            bean= new ShowThinkBean();
            bean.setIsHide(0);
        }
        return bean;
    }


    /**
     * 保存是否显示想法
     * @param type   0.显示想法    1.隐藏想法
     */
    public static void setIsHide(int type){
        ShowThinkBean bean = new ShowThinkBean();
        bean.setIsHide(type);
        bean.save();
    }

}
