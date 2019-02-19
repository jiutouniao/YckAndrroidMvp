package com.ys.jsst.pmis.commommodule.eventbean;

/**
 * description: 收藏刷新模块
 * 2017-10-28
 * User: jiangdong
 */
public class BookDetailsEvent {
    /**
     * 1.刷新我的收藏数据
     */
    private int type;

    //判断是否收藏
    private boolean  isJoin;

    public BookDetailsEvent(int type){
        this.type=type;
    }


    public BookDetailsEvent(int type,boolean  isJoin){
        this.type=type;
        this.isJoin =isJoin;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isJoin() {
        return isJoin;
    }

    public void setJoin(boolean join) {
        isJoin = join;
    }
}
