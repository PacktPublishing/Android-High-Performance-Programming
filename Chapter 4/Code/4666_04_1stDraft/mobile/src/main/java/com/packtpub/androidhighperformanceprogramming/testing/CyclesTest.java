package com.packtpub.androidhighperformanceprogramming.testing;

import android.util.Log;
import android.util.SparseArray;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CyclesTest implements Tester{
    private static final String TAG = "CyclesTest";

    @Override
    public SparseArray<long[]> test(int[] lengths) {
        SparseArray<long[]> results = new SparseArray<>();
        for (int i = 0; i < lengths.length; i++) {
            long[] values = new long[3];
            List list = createArray(lengths[i]);
            values[0] = iteratorCycle(list);
            values[1] = whileCycle(list);
            values[2] = forCycle(list);
            results.put(lengths[i], values);
        }
        return results;
    }

    private long iteratorCycle(List<String> list) {
        long iteratorStartTime = new Date().getTime();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String stemp = iterator.next();
        }
        long iteratorEndTime = new Date().getTime();
        long iteratorDifference = iteratorEndTime - iteratorStartTime;
        Log.d(TAG, "Iterator - Elapsed time in milliseconds: "
                + iteratorDifference);
        return iteratorDifference;
    }

    private long whileCycle(List<String> list) {
        long whileStartTime = new Date().getTime();
        int i = 0;
        while (i < list.size()) {
            String stemp = list.get(i);
            i++;
        }
        long whileEndTime = new Date().getTime();
        long whileDifference = whileEndTime - whileStartTime;
        Log.d(TAG, "While - Elapsed time in milliseconds: "
                + whileDifference);
        return whileDifference;
    }

    private long forCycle(List<String> list) {
        long forStartTime = new Date().getTime();
        for (int i = 0; i < list.size(); i++) {
            String stemp = list.get(i);
        }
        long forEndTime = new Date().getTime();
        long forDifference = forEndTime - forStartTime;
        Log.d(TAG, "For - Elapsed time in milliseconds: "
                + forDifference);
        return forDifference;
    }

    private List createArray(int length) {
        String sArray[] = new String[length];
        for (int i = 0; i < length; i++)
            sArray[i] = "Array " + i;
        return Arrays.asList(sArray);
    }
}
