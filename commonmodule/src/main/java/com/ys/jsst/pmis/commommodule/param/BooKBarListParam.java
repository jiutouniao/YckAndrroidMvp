package com.ys.jsst.pmis.commommodule.param;

/**
 * 描述：获取贴吧列表参数
 * 作者：shaobing
 * 时间： 2017/4/12 11:17
 */
public class BooKBarListParam {
    //账号
    private String user_id;
    //token
    private String token;
    //书本
    private String  resource_id;
    //当前页数
    private String page_index;

    private String card_id;
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getPage_index() {
        return page_index;
    }

    public void setPage_index(String page_index) {
        this.page_index = page_index;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}

