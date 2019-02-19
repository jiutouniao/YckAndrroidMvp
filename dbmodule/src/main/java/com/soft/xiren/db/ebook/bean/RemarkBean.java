package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：存储书签
 * 作者：邵兵
 * 邮箱：2017/6/1 17:20
 */
public class RemarkBean extends DataSupport {

    //主键
    private long id;
    //服务器ID
    private int op_count;
    //存储当前书本
    private String bookId;
    //章节标题
    private String pageChapterTitle;
    /**
     * 1-5 代表划线
     */
    private int type;

    //当前页所在的章节
    private int pageChapter;

    //当前页在章节中开始字符的位置
    private int curBeginPos;

    //当前页在章节中结束字符位置
    private int curEndPos;
    //选中信息
    private String selectMessage;
    //评论信息
    private String commentMessage;
    //想法的时间
    private String time;

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

    public String getPageChapterTitle() {
        return pageChapterTitle;
    }

    public void setPageChapterTitle(String pageChapterTitle) {
        this.pageChapterTitle = pageChapterTitle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getCurEndPos() {
        return curEndPos;
    }

    public void setCurEndPos(int curEndPos) {
        this.curEndPos = curEndPos;
    }

    public String getSelectMessage() {
        return selectMessage;
    }

    public void setSelectMessage(String selectMessage) {
        this.selectMessage = selectMessage;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOp_count() {
        return op_count;
    }

    public void setOp_count(int op_count) {
        this.op_count = op_count;
    }
}
