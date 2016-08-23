package com.packtpub.androidhighperformanceprogramming.flyweight;

import android.util.Log;

public class Van extends Id {

    public Van(int id) {
        super(id);
    }

    public void load(Pack load) {
        Log.d(getClass().getName(), "Loading Pack " + load.getId() + " on Van " + getId());
    }
}
