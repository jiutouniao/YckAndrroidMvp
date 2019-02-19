package com.ys.jsst.pmis.commommodule.bean;

/**
 * description: 防止连续点击模块
 * 2017-10-30
 * User: jiangdong
 */
public class CommonStopUtils {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
