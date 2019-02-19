package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 *是否显示想法
 */
public class ShowThinkBean extends DataSupport {

    /***
     * 0.显示想法    1.隐藏想法
     */
    private int isHide;

    public int getIsHide() {
        return isHide;
    }

    public void setIsHide(int isHide) {
        this.isHide = isHide;
    }
}
