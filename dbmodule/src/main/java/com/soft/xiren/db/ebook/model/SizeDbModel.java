package com.soft.xiren.db.ebook.model;

import android.graphics.Paint;
import android.util.Log;

import com.soft.xiren.db.ebook.bean.SizeBean;
import org.litepal.crud.DataSupport;
import org.litepal.util.LogUtil;

import java.util.List;

/**
 * 描述：相关尺寸参数
 * 作者：邵兵
 * 日期：2017/6/3 12:16
 */
public class SizeDbModel {

    /**
     * 这里需要防止空指针
     * @return
     */
    public synchronized static SizeBean getSize(){
        SizeBean firstNews = DataSupport.findFirst(SizeBean.class);
        return firstNews;
    }

    /**
     * 获取屏幕的亮度
     * @return
     */
    public synchronized static float getScreenBrightness(){
        float bright = 0.5f;
        try {
            bright = Float.valueOf(getSize().getScreenBrightness());
        }catch (Exception e){
        }
        return bright;
    }

    /**
     * 更新当前亮度
     * @return
     */
    public synchronized static void saveScreenBrightness(float screenBrightness){
        SizeBean sizeBean =  getSize();
        sizeBean.setScreenBrightness(String.valueOf(screenBrightness));
        sizeBean.update(sizeBean.getId());
        Log.d("LogUtil","saveScreenBrightness  :" +getSize().getScreenBrightness());
    }


    /**
     * 0 白色  1淡绿色  2淡黄色  3.黑色
     * @return
     */
    public synchronized static int getTheme(){
        return getSize().getTheme();
    }

    /**
     * 保存主题
     * @return
     */
    public synchronized static void saveTheme(int theme){
        SizeBean sizeBean =  getSize();
        sizeBean.setTheme(theme);
        sizeBean.update(sizeBean.getId());
    }


    /**
     * 获取字体
     * @return
     */
    public synchronized static int getFont(){
        return getSize().getFont();
    }
    /**
     * 保存字体
     * @return
     */
    public synchronized static void saveFont(int font){
        SizeBean sizeBean =  getSize();
        sizeBean.setFont(font);
        sizeBean.update(sizeBean.getId());
    }


    /**
     * 获取字体大小
     * @return
     */
    public static int getFontSize(){
        return getSize().getmFontSize();
    }

    /**
     *获取行数
     * @return
     */
    public static int getPageLineCount(){
        return getSize().getmPageLineCount();
    }

    /**
     * 保存字体大小
     * @return
     */
    public static void saveFontSize(int font){
        SizeBean sizeBean =  getSize();
        sizeBean.setmFontSize(font);
        sizeBean.update(sizeBean.getId());
    }

}
