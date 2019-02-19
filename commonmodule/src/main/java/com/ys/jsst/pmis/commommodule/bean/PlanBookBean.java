package com.ys.jsst.pmis.commommodule.bean;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-11-29 19:57
 */
public class PlanBookBean {
    private String path;
    private String bookid;
    private String bookname;
//    type   2收费    1免费
    private int  type;
    private String bookimage;
    private String classify_id;

    public String getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(String classify_id) {
        this.classify_id = classify_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage;
    }
}
