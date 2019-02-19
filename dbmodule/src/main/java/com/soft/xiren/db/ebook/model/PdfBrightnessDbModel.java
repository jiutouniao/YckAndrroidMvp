package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.PdfBrightnessBean;

import org.litepal.crud.DataSupport;

/**
 * 描述：普通模式和夜晚模式控制
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class PdfBrightnessDbModel {

    /**
     * 获取Brightness
     * @return
     */
    public static PdfBrightnessBean getBrightness(){
        PdfBrightnessBean bean = DataSupport
                .findLast(PdfBrightnessBean.class);
        if(bean==null){
            bean = new PdfBrightnessBean();
            bean.setIsBrightness(0);
        }
        return bean;
    }


    /***
     * 保存Brightness
     */
    public static void saveBrightness( int type){
        PdfBrightnessBean bean = new PdfBrightnessBean();
        bean.setIsBrightness(type);
        bean.save();
    }



}
