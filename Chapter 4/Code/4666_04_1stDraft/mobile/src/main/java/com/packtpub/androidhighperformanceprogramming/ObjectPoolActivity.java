package com.packtpub.androidhighperformanceprogramming;

import android.os.Bundle;

import com.packtpub.androidhighperformanceprogramming.objectpool.ObjectPool;
import com.packtpub.androidhighperformanceprogramming.objectpool.Task;
import com.packtpub.androidhighperformanceprogramming.objectpool.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ObjectPoolActivity extends NavigationActivity {
    private ObjectPool<ThreadPool> pool;
    private AtomicLong processNo = new AtomicLong();
    private static final int DEFAULT_CAPACITY = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pool = new ObjectPool<ThreadPool>(5, 10) {
            protected ThreadPool create() {
                return new ThreadPool(processNo.incrementAndGet());
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++)
            executor.execute(new Task(pool, i));
        executor.shutdown();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.content_pattern;
    }

    @Override
    protected int getSubTitle() {
        return R.string.title_object_pool;
    }
}
