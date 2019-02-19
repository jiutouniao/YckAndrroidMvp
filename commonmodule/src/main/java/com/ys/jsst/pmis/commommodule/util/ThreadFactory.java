package com.ys.jsst.pmis.commommodule.util;

/**
 * description:创建普通线程池，创建下载线程池.
 * User: shaobing
 * Date: 2016/6/14
 * Time: 16:40
 */
public class ThreadFactory {
    static ThreadPoolProxy mNormalPool;    // 只需要初始化一次
    static ThreadPoolProxy mDownLoadPool;    // 只需要初始化一次

    /**
     * 普通的线程池
     */
    public static ThreadPoolProxy getNormaPool() {

        if (mNormalPool == null) {
            synchronized (ThreadFactory.class) {
                if (mNormalPool == null) {
                    mNormalPool = new ThreadPoolProxy(5, 5, 3000);
                }
            }
        }

        return mNormalPool;
    }

    /**
     * 下载的线程池
     */
    public static ThreadPoolProxy getDownLoadPool() {

        if (mDownLoadPool == null) {
            synchronized (ThreadFactory.class) {
                if (mDownLoadPool == null) {
                    mDownLoadPool = new ThreadPoolProxy(3, 3, 3000);
                }
            }
        }

        return mDownLoadPool;
    }

}
