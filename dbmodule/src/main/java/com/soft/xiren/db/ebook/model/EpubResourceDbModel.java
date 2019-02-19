package com.soft.xiren.db.ebook.model;

import android.app.Activity;

import com.soft.xiren.db.ebook.bean.BookBean;
import com.soft.xiren.db.ebook.bean.EpubResourceBean;
import com.soft.xiren.db.ebook.bean.LineBean;
import com.soft.xiren.db.ebook.bean.MarkBean;
import com.soft.xiren.db.ebook.bean.PageMassageBean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：读取相关资源信息
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class EpubResourceDbModel {

    /**
     * 根据组员名称判断当前资源是否存在
     * @param bookId
     * @param url
     * @param start
     * @return
     */
    public  static boolean isSaveResource(String bookId,String  url,int start){
        EpubResourceBean bean = DataSupport
                .where("bookId = ?  and url = ? and start=?",
                        bookId,
                        url,
                        String.valueOf(start)
                )
                .findFirst(EpubResourceBean.class);
        if(bean ==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 获取某范围内的资源文件
     * @param resource_id
     * @param chapterId
     * @param start
     * @param end
     * @return
     */
    public  static  List<EpubResourceBean> getResource(final String resource_id, final int chapterId,int start, int end){
        List<EpubResourceBean> bean = DataSupport
                .where("bookId = ?  and chapaterId = ? and start>=?  and end <=?",
                        resource_id,
                        String.valueOf(chapterId),
                        String.valueOf(start),
                        String.valueOf(end)
                        )
                .find(EpubResourceBean.class);
        return bean;
    }



}
