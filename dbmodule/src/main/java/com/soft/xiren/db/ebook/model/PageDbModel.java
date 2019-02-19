package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.BookBean;
import com.soft.xiren.db.ebook.bean.PageBean;
import com.soft.xiren.db.ebook.bean.ProgressBean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：对当前页面进行操作的数据库
 * 作者：邵兵
 * 日期：2017/6/11 15:10
 */
public class PageDbModel {


    /**
     * 获取当前书本的所有书籍
     * @param resource_id
     * @return
     */
    public static List<PageBean> getPageBeanByBookId(String resource_id){
        List<PageBean> beanList= DataSupport
                .where("bookId = ? ", String.valueOf(resource_id))
                .order("pageChapter asc")
                .find(PageBean.class);
        return beanList;
    }



    /**
     * 获取当前书本的页面个数
     * @param resource_id 当前资源
     * @return
     */
    public static int getPageCount(String resource_id){
        int count= DataSupport
                .where("bookId = ? ", String.valueOf(resource_id))
                .order("pageChapter asc")
                .count(PageBean.class);
        return count;
    }

    /**
     * 根据当前资源ID 和当前页面ID获取当前页的信息
     * @param resource_id
     * @param page
     * @return
     */
    public static PageBean getPageByOrderId(String resource_id, int page){
        PageBean bean = DataSupport
                .where("bookId = ?",resource_id)
                .order("pageChapter asc")
                .limit(1).offset(page)
                .findFirst(PageBean.class);
        return bean;
    }


    /**
     * 获取某一章节里面所有的页面信息
     * @param resource_id
     * @return
     */
    public static List<PageBean> getPageBeanByChapter(String resource_id, int pageChapter){
        List<PageBean> bean = DataSupport
                .where("bookId = ? and pageChapter=?",resource_id,String.valueOf(pageChapter))
                .find(PageBean.class);
        return bean;
    }

    /**
     * 根据资源id 删除当前资源的所有界面
     * @param resource_id
     * @return
     */
    public static int deltePageByOrderId(String resource_id){
        int count= DataSupport.deleteAll(PageBean.class,"bookId = ?",resource_id);
        return count;
    }


    /**
     * 按照条件删除当前书本的当前章节
     * @param resource_id
     * @param pageChapter
     * @return
     */
    public static int deltePageByOrderId(String resource_id,int  pageChapter){
        int count= DataSupport.deleteAll(PageBean.class,"bookId = ? and pageChapter=? ",resource_id,String.valueOf(pageChapter));
        return count;
    }

    /**
     * 获取当前章节页码
     * @return
     */
    public static int getPageByChapter(String resource_id,int  pageChapter){
        // 1、按照章节进行排序 2.获取小于等于当前章节   3.大于这页的开始位置  4.小于这页的结束位置
        int count= DataSupport
                .where("bookId = ?  and pageChapter < ?",
                        String.valueOf(resource_id),
                        String.valueOf(pageChapter))
                .order("pageChapter asc")
                .count(PageBean.class);
        return count;
    }




}
