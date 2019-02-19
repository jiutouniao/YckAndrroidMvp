package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.ChapterBean;
import com.soft.xiren.db.ebook.bean.PageOffsetBean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：章节操作请求
 * 作者：邵兵
 * 日期：2017/6/3 11:22
 */
public class PageOffsetDbModel {

    /**
     *获取书本分页信息
     * @param bookId
     * @return
     */
    public static PageOffsetBean getPageOffsetByBookId(String bookId){
        PageOffsetBean bean = DataSupport
                .where("bookId = ?",bookId)
                .findFirst(PageOffsetBean.class);
        return bean;
    }


    /**
     *获取书本分页信息
     * @param bookId
     * @return
     */
    public static  List<PageOffsetBean> getPageOffsets(String bookId){
        List<PageOffsetBean> bean = DataSupport
                .where("bookId = ?",bookId)
                .find(PageOffsetBean.class);
        return bean;
    }

}
