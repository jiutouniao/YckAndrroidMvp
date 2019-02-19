package com.ys.jsst.pmis.commommodule.bean;

import java.util.List;

/**
 * 描述：
 * 作者：邵兵
 * 日期：2017/10/20 18:39
 */
public class ResourcesBean {


    /**
     * retCode : SUCCESS
     * message : 查询成功
     */

    private String retCode;
    private String message;
    private List<ResourceBean> resource;

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

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * resource_id : ebook_00003351
         * resource_name : 禅真后史
         * resource_type : 0
         * md5 :
         * original_path : /ebook/type_03/978-7-9993-1073-8.epub
         * thumb_pic : /ebook/thumb_pic/type_03/978-7-9993-1073-8.jpg
         * author : (明)陶辅
         * translater :
         * resource_desc : 闯贼之变，邸报断绝。民间颇有流传，中外大震。金陵群亡赖，挟饥军思逞，汹甚。勋绅富室，重足立矣。大司马史可法，将有勤王之行。诸言路属宫詹曰广止之，且内顾根本地。曰广力折之，怂恿趣严计守御；即发。越日集议，部分兵各门。仍责城巡城御史督察，而郭维经则中城行栅，以维经官金陵久，素得民故也。其护陵防江，则守备太监韩赞周，同魏国公徐弘基，诚意伯刘孔昭，咸加毖焉。
         * resource_content :
         * resource_score : 0
         * is_free : 1
         * publisher : 北京社馆直通车科技有限公司
         * press : 北京社馆直通车科技有限公司
         * fansList :
         * praiseList : 北京社馆直通车科技有限公司
         * price : 1
         * read_progress : 84
         * create_time : 2017-10-21 13:25:25
         * is_read : 1
         * ResourceCreate_time : 2017-05-09 09:52:33
         * relative_resource_list : [{"report_count":0,"comment_count":0,"collection_count":0,"resource_browse_count":0,"cost_days":0,"price":0,"price_now":0,"is_buy":"0","read_duration":"5083","read_progress":"84","count":0,"score":""}]
         * section_list : 3,10,7,25,50,0,15,34,45,37,29,47,51,40,42,48,30,54
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
        private String praiseList;
        private String price;
        private String read_progress;
        private String create_time;
        private String is_read;
        private String ResourceCreate_time;
        private String section_list;
        private List<RelativeResourceListBean> relative_resource_list;

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

        public String getRead_progress() {
            return read_progress;
        }

        public void setRead_progress(String read_progress) {
            this.read_progress = read_progress;
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

        public String getResourceCreate_time() {
            return ResourceCreate_time;
        }

        public void setResourceCreate_time(String ResourceCreate_time) {
            this.ResourceCreate_time = ResourceCreate_time;
        }

        public String getSection_list() {
            return section_list;
        }

        public void setSection_list(String section_list) {
            this.section_list = section_list;
        }

        public List<RelativeResourceListBean> getRelative_resource_list() {
            return relative_resource_list;
        }

        public void setRelative_resource_list(List<RelativeResourceListBean> relative_resource_list) {
            this.relative_resource_list = relative_resource_list;
        }

        public static class RelativeResourceListBean {
            /**
             * report_count : 0
             * comment_count : 0
             * collection_count : 0
             * resource_browse_count : 0
             * cost_days : 0
             * price : 0
             * price_now : 0
             * is_buy : 0
             * read_duration : 5083
             * read_progress : 84
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
