package com.ys.jsst.pmis.commommodule.eventbean;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-10-21 17:42
 */
public class HeadNewsCollectionEvent {

    private  String resource_id;
    private  int collections;

    public HeadNewsCollectionEvent(int collections, String resource_id) {
        this.collections =collections;
        this.resource_id =resource_id;
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public int getCollections() {
        return collections;
    }

    public void setCollections(int collections) {
        this.collections = collections;
    }
}
