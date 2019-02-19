package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.StackHistoryBean;

import org.litepal.crud.DataSupport;
import org.litepal.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：获取当前历史
 * 作者：邵兵
 * 日期：2017/6/1 19:12
 */
public class StackHistoryDbModel {


    /**
     * 获取当前历史
     * @return
     */
    public static  List<StackHistoryBean>  getHistory(){
        List<StackHistoryBean> list = new ArrayList<>();
        try {
            list= DataSupport
                    .where("id >? ", "-1")
                    .order("id desc").limit(10)
                    .find(StackHistoryBean.class);
            if(list==null)list= new ArrayList<>();
        }catch (Exception e){
            LogUtil.e("getHistory :",e);
        }
        return list;
    }


    /**
     * 保存书本相关信息
     */
    public static void saveHistory(String message){
        try {
            DataSupport.deleteAll(StackHistoryBean.class, "message = ? ",message);
            StackHistoryBean bean = new StackHistoryBean();
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
            DataSupport.deleteAll(StackHistoryBean.class);

        }catch (Exception e){
            LogUtil.e("deleteHistory :",e);
        }
    }
}
