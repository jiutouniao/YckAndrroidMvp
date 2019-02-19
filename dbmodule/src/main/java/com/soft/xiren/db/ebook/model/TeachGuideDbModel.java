package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.GuideBean;
import com.soft.xiren.db.ebook.bean.TeachGuideBean;

import org.litepal.crud.DataSupport;

/**
 * 描述：讲书新手指引  数据库操作
 * 作者：费敬宏
 * 日期：2018年12月27日22:01:39
 */
public class TeachGuideDbModel {


    /**
     * 获取Guide
     * @return
     */
    public static TeachGuideBean getTeachGuide(){
        TeachGuideBean bean = DataSupport.findLast(TeachGuideBean.class);
        return bean;
    }


    /***
     * 保存Guide
     */
    public static void saveTeachGuide(){
        TeachGuideBean bean = new TeachGuideBean();
        bean.setIsGuide(1);
        bean.save();
    }

//    public static void saveTeachGuide(String str){
//        TeachGuideBean bean = new TeachGuideBean();
//        bean.setIsGuide(1);
//        bean.setGuideName(str);
//        bean.save();
//    }


    /***
     * 释放Guide
     */
    public static void releaseTeachGuide(){
        TeachGuideBean bean = new TeachGuideBean();
        bean.setIsGuide(0);
        bean.save();
    }
}
