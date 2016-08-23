package com.packtpub.androidhighperformanceprogramming.flyweight;

public class PackCourier extends Id implements Courier<Pack> {
    private Van van;

    public PackCourier(int id) {
        super(id);
        van = new Van(id);
    }

    public void equip(Pack pack) {
        van.load(pack);
    }
}
