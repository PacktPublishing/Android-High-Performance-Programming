package com.packtpub.androidhighperformanceprogramming.httpresponsecache;

import android.app.Activity;
import android.net.http.HttpResponseCache;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class ResponseCache extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            File httpCacheDir = new File(getCacheDir(), "http");
            long httpCacheSize = 0;
            HttpResponseCache.install(httpCacheDir, httpCacheSize);
        } catch (IOException e) {
            Log.i(getClass().getName(), "HTTP response cache installation failed:" + e);
        }
    }

    protected void onStop() {
        super.onStop();
        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache != null) {
            cache.flush();
        }
    }
}
