package com.packtpub.androidhighperformanceprogramming.flyweight;

import android.util.SparseArray;

public class Factory {
    private static SparseArray<Courier> pool;

    public Factory() {
        if (pool == null)
            pool = new SparseArray<>();
    }

    public Courier getCourier(int type) {
        Courier courier = pool.get(type);
        if (courier == null) {
            courier = create(type);
            pool.put(type, courier);
        }
        return courier;
    }

    private Courier create(int type) {
        Courier courier = null;
        switch (type) {
            case 0:
                courier = new PackCourier(0);
        }
        return courier;
    }
}