package com.packtpub.androidhighperformanceprogramming.flyweight;

public interface Courier<T> {
    void equip(T param);

    int getId();
}
