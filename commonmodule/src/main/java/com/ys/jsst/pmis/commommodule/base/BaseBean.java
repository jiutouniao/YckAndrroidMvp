package com.ys.jsst.pmis.commommodule.base;

import java.io.Serializable;

/**
 * 描述：BaseBean 基础类
 * 作者：shaobing
 * 时间： 2017/2/17 14:43
 */
public class BaseBean<T> implements Serializable {
    private static final long serialVersionUID = -2393442445710353890L;
    /**
     * retCode : SUCCESS  ERROR
     */
    private String retCode;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;
    //当前科目错题总数
    private String count;
    // 令牌
    private String token;
    // 角色
    private String role;

    /**
     * 网络访问 APK 路径
     */
    private String file_path;

    /**
     * 当前APK 版本号
     */
    private String version;
    /**
     * 当前APK名字
     */
    private String app_name;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }
}
