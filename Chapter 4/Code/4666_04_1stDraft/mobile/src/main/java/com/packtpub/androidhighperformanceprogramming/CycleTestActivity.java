package com.packtpub.androidhighperformanceprogramming;

import android.view.View;

import com.packtpub.androidhighperformanceprogramming.testing.CyclesTest;

public class CycleTestActivity extends TestActivity<CyclesTest> implements View.OnClickListener {

    @Override
    protected int[] getLengths() {
        return new int[]{2000000, 1000000, 500000};
    }

    @Override
    protected CyclesTest getTester() {
        return new CyclesTest();
    }

    @Override
    protected int getLabelsArray() {
        return R.array.cycles_test_labels;
    }

    @Override
    protected int getSubTitle() {
        return R.string.title_cycle_test;
    }
}
