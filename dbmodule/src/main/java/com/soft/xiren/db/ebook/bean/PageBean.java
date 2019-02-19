package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：存储一本书的一页的信息
 * 作者：邵兵
 * 邮箱：2017/5/25 14:10
 */
public class PageBean extends DataSupport {

    //存储当前书本
    private String bookId;

    //章节标题
    private String pageChapterTitle;

    //当前页所在的章节
    private int pageChapter;

    //当前页在章节中开始字符的位置
    private String curBeginPos;

    //当前页在章节中结束字符位置
    private String curEndPos;

    //当前页所有行文字的集合
    private List<String> lines;
    //是否为书签
    private int isBookmark;

    //存储当前页的字体
    private int mFontSize;

    /**
     * 1系统字体  2方正小楷  3华文宋体  4仿宋字体
     */
    private int font;

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

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public int getIsBookmark() {
        return isBookmark;
    }

    public void setIsBookmark(int isBookmark) {
        this.isBookmark = isBookmark;
    }

    public int getmFontSize() {
        return mFontSize;
    }

    public void setmFontSize(int mFontSize) {
        this.mFontSize = mFontSize;
    }

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }
}
