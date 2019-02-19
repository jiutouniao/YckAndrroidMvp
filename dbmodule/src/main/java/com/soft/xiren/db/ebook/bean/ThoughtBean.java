package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * 描述：想法数据存储
 * 作者：邵兵
 * 邮箱：2017/6/1 17:20
 */
public class ThoughtBean  extends DataSupport implements Serializable {

    //服务器ID
    private int op_count;
    //主键
    private long id;
    /**
     * 1-5 代表划线
     */
    private int type;

    //存储当前书本
    private String bookId;
    //章节标题
    private String pageChapterTitle;

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
    /**
     * 是否可见  1 可见  0 不可见
     */
    private String see_able;
    /**
     * 显示用户昵称
     */
    private String nick_name;

    /**
     * 显示用户图片
     */
    private String head_image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getSee_able() {
        return see_able;
    }

    public void setSee_able(String see_able) {
        this.see_able = see_able;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public int getOp_count() {
        return op_count;
    }

    public void setOp_count(int op_count) {
        this.op_count = op_count;
    }
}
