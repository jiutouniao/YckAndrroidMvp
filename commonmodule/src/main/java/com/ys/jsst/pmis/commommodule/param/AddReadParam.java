package com.ys.jsst.pmis.commommodule.param;

import java.util.List;

/**
 * description: 加入计划参数传入
 * 2017-5-4
 * User: jiangdong
 */
public class AddReadParam {

    private String user_id;
    private String token;
    private String classify_id;
    private List<String> resource_id;

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

    public String getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(String classify_id) {
        this.classify_id = classify_id;
    }

    public List<String> getResource_id() {
        return resource_id;
    }

    public void setResource_id(List<String> resource_id) {
        this.resource_id = resource_id;
    }
}
