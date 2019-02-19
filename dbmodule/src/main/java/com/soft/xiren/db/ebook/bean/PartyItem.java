package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * description: 党建相关描述
 * Date: 2016/6/21 11:48
 * User: shaobing
 */
public class PartyItem
        extends DataSupport implements Serializable,Comparable<PartyItem>
{
    /**
     *  1 代表更多 2代表普通的选项
     */
    private int type;
    private String title;
    private String imageUrl;
    private String author;
    private String desc;
    //classify_id也用imageUrl字段存储

    private String classify_id;

    /*public PartyItem(int type, String title, String classify_id) {
        this.type = type;
        this.title = title;
        this.classify_id = classify_id;
    }*/



    public PartyItem() {
        super();
    }

    public PartyItem(int type, String title, String imageUrl, String author, String desc) {
        this.type = type;
        this.title = title;
        this.imageUrl = imageUrl;
        this.author = author;
        this.desc = desc;
    }

    public PartyItem(int type, String title, String imageUrl) {
        this.type = type;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public PartyItem(int type, String title) {
        this.type = type;
        this.title = title;

    }
    /*public void setClassify_id(String classify_id) {
        this.classify_id = classify_id;
    }

    public String getClassify_id() {
        return classify_id;
    }
*/

    @Override
    public String toString() {
        return "PartyItem{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PartyItem){
            if(this.getImageUrl().equals(((PartyItem)obj).getImageUrl())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(PartyItem partyItem) {
        return Integer.valueOf(this.getImageUrl()).compareTo(Integer.valueOf(partyItem.getImageUrl()));
    }
}
