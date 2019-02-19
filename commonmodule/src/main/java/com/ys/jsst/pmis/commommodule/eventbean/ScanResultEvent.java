package com.ys.jsst.pmis.commommodule.eventbean;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-10-17 14:28
 */
public class ScanResultEvent {
    private  String text;

    public ScanResultEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
