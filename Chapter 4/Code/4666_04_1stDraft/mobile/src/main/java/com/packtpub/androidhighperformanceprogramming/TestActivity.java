package com.packtpub.androidhighperformanceprogramming;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.packtpub.androidhighperformanceprogramming.testing.Tester;

public abstract class TestActivity<T extends Tester> extends NavigationActivity implements View.OnClickListener {
    private ProgressDialog progressDialog;
    private GridLayout gridLayout;
    private int[] lengths;
    private T tester;
    private String[] labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.button).setOnClickListener(this);
        gridLayout = (GridLayout) findViewById(R.id.gridlayout);
        lengths = getLengths();
        tester = getTester();
        labels = getResources().getStringArray(getLabelsArray());
        for (int i = 0; i < labels.length; i++) {
            TextView valueView = new TextView(TestActivity.this);
            valueView.setText(labels[i]);
            gridLayout.addView(valueView);
        }
    }

    protected abstract int[] getLengths();

    protected abstract T getTester();

    protected abstract int getLabelsArray();

    @Override
    protected int getContentLayout() {
        return R.layout.content_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                new CycleTestAsyncTask().execute();
                break;
        }
    }

    private class CycleTestAsyncTask extends AsyncTask<Void, Void, SparseArray<long[]>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(TestActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected SparseArray<long[]> doInBackground(Void... params) {
            return tester.test(lengths);
        }

        @Override
        protected void onPostExecute(SparseArray<long[]> sparseArray) {
            super.onPostExecute(sparseArray);
            for (int i = 0; i < lengths.length; i++) {
                int key = sparseArray.keyAt(i);
                TextView textView = new TextView(TestActivity.this);
                textView.setText(key + "");
                gridLayout.addView(textView);
                for (int j = 0; j < labels.length; j++) {
                    TextView valueView = new TextView(TestActivity.this);
                    valueView.setText(sparseArray.get(key)[j] + "");
                    gridLayout.addView(valueView);
                }
            }
            progressDialog.cancel();
        }
    }
}
