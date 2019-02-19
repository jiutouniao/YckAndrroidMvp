package com.soft.xiren.db.ebook.bean;

/**
 * 描述：界面的相关信息
 * 作者：邵兵
 * 日期：2017/6/18 16:06
 */
public class PageMassageBean {

    private String bookId;

    private int startpos;

    private CharSequence stringBuilder;

    private int endpos;

    private int chapterId;
    //标题
    private String title;


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getStartpos() {
        return startpos;
    }

    public void setStartpos(int startpos) {
        this.startpos = startpos;
    }

    public CharSequence getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(CharSequence stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public int getEndpos() {
        return endpos;
    }

    public void setEndpos(int endpos) {
        this.endpos = endpos;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
