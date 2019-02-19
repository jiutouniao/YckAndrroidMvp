package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.PageBean;
import com.soft.xiren.db.ebook.bean.RemarkBean;

import org.litepal.crud.DataSupport;

/**
 * 描述：删除所有标签
 * 作者：邵兵
 * 日期：2017/6/6 10:18
 */
public class RemarkDbModel {


    /**
     *删除标签
     * @param bookId
     * @return
     */
    public static void deleteAllThinkByBookId(String bookId){
        DataSupport.deleteAll(RemarkBean.class,"bookId = ?",bookId);
    }

    /**
     * 获取当前书本 当前章节 当前页中所有的书签
     * @param bookId
     * @param pageBean
     * @return
     */
    public static RemarkBean getRemark(String bookId,PageBean pageBean){
        RemarkBean newsList = DataSupport
                .where("bookId = ?  and  curBeginPos<? and curBeginPos>=? and pageChapter=? ",
                        String.valueOf(bookId),
                        String.valueOf(pageBean.getCurEndPos()),
                        String.valueOf(pageBean.getCurBeginPos()),
                        String.valueOf(pageBean.getPageChapter())
                )
                .order("pageChapter asc")
                .findFirst(RemarkBean.class);
        return newsList;
    }

    /**
     * 获取当前书本 当前章节 当前页中所有的书签
     * @param pageBean
     * @return
     */
    public static RemarkBean getRemark(PageBean pageBean){
        RemarkBean newsList = DataSupport
                .where("bookId = ?  and  curBeginPos<? and curBeginPos>=? and pageChapter=? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(pageBean.getCurEndPos()),
                        String.valueOf(pageBean.getCurBeginPos()),
                        String.valueOf(pageBean.getPageChapter())
                )
                .order("pageChapter asc")
                .findFirst(RemarkBean.class);
        return newsList;
    }

}
