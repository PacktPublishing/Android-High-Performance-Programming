package com.packtpub.androidhighperformanceprogramming.objectpool;

public class Task implements Runnable {
    private ObjectPool<ThreadPool> pool;
    private int id;
    private static final int WORK_DURATION = 2000;
    private static final int PAUSE_DURATION = 1200;

    public Task(ObjectPool<ThreadPool> pool, int id) {
        this.pool = pool;
        this.id = id;
    }

    public void run() {
        ThreadPool threadPool;
        do {
            threadPool = pool.acquire();
            if (threadPool != null) {
                System.out.println("ThreadPool " + id + ": Object with threadPool no. " + threadPool.getId() + " was borrowed");
                waiting(WORK_DURATION);
                pool.release(threadPool);
                System.out.println("ThreadPool " + id + ": Object with threadPool no. " + threadPool.getId() + " was returned. Ending task.");
            } else {
                System.out.println("No objects available. Waiting...");
                waiting(PAUSE_DURATION);
            }
        } while (threadPool == null);
    }

    private void waiting(int millisec) {
        synchronized (this) {
            try {
                wait(millisec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
