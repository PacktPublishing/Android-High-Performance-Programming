package com.packtpub.androidhighperformanceprogramming.intentservice;

import android.app.IntentService;
import android.content.Intent;

public class MyService extends IntentService {

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        switch (intent.getAction()) {
            case "action1":
                handleAction1();
                break;
        }
    }

    private void handleAction1() {
        //code...
    }
}