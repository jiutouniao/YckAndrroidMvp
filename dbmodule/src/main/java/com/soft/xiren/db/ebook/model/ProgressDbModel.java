package com.soft.xiren.db.ebook.model;

import android.content.ContentValues;
import android.util.Log;
import com.soft.xiren.db.ebook.bean.PageBean;
import com.soft.xiren.db.ebook.bean.ProgressBean;
import org.litepal.crud.DataSupport;


/**
 * 描述：进度数据库控制
 * 作者：邵兵
 * 日期：2017/6/3 10:57
 */
public class ProgressDbModel {

    public static ProgressBean getProgressBean(String resource_id){
        ProgressBean bean= DataSupport
                .where("bookId = ?", resource_id)
                .findFirst(ProgressBean.class);
        if(bean==null){
            bean = new ProgressBean();
            bean.setBookId(resource_id);
            bean.setPageChapter(0);
            bean.setCurBeginPos(0);
            bean.setRate("0");
            bean.save();
            bean= DataSupport
                    .where("bookId = ?", resource_id)
                    .findFirst(ProgressBean.class);
        }
        return bean;
    }


    /**
     * 获取当前进度所在的页面位置
     * @return
     */
    public static int getCountByProgress(ProgressBean bean){
        if(bean==null){
            return 0;
        }
        // 1、按照章节进行排序 2.获取小于等于当前章节   3.大于这页的开始位置  4.小于这页的结束位置
        int count= DataSupport
                .where("bookId = ?  and pageChapter < ?",
                        String.valueOf(bean.getBookId()),
                        String.valueOf(bean.getPageChapter()))
                .order("pageChapter asc")
                .count(PageBean.class);
        Log.d("LogUtil","progressBean  count :"+count);
        int count2= DataSupport
                .where("bookId = ?  and pageChapter= ?  and  curBeginPos<=?",
                        String.valueOf(bean.getBookId()),
                        String.valueOf(bean.getPageChapter()),
                        String.valueOf(bean.getCurBeginPos()))
                .count(PageBean.class);
        Log.d("LogUtil","progressBean  count :"+count2);
        return count+count2;
    }


    /**
     * 更细您当前进度
     * @param bean
     * @param resource_id
     */
    public static void updateProgress(ProgressBean bean,String resource_id){
        ContentValues values = new ContentValues();
        values.put("pageChapter", bean.getPageChapter());
        values.put("curBeginPos", bean.getCurBeginPos());
        values.put("rate", bean.getRate());
        DataSupport.updateAll(ProgressBean.class, values,"bookId = ?",resource_id);
    }


    /**
     * 保存当前读书进度
     * @param pageBean
     * @param rate
     */
    public static ProgressBean saveProgress(PageBean pageBean,String rate){
        if(pageBean==null){
            return null;
        }
        ProgressBean progressBean= ProgressDbModel.getProgressBean(pageBean.getBookId());
        progressBean.setCurBeginPos(Integer.parseInt(pageBean.getCurBeginPos()));
        progressBean.setPageChapter(pageBean.getPageChapter());
        progressBean.setRate(rate);
        progressBean.update(progressBean.getId());
        return progressBean;
    }


}
