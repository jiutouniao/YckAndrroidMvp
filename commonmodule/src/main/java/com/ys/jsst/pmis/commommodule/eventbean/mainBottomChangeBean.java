package com.ys.jsst.pmis.commommodule.eventbean;

import android.widget.ImageView;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-7-27 19:45
 */
public class mainBottomChangeBean {
    //0 代表图书被长按    1代表文件夹被长按

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private int i;
    private boolean b;
    private String imgUrl;
    private ImageView imgView;
    public mainBottomChangeBean(boolean b) {
        this.b = b;
    }

    public mainBottomChangeBean(boolean b, int i) {
        this.b = b;
        this.i = i;
    }
    public mainBottomChangeBean(boolean b, int i, String imgUrl, ImageView imgView) {
        this.b = b;
        this.i = i;
        this.imgUrl=imgUrl;
        this.imgView=imgView;
    }

    public boolean isPress() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
