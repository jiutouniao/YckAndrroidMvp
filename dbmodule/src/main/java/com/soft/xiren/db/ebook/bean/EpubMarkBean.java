package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * 描述：针对epub操作 0:书签 1:划线 2:报错 3:想法  4.全篇写想法
 * 作者：邵兵
 * 邮箱：2017/6/1 17:20
 */
public class EpubMarkBean extends DataSupport implements Serializable {

    /**
     * 服务器ID
     */
    private int op_count;

    private String card_id;

    /**
     * 主键
     */
    private long id;
    /**
     * 0:书签 1:划线 2:报错 3:想法  4.全篇写想法
     */
    private int type;
    /**
     * 存储当前书本
     */
    private String bookId;
    /**
     * 章节标题
     */
    private String section_name;
    /**
     * 章节ID
     */
    private int pageChapter;
    /**
     * 当前页在章节中开始字符的位置
     */
    private int curBeginPos;
    /**
     * 当前页在章节中结束字符位置
     */
    private int curEndPos;
    /**
     * 操作内容 划线的时候为 12345    想法的时候是评论内容  书签啥都不穿
     */
    private String op_content;
    /**
     * 想法的时间
     */
    private String create_time;
    /**
     * 是否可见  1 可见  0 不可见
     */
    private String see_able;
    /**
     * 显示用户昵称
     */
    private String nick_name;
    /**
     * 显示用户图片
     */
    private String head_image;
    /**
     * 选中内筒  划线为划线内容   想法为想法内容   书签为书签内容
     * @return
     */
    private String sel_content;

    public int getOp_count() {
        return op_count;
    }

    public void setOp_count(int op_count) {
        this.op_count = op_count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public int getPageChapter() {
        return pageChapter;
    }

    public void setPageChapter(int pageChapter) {
        this.pageChapter = pageChapter;
    }

    public int getCurBeginPos() {
        return curBeginPos;
    }

    public void setCurBeginPos(int curBeginPos) {
        this.curBeginPos = curBeginPos;
    }

    public int getCurEndPos() {
        return curEndPos;
    }

    public void setCurEndPos(int curEndPos) {
        this.curEndPos = curEndPos;
    }

    public String getOp_content() {
        return op_content;
    }

    public void setOp_content(String op_content) {
        this.op_content = op_content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSee_able() {
        return see_able;
    }

    public void setSee_able(String see_able) {
        this.see_able = see_able;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public String getSel_content() {
        return sel_content;
    }

    public void setSel_content(String sel_content) {
        this.sel_content = sel_content;
    }


    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
