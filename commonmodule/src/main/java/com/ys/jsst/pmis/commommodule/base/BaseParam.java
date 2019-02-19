package com.ys.jsst.pmis.commommodule.base;

/**
 * Created by amos on 2017/9/26.
 */

public class BaseParam {

    /**
     * 用户id
     * */
    protected String user_id;

    /**
     * token
     * */
    protected String token;

    protected String co_id;

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

    public String getCo_id() {
        return co_id;
    }

    public void setCo_id(String co_id) {
        this.co_id = co_id;
    }
}
