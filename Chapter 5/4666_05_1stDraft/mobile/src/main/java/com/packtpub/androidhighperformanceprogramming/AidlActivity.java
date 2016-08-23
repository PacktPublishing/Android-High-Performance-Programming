package com.packtpub.androidhighperformanceprogramming;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.packtpub.androidhighperformanceprogramming.aidl.IRemoteInterface;
import com.packtpub.androidhighperformanceprogramming.aidl.RemoteService;
import com.packtpub.androidhighperformanceprogramming.aidl.Result;

public class AidlActivity extends Activity implements View.OnClickListener{
    private boolean bound = false;
    private IRemoteInterface mIRemoteService;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            mIRemoteService = IRemoteInterface.Stub.asInterface(service);
            bound = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            mIRemoteService = null;
            bound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(AidlActivity.this, RemoteService.class);
        intent.setAction(IRemoteInterface.class.getName());
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        if (bound) {
            try {
                mIRemoteService.sendResult(new Result());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
