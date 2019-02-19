package com.ys.jsst.pmis.commommodule.eventbean;

/**
 * 描述：更新阅读人数
 * 作者：yuyanjun
 * 时间： 2017-12-12 11:26
 */
public class ReadNumberEvent {


    private int number;


    public ReadNumberEvent(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
