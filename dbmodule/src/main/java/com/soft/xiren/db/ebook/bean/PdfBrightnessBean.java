package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 *  pdf亮度控制
 */
public class PdfBrightnessBean extends DataSupport {

    /***
     *  0正常模式    1.夜晚模式
     */
    private int isBrightness;

    public int getIsBrightness() {
        return isBrightness;
    }

    public void setIsBrightness(int isBrightness) {
        this.isBrightness = isBrightness;
    }
}
