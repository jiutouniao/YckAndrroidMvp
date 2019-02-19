package com.ys.jsst.pmis.commommodule.base;

/**
 * 描述：存储行数的相关信息
 * 作者：邵兵
 * 日期：2017/6/18 16:06
 */
public class LineMassageBean {

    private int startpos;

    private String massage;

    private int endpos;

    //标题
    private String title;

    public int getStartpos() {
        return startpos;
    }

    public void setStartpos(int startpos) {
        this.startpos = startpos;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getEndpos() {
        return endpos;
    }

    public void setEndpos(int endpos) {
        this.endpos = endpos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
