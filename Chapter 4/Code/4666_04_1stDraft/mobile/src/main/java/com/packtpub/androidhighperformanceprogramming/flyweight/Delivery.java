package com.packtpub.androidhighperformanceprogramming.flyweight;

import android.util.Log;

public class Delivery extends Id {
    private Courier<Pack> courier;

    public Delivery(int id) {
        super(id);
        courier = new Factory().getCourier(0);
        Log.d(getClass().getName(), "Creating Delivery " + id + " using Courier " + courier.getId());
    }

    public void deliver(Pack pack, Destination destination) {
        Log.d(getClass().getName(), "Equipping " + pack.getId() + " to Destination " + destination.getId());
        courier.equip(pack);
    }
}
