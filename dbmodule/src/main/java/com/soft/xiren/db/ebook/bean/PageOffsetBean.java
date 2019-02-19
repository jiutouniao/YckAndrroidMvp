package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：存储当前书本分页的相关信息
 * 作者：邵兵
 * 日期：2017/6/29 14:11
 */
public class PageOffsetBean  extends DataSupport {

    /**
     * 主键
     */
    private long id;
    /**
     * 存储当前书本
     */
    private String bookId;

   String lists;

    //书本所有的页码
    int allPageNumber;

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


    public String getLists() {
        return lists;
    }

    public void setLists(String lists) {
        this.lists = lists;
    }

    public int getAllPageNumber() {
        return allPageNumber;
    }

    public void setAllPageNumber(int allPageNumber) {
        this.allPageNumber = allPageNumber;
    }
}
