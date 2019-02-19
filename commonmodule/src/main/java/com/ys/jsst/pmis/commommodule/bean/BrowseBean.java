package com.ys.jsst.pmis.commommodule.bean;

/**
 * 描述：
 * 作者：邵兵
 * 日期：2017/10/20 18:39
 */
public class BrowseBean {


    /**
     * retCode : SUCCESS
     * message : 查询成功
     */

    private String success;
    private String message;
    private String errorMsg;
    private Result result;

    public String getRetCode() {
        return success;
    }

    public void setRetCode(String retCode) {
        this.success = retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {

        private String user_id;
        private String token;
        private String classify_id;
        private String resource_id;
        private String resourceId;
        private String resource_id_append;
        private String retCode;
        private String message;
        private String classify_id_append;
        private int readingPeoples;
        private String classify_level;

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

        public String getResource_id() {
            return resource_id;
        }

        public void setResource_id(String resource_id) {
            this.resource_id = resource_id;
        }

        public String getResourceId() {
            return resourceId;
        }

        public void setResourceId(String resourceId) {
            this.resourceId = resourceId;
        }

        public String getResource_id_append() {
            return resource_id_append;
        }

        public void setResource_id_append(String resource_id_append) {
            this.resource_id_append = resource_id_append;
        }

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

        public String getClassify_id_append() {
            return classify_id_append;
        }

        public void setClassify_id_append(String classify_id_append) {
            this.classify_id_append = classify_id_append;
        }

        public int getReadingPeoples() {
            return readingPeoples;
        }

        public void setReadingPeoples(int readingPeoples) {
            this.readingPeoples = readingPeoples;
        }

        public String getClassify_level() {
            return classify_level;
        }

        public void setClassify_level(String classify_level) {
            this.classify_level = classify_level;
        }
    }

}
