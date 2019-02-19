package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 存储指南 讲书新手指引
 */
public class TeachGuideBean extends DataSupport {

    /***
     *  0为空    1.已经进入导航
     */
    private int isGuide;
    //指引的位置
//    private String guideName;

    public int getIsGuide() {
        return isGuide;
    }

    public void setIsGuide(int isGuide) {
        this.isGuide = isGuide;
    }

//    public String getGuideName() {
//        return guideName;
//    }
//
//    public void setGuideName(String guideName) {
//        this.guideName = guideName;
//    }
}
