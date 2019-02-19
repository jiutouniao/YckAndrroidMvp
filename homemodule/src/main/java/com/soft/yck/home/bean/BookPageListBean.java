package com.soft.yck.home.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 * 作者：shenrunzhou
 * 时间： 2017-05-11 10:41
 */
public class BookPageListBean implements Serializable{

    /**
     * collection_data : []
     * comment_data : []
     * fansList : []
     * praiseList : []
     * price : 0
     * relative_resource_list : []
     * report_data : []
     * resource_score : 0
     * retCode : SUCCESS
     */

    private String price;
    private int                resource_score;
    private String             retCode;
    private List<?>            collection_data;
    private List<?>            comment_data;
    private List<?>            fansList;
    private List<?>            praiseList;
    private List<?>            relative_resource_list;
    private List<?>            report_data;
    private List<Bookbean> resource;

    public List<Bookbean> getResource() {
        return resource;
    }

    public void setResource(List<Bookbean> resource) {
        this.resource = resource;
    }

    public String getPrice() { return price;}

    public void setPrice(String price) { this.price = price;}

    public int getResource_score() { return resource_score;}

    public void setResource_score(int resource_score) { this.resource_score = resource_score;}

    public String getRetCode() { return retCode;}

    public void setRetCode(String retCode) { this.retCode = retCode;}

    public List<?> getCollection_data() { return collection_data;}

    public void setCollection_data(List<?> collection_data) { this.collection_data = collection_data;}

    public List<?> getComment_data() { return comment_data;}

    public void setComment_data(List<?> comment_data) { this.comment_data = comment_data;}

    public List<?> getFansList() { return fansList;}

    public void setFansList(List<?> fansList) { this.fansList = fansList;}

    public List<?> getPraiseList() { return praiseList;}

    public void setPraiseList(List<?> praiseList) { this.praiseList = praiseList;}

    public List<?> getRelative_resource_list() { return relative_resource_list;}

    public void setRelative_resource_list(List<?> relative_resource_list) { this.relative_resource_list = relative_resource_list;}

    public List<?> getReport_data() { return report_data;}

    public void setReport_data(List<?> report_data) { this.report_data = report_data;}


}
