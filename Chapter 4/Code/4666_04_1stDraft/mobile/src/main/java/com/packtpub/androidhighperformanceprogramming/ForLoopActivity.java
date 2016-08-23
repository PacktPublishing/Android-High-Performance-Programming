package com.packtpub.androidhighperformanceprogramming;

import com.packtpub.androidhighperformanceprogramming.testing.ForLoopTest;
import com.packtpub.androidhighperformanceprogramming.testing.Tester;

public class ForLoopActivity extends TestActivity {

    @Override
    protected int[] getLengths() {
        return new int[]{10000000, 5000000, 1000000};
    }

    @Override
    protected Tester getTester() {
        return new ForLoopTest();
    }

    @Override
    protected int getLabelsArray() {
        return R.array.for_test_labels;
    }

    @Override
    protected int getSubTitle() {
        return R.string.title_for_loop_test;
    }
}
