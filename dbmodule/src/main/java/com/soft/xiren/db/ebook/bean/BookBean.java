package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：存储和Book相关的信息
 * 作者：邵兵
 * 日期：2017/6/1 18:56
 */
public class BookBean  extends DataSupport {
    //主键
    private long id;
    //资源id
    private  String bookId;
    //书本名称
    private String  bookName;
    //书本作者
    private String author;

    private String bookUrl;

    /**
     * 这本书当前字体，为了进行页码计算
     */
    private int mCurrentFontSize;
    /**
     * 这本书当前的字体类型
     */
    private int mCurrentfont;

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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public int getmCurrentFontSize() {
        return mCurrentFontSize;
    }

    public void setmCurrentFontSize(int mCurrentFontSize) {
        this.mCurrentFontSize = mCurrentFontSize;
    }

    public int getmCurrentfont() {
        return mCurrentfont;
    }

    public void setmCurrentfont(int mCurrentfont) {
        this.mCurrentfont = mCurrentfont;
    }
}
