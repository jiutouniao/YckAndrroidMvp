package com.soft.xiren.db.ebook.bean;

import java.io.Serializable;

public class CapterBean implements Serializable {
    private String resource_id;
    private String catalog_id;
    private String catalog_name;
    private String catalog_desc;
    private int start_index;
    private int end_index;

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public String getCatalog_desc() {
        return catalog_desc;
    }

    public void setCatalog_desc(String catalog_desc) {
        this.catalog_desc = catalog_desc;
    }

    public int getStart_index() {
        return start_index;
    }

    public void setStart_index(int start_index) {
        this.start_index = start_index;
    }

    public int getEnd_index() {
        return end_index;
    }

    public void setEnd_index(int end_index) {
        this.end_index = end_index;
    }

}
