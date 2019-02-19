package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/***
 * 分类ID
 */
public class ClassifyItem  extends DataSupport{



    //标题
    private String title;
    //类型
    private int type;
   //分类的ID
   private int classify_id;
    //分类的名称
   private String classify_name;
//数据库存储的内容
    public ClassifyItem(String title, int type, int classify_id) {
        this.title = title;
        this.type = type;
        this.classify_id = classify_id;
    }

    public int getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(int classify_id) {
        this.classify_id = classify_id;
    }

    public String getClassify_name() {
        return classify_name;
    }

    public void setClassify_name(String classify_name) {
        this.classify_name = classify_name;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }
}
