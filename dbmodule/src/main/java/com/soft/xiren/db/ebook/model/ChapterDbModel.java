package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.ChapterBean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：章节操作请求
 * 作者：邵兵
 * 日期：2017/6/3 11:22
 */
public class ChapterDbModel {


    /**
     * 获取本书的总的章节数量
     * @param resource_id 当前资源
     * @return
     */
    public static int getPageCount(String resource_id){
        int count= DataSupport
                .where("bookId = ? ", String.valueOf(resource_id))
                .count(ChapterBean.class);
        return count;
    }

    /**
     * 获取当前这本书当前章节信息
     * @param resource_id
     * @param chapterId
     * @return
     */
    public static ChapterBean getChapter(String resource_id,int chapterId){
        ChapterBean bean= DataSupport
                .where("bookId = ? and chapterId=?",
                        String.valueOf(resource_id),
                        String.valueOf(chapterId))
                .findFirst(ChapterBean.class);
        return bean;
    }

    /**
     * 获取当前书本目录
     * @param bookId
     * @return
     */
    public static List<ChapterBean> getChapterByBookId(String bookId){
        List<ChapterBean> bean = DataSupport
                .where("bookId = ?",bookId)
                .find(ChapterBean.class);
        return bean;
    }

}
