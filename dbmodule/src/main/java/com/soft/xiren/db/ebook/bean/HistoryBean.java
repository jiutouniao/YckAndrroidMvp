package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：保存历史
 * 作者：邵兵
 * 日期：2017/9/18 18:36
 */
public class HistoryBean  extends DataSupport {

    private int id;

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
