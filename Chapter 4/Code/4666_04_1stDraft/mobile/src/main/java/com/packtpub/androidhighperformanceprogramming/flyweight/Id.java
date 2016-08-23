package com.packtpub.androidhighperformanceprogramming.flyweight;

public abstract class Id {
    private int id;

    public Id(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
