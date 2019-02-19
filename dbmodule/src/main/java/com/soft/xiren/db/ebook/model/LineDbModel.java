package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.LineBean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：
 * 作者：邵兵
 * 日期：2017/6/6 10:17
 */
public class LineDbModel {


    /**
     *删除所有的划线
     * @param bookId
     * @return
     */
    public static void deleteAllLineByBookId(String bookId){
        DataSupport.deleteAll(LineBean.class,"bookId = ?",bookId);
    }


    /**
     * 获取当前书本划线
     * @param bookId
     * @return
     */
    public static List<LineBean> getLineByBookId(String bookId){
        List<LineBean> bean = DataSupport
                .where("bookId = ?",bookId)
                .find(LineBean.class);
        return bean;
    }

}
