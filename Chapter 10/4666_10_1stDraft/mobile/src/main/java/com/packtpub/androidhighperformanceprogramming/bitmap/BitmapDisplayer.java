package com.packtpub.androidhighperformanceprogramming.bitmap;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.packtpub.androidhighperformanceprogramming.R;

public class BitmapDisplayer {
    private BitmapCache bitmapCache;

    public BitmapDisplayer() {
        bitmapCache = new BitmapCache();
    }

    public void loadBitmap(String url, int resId, final ImageView imageView) {
        String imageKey = String.valueOf(resId);
        Bitmap bitmap = bitmapCache.get(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.mipmap.ic_launcher);
            BitmapDownloaderTask task = new BitmapDownloaderTask(bitmapCache, new BitmapDownloaderTask.OnImageReady() {
                @Override
                public void onImageReady(Bitmap bitmap) {
                    imageView.setImageBitmap(bitmap);
                }
            });
            task.execute(url);
        }
    }
}
