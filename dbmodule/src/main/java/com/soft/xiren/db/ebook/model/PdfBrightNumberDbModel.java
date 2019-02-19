package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.PdfBrightNumberBean;

import org.litepal.crud.DataSupport;

/**
 * 描述：Pdf亮度控制
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class PdfBrightNumberDbModel {

    /**
     * 获取Brightness
     * @return
     */
    public static PdfBrightNumberBean getNumber(){
        PdfBrightNumberBean bean = DataSupport
                .findLast(PdfBrightNumberBean.class);
        if(bean==null){
            bean = new PdfBrightNumberBean();
            bean.setNumber(0);
        }
        return bean;
    }


    /***
     * 保存Brightness
     */
    public static void setNumber( int type){
        PdfBrightNumberBean bean = new PdfBrightNumberBean();
        bean.setNumber(type);
        bean.save();
    }



}
