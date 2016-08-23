package com.packtpub.androidhighperformanceprogramming.testing;

import android.util.SparseArray;

public interface Tester {
    SparseArray<long[]> test(int[] lengths);
}
