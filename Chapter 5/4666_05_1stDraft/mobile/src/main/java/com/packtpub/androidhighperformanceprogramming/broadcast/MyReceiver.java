package com.packtpub.androidhighperformanceprogramming.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.packtpub.androidhighperformanceprogramming.intentservice.MyService;

public class MyReceiver extends BroadcastReceiver {
    public static final String ACTION = "action";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent sericeIntent = new Intent();
        sericeIntent.setClass(context, MyService.class);
        sericeIntent.setAction(ACTION);
        context.startService(sericeIntent);
    }
}
