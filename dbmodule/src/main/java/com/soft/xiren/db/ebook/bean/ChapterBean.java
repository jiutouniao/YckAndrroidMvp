package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：存储章节相关信息
 * 作者：邵兵
 * 邮箱：2017/5/23 20:38
 */
public class ChapterBean extends DataSupport {
    //主键
    private long id;
    //资源id
    private  String bookId;
    //标题
    private String title;
    //当前章节ID
    private int chapterId;
    //章节的详细内容，后面涉及到分页需要处理
    private String message;
    //当前正在阅读的章节
    private boolean isCurrentChapter;

    //当前缓存的ID
    private int pageId;
    private int level;
    private boolean isRead;

    public boolean isRead() {
        return isRead;
    }

    public ChapterBean setRead(boolean read) {
        isRead = read;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //当前章节链接
    String href;

    //当前章节所有的页码数量
    private int pageNumber;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCurrentChapter() {
        return isCurrentChapter;
    }

    public void setCurrentChapter(boolean currentChapter) {
        isCurrentChapter = currentChapter;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
