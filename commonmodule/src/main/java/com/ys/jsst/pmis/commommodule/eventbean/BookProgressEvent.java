package com.ys.jsst.pmis.commommodule.eventbean;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-11-2 16:29
 */
public class BookProgressEvent {
    private final String bookid;

    public String getBookid() {
        return bookid;
    }

    public String getProgress() {
        return progress;
    }

    private final String progress;

    public BookProgressEvent(String bookid, String progress) {
        this.bookid = bookid;
        this.progress = progress;
    }
}
