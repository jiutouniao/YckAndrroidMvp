package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 *  pdf亮度数据
 */
public class PdfBrightNumberBean extends DataSupport {

    /***
     *  0正常模式    1.夜晚模式
     */
    private int number;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
