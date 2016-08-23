package com.packtpub.androidhighperformanceprogramming.gcmnetworkmanager;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

public class MyGcmTaskService extends GcmTaskService {
    public static final String MY_TASK = "myTask";

    @Override
    public int onRunTask(TaskParams taskParams) {
        switch (taskParams.getTag()) {
            case MY_TASK:
                //task code...
                return GcmNetworkManager.RESULT_SUCCESS;
        }
        return GcmNetworkManager.RESULT_SUCCESS;
    }
}
