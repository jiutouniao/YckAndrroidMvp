package com.ys.jsst.pmis.commommodule.bean;

import java.util.List;

/**
 * 描述：判断书吧是否存在
 * 作者：邵兵
 * 日期：2017/6/16 10:35
 */
public class ResourceParam {


    /**
     * resource_id : ["ebook_00003349"]
     * token : 1508485196481
     * user_id : shaobing
     */

    private String token;
    private String user_id;
    private List<String> resource_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<String> getResource_id() {
        return resource_id;
    }

    public void setResource_id(List<String> resource_id) {
        this.resource_id = resource_id;
    }
}
