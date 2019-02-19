package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.GuideBean;

import org.litepal.crud.DataSupport;

/**
 * 描述：书本数据库操作
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class GuideDbModel {


    /**
     * 获取Guide
     * @return
     */
    public static GuideBean getGuide(){
        GuideBean bean = DataSupport
                .findLast(GuideBean.class);
        return bean;
    }


    /***
     * 保存Guide
     */
    public static void saveGuide(){
        GuideBean bean = new GuideBean();
        bean.setIsGuide(1);
        bean.save();
    }


    /***
     * 保存Guide
     */
    public static void releaseGuide(){
        GuideBean bean = new GuideBean();
        bean.setIsGuide(0);
        bean.save();
    }
}
