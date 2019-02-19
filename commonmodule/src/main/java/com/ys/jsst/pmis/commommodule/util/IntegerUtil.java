package com.ys.jsst.pmis.commommodule.util;

/**
 * 描述：
 * 作者：邵兵
 * 日期：2017/10/24 17:20
 */
public class IntegerUtil {


    /**
     * 字符串转化为Int
     * @param num
     * @return
     */
    public static int getInteger(String num){
        try {
           return Integer.valueOf(num);
        } catch (Exception e) {
        }
        return 0;
    }


    /**
     * 字符串转化为Int
     * @param num
     * @return
     */
    public static float getFloat(String num){
        try {
            return Float.valueOf(num);
        } catch (Exception e) {
        }
        return 0f;
    }

}
