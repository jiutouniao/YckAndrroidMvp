package com.ys.jsst.pmis.commommodule.bean;

import java.util.List;

/**
 * 描述：
 * 作者：邵兵
 * 日期：2017/9/19 19:25
 */
public class CommHotKeyWordBean {


    /**
     * retCode : SUCCESS
     * message : 查询成功
     */

    private String retCode;
    private String message;
    private List<String> resource;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getResource() {
        return resource;
    }

    public void setResource(List<String> resource) {
        this.resource = resource;
    }
}
