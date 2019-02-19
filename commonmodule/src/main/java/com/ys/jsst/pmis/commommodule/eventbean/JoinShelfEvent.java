package com.ys.jsst.pmis.commommodule.eventbean;

/**
 * 描述：加入书架
 * 作者：yuyanjun
 * 时间： 2017-9-29 16:11
 */
public class JoinShelfEvent {

    /***
     *  为空或者0 代表退出上传进度，退出阅读界面    1代表加入书架
     */
    private String type;

    public JoinShelfEvent() {
    }


    public JoinShelfEvent(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
