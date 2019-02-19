package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 存储指南
 */
public class GuideBean   extends DataSupport {

    /***
     *  0为空    1.已经进入导航
     */
    private int isGuide;


    public int getIsGuide() {
        return isGuide;
    }

    public void setIsGuide(int isGuide) {
        this.isGuide = isGuide;
    }
}
