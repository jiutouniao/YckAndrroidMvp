package com.soft.sh.bean;

/**
 * description: 模块
 * 2017-10-24
 * User: jiangdong
 */
public class UpdateBean {

    /**
     * retCode : SUCCESS
     * data : {"id":"1","app_name":"全民阅读app01","version_code":"1","version_name":"1.0.1","desc":"全民阅读APP第一次升级","path":"/resource/app001.apk","retCode":"SUCCESS"}
     */

    private String retCode;
    private DataBean data;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * app_name : 全民阅读app01
         * version_code : 1
         * version_name : 1.0.1
         * desc : 全民阅读APP第一次升级
         * path : /resource/app001.apk
         * retCode : SUCCESS
         */

        private String id;
        private String app_name;
        private String version_code;
        private String version_name;
        private String desc;
        private String path;
        private String retCode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getVersion_code() {
            return version_code;
        }

        public void setVersion_code(String version_code) {
            this.version_code = version_code;
        }

        public String getVersion_name() {
            return version_name;
        }

        public void setVersion_name(String version_name) {
            this.version_name = version_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getRetCode() {
            return retCode;
        }

        public void setRetCode(String retCode) {
            this.retCode = retCode;
        }
    }
}
