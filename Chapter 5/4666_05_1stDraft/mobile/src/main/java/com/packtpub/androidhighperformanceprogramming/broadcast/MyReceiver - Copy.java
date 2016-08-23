package com.packtpub.androidhighperformanceprogramming.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AsyncReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case "myAction":
                final PendingResult pendingResult = goAsync();
                new Thread() {

                    public void run() {
                        // Do background work
                        pendingResult.finish();
                    }
                }.start();
                break;
        }
    }
}
