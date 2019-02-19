package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：保存当前进度
 * 作者：邵兵
 * 邮箱：2017/5/26 09:55
 */
public class ProgressBean extends DataSupport {
    //主键
    private long id;
    //书本
    private String bookId;
    //章节
    private int pageChapter;

    //当前页开始字符的位置
    private int curBeginPos;

    //当前进度百分比
    private String rate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getPageChapter() {
        return pageChapter;
    }

    public void setPageChapter(int pageChapter) {
        this.pageChapter = pageChapter;
    }

    public int getCurBeginPos() {
        return curBeginPos;
    }

    public void setCurBeginPos(int curBeginPos) {
        this.curBeginPos = curBeginPos;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
