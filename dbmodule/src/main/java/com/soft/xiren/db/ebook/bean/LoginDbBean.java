package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-12-11 18:04
 */
public class LoginDbBean extends DataSupport{
    private String token;
    private String user_id;
    private String token_desc;
    private String imei;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getToken_desc() {
        return token_desc;
    }

    public void setToken_desc(String token_desc) {
        this.token_desc = token_desc;
    }


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
}
