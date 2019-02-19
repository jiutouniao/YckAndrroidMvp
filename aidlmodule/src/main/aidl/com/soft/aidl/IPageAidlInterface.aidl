// IPageAidlInterface.aidl
package com.soft.aidl;

import com.soft.aidl.IPageCallback;

// Declare any non-default types here with import statements

interface IPageAidlInterface {


    void getPageNumbers( String bookname,String resource_id);

    void stopPageNumbers( boolean aBoolean);

    void registerCallback(IPageCallback cb);

    void unregisterCallback(IPageCallback cb);

}
