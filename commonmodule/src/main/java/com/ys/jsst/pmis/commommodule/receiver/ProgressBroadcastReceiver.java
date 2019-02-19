package com.ys.jsst.pmis.commommodule.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ys.jsst.pmis.commommodule.eventbean.AddedToReadEvent;
import com.ys.jsst.pmis.commommodule.eventbean.BookProgressEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by shaobing on 2017/11/29.
 */

public class ProgressBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String resource_id = intent.getStringExtra("resource_id");
        int read_progress = intent.getIntExtra("read_progress",0);
        EventBus.getDefault().post(new AddedToReadEvent("event"));
        EventBus.getDefault().post(new BookProgressEvent(resource_id,read_progress+""));
    }

}
