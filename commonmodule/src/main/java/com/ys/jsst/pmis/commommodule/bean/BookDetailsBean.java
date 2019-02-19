package com.ys.jsst.pmis.commommodule.bean;

import com.soft.xiren.db.ebook.bean.CapterBean;

import java.util.List;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-10-9 14:24
 */
public class BookDetailsBean {


    /**
     * retCode : SUCCESS
     * message : 查询成功
     * resource : [{"resource_id":"ebook_00003749","resource_name":"购并的艺术","resource_type":"0","md5":"","original_path":"/ebook/type_04/978-7-300-08641-5.pdf","thumb_pic":"/ebook/thumb_pic/type_04/978-7-300-08641-5.jpg","author":"陈见明著","translater":"","resource_desc":"该书涉及购并的各个环节中至关重要的细节处理方法和技术，总结了成为一名专业的购并人员所必需的能力、品质、技巧和有关的技术，尤其对许多细节的描述引人入胜。","resource_content":"","resource_score":0,"is_free":"1","publisher":"中国人民大学出版社","press":"中国人民大学出版社","fansList":"","praiseList":"中国人民大学出版社","price":0,"create_time":"2017-05-09 09:53:16","is_read":"1","relative_resource_list":[{"report_count":0,"comment_count":0,"collection_count":0,"resource_browse_count":0,"cost_days":0,"price":0,"price_now":0,"is_buy":"0","read_duration":"","read_progress":"","count":0,"score":""}]}]
     */

    private String fanList;
    private String is_read;
    private String retCode;
    private String message;
    private List<ResourceEntity> resource;

    public String getFanList() {
        return fanList;
    }

    public void setFanList(String fanList) {
        this.fanList = fanList;
    }

    public String getIs_read() {
        return is_read;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
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

    public List<ResourceEntity> getResource() {
        return resource;
    }

    public void setResource(List<ResourceEntity> resource) {
        this.resource = resource;
    }

    public static class ResourceEntity {
        /**
         * resource_id : ebook_00003749
         * resource_name : 购并的艺术
         * resource_type : 0
         * md5 :
         * original_path : /ebook/type_04/978-7-300-08641-5.pdf
         * thumb_pic : /ebook/thumb_pic/type_04/978-7-300-08641-5.jpg
         * author : 陈见明著
         * translater :
         * resource_desc : 该书涉及购并的各个环节中至关重要的细节处理方法和技术，总结了成为一名专业的购并人员所必需的能力、品质、技巧和有关的技术，尤其对许多细节的描述引人入胜。
         * resource_content :
         * resource_score : 0
         * is_free : 1
         * publisher : 中国人民大学出版社
         * press : 中国人民大学出版社
         * fansList :
         * praiseList : 中国人民大学出版社
         * price : 0
         * create_time : 2017-05-09 09:53:16
         * is_read : 1
         * relative_resource_list : [{"report_count":0,"comment_count":0,"collection_count":0,"resource_browse_count":0,"cost_days":0,"price":0,"price_now":0,"is_buy":"0","read_duration":"","read_progress":"","count":0,"score":""}]
         */

       private String resource_id;
       private String resource_name;
       private String resource_type;
       private String md5;
       private String original_path;
       private String thumb_pic;
       private String author;
       private String translater;
       private String resource_desc;
       private String resource_content;
       private int resource_score;
       private String is_free;
       private String publisher;
       private String press;
       private String fansList;
       private String ResourceCreate_time;

        public List<String> getFansList_list() {
            return fansList_list;
        }

        public void setFansList_list(List<String> fansList_list) {
            this.fansList_list = fansList_list;
        }

        private List<String> fansList_list;
       private String praiseList;
       private String price;
       private String create_time;
       private String is_read;
       private List<RelativeResourceListEntity> relative_resource_list;

        private List<CapterBean> listChapter;

        public List<CapterBean> getListChapter() {
            return listChapter;
        }

        public void setListChapter(List<CapterBean> listChapter) {
            this.listChapter = listChapter;
        }

        public String getResource_id() {
            return resource_id;
        }

        public void setResource_id(String resource_id) {
            this.resource_id = resource_id;
        }

        public String getResource_name() {
            return resource_name;
        }

        public void setResource_name(String resource_name) {
            this.resource_name = resource_name;
        }

        public String getResource_type() {
            return resource_type;
        }

        public void setResource_type(String resource_type) {
            this.resource_type = resource_type;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getOriginal_path() {
            return original_path;
        }

        public void setOriginal_path(String original_path) {
            this.original_path = original_path;
        }

        public String getThumb_pic() {
            return thumb_pic;
        }

        public void setThumb_pic(String thumb_pic) {
            this.thumb_pic = thumb_pic;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTranslater() {
            return translater;
        }

        public void setTranslater(String translater) {
            this.translater = translater;
        }

        public String getResource_desc() {
            return resource_desc;
        }

        public void setResource_desc(String resource_desc) {
            this.resource_desc = resource_desc;
        }

        public String getResource_content() {
            return resource_content;
        }

        public void setResource_content(String resource_content) {
            this.resource_content = resource_content;
        }

        public int getResource_score() {
            return resource_score;
        }

        public void setResource_score(int resource_score) {
            this.resource_score = resource_score;
        }

        public String getIs_free() {
            return is_free;
        }

        public void setIs_free(String is_free) {
            this.is_free = is_free;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getPress() {
            return press;
        }

        public void setPress(String press) {
            this.press = press;
        }

        public String getFansList() {
            return fansList;
        }

        public void setFansList(String fansList) {
            this.fansList = fansList;
        }

        public String getPraiseList() {
            return praiseList;
        }

        public void setPraiseList(String praiseList) {
            this.praiseList = praiseList;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getIs_read() {
            return is_read;
        }

        public void setIs_read(String is_read) {
            this.is_read = is_read;
        }

        public List<RelativeResourceListEntity> getRelative_resource_list() {
            return relative_resource_list;
        }

        public void setRelative_resource_list(List<RelativeResourceListEntity> relative_resource_list) {
            this.relative_resource_list = relative_resource_list;
        }

        public String getResourceCreate_time() {
            return ResourceCreate_time;
        }

        public void setResourceCreate_time(String resourceCreate_time) {
            ResourceCreate_time = resourceCreate_time;
        }

        public static class RelativeResourceListEntity {
            /**
             * report_count : 0
             * comment_count : 0
             * collection_count : 0
             * resource_browse_count : 0
             * cost_days : 0
             * price : 0
             * price_now : 0
             * is_buy : 0
             * read_duration :
             * read_progress :
             * count : 0
             * score :
             */

           private int report_count;
           private int comment_count;
           private int collection_count;
           private int resource_browse_count;
           private int cost_days;
           private String price;
           private int price_now;
           private String is_buy;
           private String read_duration;
           private String read_progress;
           private int count;
           private String score;

            public int getReport_count() {
                return report_count;
            }

            public void setReport_count(int report_count) {
                this.report_count = report_count;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getCollection_count() {
                return collection_count;
            }

            public void setCollection_count(int collection_count) {
                this.collection_count = collection_count;
            }

            public int getResource_browse_count() {
                return resource_browse_count;
            }

            public void setResource_browse_count(int resource_browse_count) {
                this.resource_browse_count = resource_browse_count;
            }

            public int getCost_days() {
                return cost_days;
            }

            public void setCost_days(int cost_days) {
                this.cost_days = cost_days;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getPrice_now() {
                return price_now;
            }

            public void setPrice_now(int price_now) {
                this.price_now = price_now;
            }

            public String getIs_buy() {
                return is_buy;
            }

            public void setIs_buy(String is_buy) {
                this.is_buy = is_buy;
            }

            public String getRead_duration() {
                return read_duration;
            }

            public void setRead_duration(String read_duration) {
                this.read_duration = read_duration;
            }

            public String getRead_progress() {
                return read_progress;
            }

            public void setRead_progress(String read_progress) {
                this.read_progress = read_progress;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }
        }
    }
}
