package com.packtpub.androidhighperformanceprogramming.testing;

import android.util.Log;
import android.util.SparseArray;

import java.util.Date;

public class ForLoopTest implements Tester {
    private static final String TAG = "ForLoopsTest";

    @Override
    public SparseArray<long[]> test(int[] lengths) {
        SparseArray<long[]> results = new SparseArray<>();
        for (int i = 0; i < lengths.length; i++) {
            long[] values = new long[3];
            Dummy[] dummies = createArray(lengths[i]);
            values[0] = enhancedCycle(dummies);
            values[1] = fasterCycle(dummies);
            values[2] = classicCycle(dummies);
            results.put(lengths[i], values);
        }
        return results;
    }

    private long classicCycle(Dummy[] dummies) {
        long classicStartTime = new Date().getTime();
        int sum = 0;
        for (int i = 0; i < dummies.length; ++i) {
            sum += dummies[i].dummy;
        }
        long classicEndTime = new Date().getTime();
        long classicDifference = classicEndTime - classicStartTime;
        Log.d(TAG, "Classic - Elapsed time in milliseconds: "
                + classicDifference);
        return classicDifference;
    }

    private long fasterCycle(Dummy[] dummies) {
        long fasterStartTime = new Date().getTime();
        int sum = 0;
        int len = dummies.length;
        for (int i = 0; i < len; ++i) {
            sum += dummies[i].dummy;
        }
        long fasterEndTime = new Date().getTime();
        long fasterDifference = fasterEndTime - fasterStartTime;
        Log.d(TAG, "Faster - Elapsed time in milliseconds: "
                + fasterDifference);
        return fasterDifference;
    }

    private long enhancedCycle(Dummy[] dummies) {
        long enhancedStartTime = new Date().getTime();
        int sum = 0;
        for (Dummy a : dummies) {
            sum += a.dummy;
        }
        long enhancedEndTime = new Date().getTime();
        long enhancedDifference = enhancedEndTime - enhancedStartTime;
        Log.d(TAG, "Enhanced - Elapsed time in milliseconds: "
                + enhancedDifference);
        return enhancedDifference;
    }

    private Dummy[] createArray(int length) {
        Dummy[] dummies = new Dummy[length];
        for (int i = 0; i < length; i++) {
            dummies[i] = new Dummy();
            dummies[i].dummy = i;
        }
        return dummies;
    }

    static class Dummy {
        int dummy;
    }
}
