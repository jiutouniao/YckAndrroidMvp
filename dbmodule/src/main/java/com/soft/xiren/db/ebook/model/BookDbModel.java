package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.BookBean;

import org.litepal.LitePalDB;
import org.litepal.crud.DataSupport;

/**
 * 描述：书本数据库操作
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class BookDbModel {


    /**
     * 获取当前bookId
     * @param bookId
     * @return
     */
    public static BookBean getBookByBookId(String bookId){
        BookBean bean = DataSupport
                .where("bookId = ?",bookId)
                .findFirst(BookBean.class);
        return bean;
    }


    /**
     * 保存书本相关信息
     * @param bookTitle
     * @param bookId
     */
    public static void saveBook(String bookTitle ,String bookId ){
        if(BookDbModel.getBookByBookId(bookId)==null){
            BookBean bookBean = new BookBean();
            bookBean.setBookId(bookId);
            bookBean.setBookName(bookTitle);
            bookBean.setAuthor("");
            bookBean.save();
        }
    }

}
