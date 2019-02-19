package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：存储当前资源的相关信息
 * 作者：邵兵
 * 日期：2017/7/12 17:58
 */
public class EpubResourceBean extends DataSupport {

    // 0 代表是图片    1.代表音频      2.代表视频
    private int type;
    //判断当前是那本书的资源
    private String bookId;
    //当前章节
    private int chapaterId;
    //开始位置
    private int start;
    //结束位置
    private int end;
    //图片链接
    private String  url;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getChapaterId() {
        return chapaterId;
    }

    public void setChapaterId(int chapaterId) {
        this.chapaterId = chapaterId;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
