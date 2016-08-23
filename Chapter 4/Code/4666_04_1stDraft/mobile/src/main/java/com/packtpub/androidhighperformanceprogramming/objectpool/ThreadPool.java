package com.packtpub.androidhighperformanceprogramming.objectpool;

public class ThreadPool {
    private long id;

    public ThreadPool(long id) {
        this.id = id;

        System.out.println("Object " + id + " was created");
    }

    public long getId() {
        return id;
    }
}
