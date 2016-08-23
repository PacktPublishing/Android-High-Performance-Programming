package com.packtpub.androidhighperformanceprogramming.bitmap;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class BitmapDownloaderTask extends AsyncTask<String, Void, Bitmap> {
    private BitmapCache bitmapCache;
    private String url;
    private OnImageReady onImageReady;
    int desiredWidth, desiredHeight;

    public BitmapDownloaderTask(BitmapCache bitmapCache, OnImageReady onImageReady) {
        this.bitmapCache = bitmapCache;
        this.onImageReady = onImageReady;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        this.url = params[0];
        Bitmap bitmap = null;
        //Code to download the bitmap...
        new BitmapScaler().scaleUsingCombinedTechniques(url, desiredWidth, desiredHeight, bitmapCache.getBitmapsPool());
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        bitmapCache.add(url, bitmap);
        if (onImageReady != null)
            onImageReady.onImageReady(bitmap);
    }

    public interface OnImageReady {
        void onImageReady(Bitmap bitmap);
    }
}
