package com.packtpub.androidhighperformanceprogramming;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;
import com.packtpub.androidhighperformanceprogramming.gcmnetworkmanager.MyGcmTaskService;

public class GcmNetworkManagerActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        GcmNetworkManager mGcmNetworkManager = GcmNetworkManager.getInstance(this);
        mGcmNetworkManager.schedule(createOnoffTask());
    }

    private Task createPeriodicTask() {
        return new PeriodicTask.Builder()
                .setService(MyGcmTaskService.class)
                .setTag(MyGcmTaskService.MY_TASK)
                .setPeriod(5L)
                .build();
    }

    private Task createOnoffTask() {
        return new OneoffTask.Builder()
                .setService(MyGcmTaskService.class)
                .setTag(MyGcmTaskService.MY_TASK)
                .setExecutionWindow(0, 1000L)
                .build();
    }
}
