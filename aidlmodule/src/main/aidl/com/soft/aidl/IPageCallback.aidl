// IPageCallback.aidl
package com.soft.aidl;

// Declare any non-default types here with import statements

interface IPageCallback {

    /**
     * 显示计算完毕的页码
     * and return values in AIDL.
     */
   void  showPagerNumber(String aString);
}
