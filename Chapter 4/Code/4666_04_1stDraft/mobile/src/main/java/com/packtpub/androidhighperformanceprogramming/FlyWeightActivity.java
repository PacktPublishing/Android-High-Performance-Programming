package com.packtpub.androidhighperformanceprogramming;

import android.os.Bundle;

import com.packtpub.androidhighperformanceprogramming.flyweight.Delivery;
import com.packtpub.androidhighperformanceprogramming.flyweight.Destination;
import com.packtpub.androidhighperformanceprogramming.flyweight.Pack;

public class FlyWeightActivity extends NavigationActivity {
    private static final int DEFAULT_COURIER_NUMBER = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Delivery deliveries[] = new Delivery[DEFAULT_COURIER_NUMBER];
        for (int i = 0; i < DEFAULT_COURIER_NUMBER; i++) {
            deliveries[i] = new Delivery(i);
        }
        deliveries[0].deliver(new Pack(0), new Destination(0));
        deliveries[1].deliver(new Pack(1), new Destination(1));
    }

    @Override
    protected int getContentLayout() {
        return R.layout.content_pattern;
    }

    @Override
    protected int getSubTitle() {
        return R.string.title_fly_weight;
    }
}
