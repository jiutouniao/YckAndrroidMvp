package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 划线保存
 */

public class LineBean extends DataSupport {

    //主键
    private long id;
    private int op_count;
    //存储当前书本
    private String bookId;
    /**
     * 1-5 代表划线  6.代表想法  7.代表标签
     */
    private int type;
    //章节标题
    private String pageChapterTitle;

    //当前页所在的章节
    private int pageChapter;

    //当前页在章节中开始字符的位置
    private String curBeginPos;

    //当前页在章节中结束字符位置
    private String curEndPos;
    //当前信息
    private String message;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPageChapterTitle() {
        return pageChapterTitle;
    }

    public void setPageChapterTitle(String pageChapterTitle) {
        this.pageChapterTitle = pageChapterTitle;
    }

    public int getPageChapter() {
        return pageChapter;
    }

    public void setPageChapter(int pageChapter) {
        this.pageChapter = pageChapter;
    }

    public String getCurBeginPos() {
        return curBeginPos;
    }

    public void setCurBeginPos(String curBeginPos) {
        this.curBeginPos = curBeginPos;
    }

    public String getCurEndPos() {
        return curEndPos;
    }

    public void setCurEndPos(String curEndPos) {
        this.curEndPos = curEndPos;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOp_count() {
        return op_count;
    }

    public void setOp_count(int op_count) {
        this.op_count = op_count;
    }
}
