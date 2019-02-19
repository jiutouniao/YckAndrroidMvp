package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.ThoughtBean;

import org.litepal.crud.DataSupport;
import java.util.List;

/**
 * 描述：想法数据库操作
 * 作者：邵兵
 * 日期：2017/6/1 19:15
 */
public class ThinkDbModel {

    /**
     * 获取所有自己的想法
     * @param bookId
     * @return
     */
    public static List<ThoughtBean> getThinkByBookId(String bookId){
        List<ThoughtBean> bean = DataSupport
                .where("bookId = ?",bookId)
                .find(ThoughtBean.class);
        return bean;
    }



    /**
     *删除所有的想法列表
     * @param bookId
     * @return
     */
    public static void deleteAllThinkByBookId(String bookId){
        DataSupport.deleteAll(ThoughtBean.class,"bookId = ?",bookId);
    }


}
