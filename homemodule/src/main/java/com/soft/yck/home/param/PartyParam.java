package com.soft.yck.home.param;

/**
 * 描述：
 * 作者：shenrunzhou
 * 时间： 2017-04-26 16:03
 */
public class PartyParam {

    //Token认证字符串
    private String token;
    private String type;
    private String self;
    private String user_id;
    private String classify_id;
    //"page_index_resource":"0"
    private int page_index_resource;

    public int getPage_index_resource() {
        return page_index_resource;
    }

    public void setPage_index_resource(int page_index_resource) {
        this.page_index_resource = page_index_resource;
    }

    public String getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(String classify_id) {
        this.classify_id = classify_id;
    }





    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }


}
