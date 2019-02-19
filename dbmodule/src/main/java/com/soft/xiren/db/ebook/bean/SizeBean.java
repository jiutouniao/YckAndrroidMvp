package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * 描述：保存当前界面绘制的相关参数
 * 作者：邵兵
 * 邮箱：2017/5/25 15:07
 */
public class SizeBean extends DataSupport {

    //主键
    private long id;
    /**
     * 正文字体大小（确定画笔）
     */
    private int mFontSize;
    /**
     * 画笔颜色
     */
    private int mFontColor;

    //行间距
    private float mLineSpace;

    /**
     * 每页行数（确定具体行数）
     */
    private int mPageLineCount;
    /**
     * 文字区域宽高（确定宽度）
     */
    private float mVisibleHeight;
    //文本的宽度
    private float mVisibleWidth;

    /**
     * 上下边距高度
     */
    private float marginHeight;
    /**
     * 左右边距宽度
     */
    private float marginWidth;
    /**
     * 0 白色  1淡绿色  2.淡黄色  3黑色
     * 判断背景颜色
     */
    private int theme;
    /**
     * 设置系统亮度
     */
    private String screenBrightness;

    /**
     * 1系统字体  2方正小楷  3华文宋体 4仿宋字体
     */
    private int font;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getmFontSize() {
        return mFontSize;
    }

    public void setmFontSize(int mFontSize) {
        this.mFontSize = mFontSize;
    }

    public int getmFontColor() {
        return mFontColor;
    }

    public void setmFontColor(int mFontColor) {
        this.mFontColor = mFontColor;
    }

    public float getmLineSpace() {
        return mLineSpace;
    }

    public void setmLineSpace(float mLineSpace) {
        this.mLineSpace = mLineSpace;
    }

    public int getmPageLineCount() {
        return mPageLineCount;
    }

    public void setmPageLineCount(int mPageLineCount) {
        this.mPageLineCount = mPageLineCount;
    }

    public float getmVisibleHeight() {
        return mVisibleHeight;
    }

    public void setmVisibleHeight(float mVisibleHeight) {
        this.mVisibleHeight = mVisibleHeight;
    }

    public float getmVisibleWidth() {
        return mVisibleWidth;
    }

    public void setmVisibleWidth(float mVisibleWidth) {
        this.mVisibleWidth = mVisibleWidth;
    }

    public float getMarginHeight() {
        return marginHeight;
    }

    public void setMarginHeight(float marginHeight) {
        this.marginHeight = marginHeight;
    }

    public float getMarginWidth() {
        return marginWidth;
    }

    public void setMarginWidth(float marginWidth) {
        this.marginWidth = marginWidth;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getScreenBrightness() {
        return screenBrightness;
    }

    public void setScreenBrightness(String screenBrightness) {
        this.screenBrightness = screenBrightness;
    }

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }
}
