package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.HistoryBean;
import com.soft.xiren.db.ebook.bean.PageBean;

import org.litepal.crud.DataSupport;
import org.litepal.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：获取当前历史
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class HistoryDbModel {


    /**
     * 获取当前历史
     * @return
     */
    public static  List<HistoryBean>  getHistory(){
        List<HistoryBean> list = new ArrayList<>();
        try {
            list= DataSupport
                    .where("id >? ", "-1")
                    .order("id desc").limit(10)
                    .find(HistoryBean.class);
            if(list==null)list= new ArrayList<>();
        }catch (Exception e){
            LogUtil.e("getHistory :",e);
        }
        return list;
    }


    /**
     * 保存书本相关信息
     */
    public static void saveHistory(String message ){
        try {
            DataSupport.deleteAll(HistoryBean.class, "message = ? ",message);
            HistoryBean bean = new HistoryBean();
            bean.setMessage(message);
            bean.save();
        }catch (Exception e){
            LogUtil.e("saveHistory :",e);
        }
    }

    /**
     * 删除历史
     */
    public static void deleteHistory(){
        try {
            DataSupport.deleteAll(HistoryBean.class);

        }catch (Exception e){
            LogUtil.e("deleteHistory :",e);
        }
    }
}
