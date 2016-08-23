package com.packtpub.androidhighperformanceprogramming.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Set;

public class BitmapScaler {

    public Bitmap scaleUsingInSampleSize(String url, int desiredHeight, int desiredWidth, Set<SoftReference<Bitmap>> bitmapsPool) {
        //Options creation
        BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();

        //Reading source resolution
        bmpFactoryOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(url, bmpFactoryOptions);

        int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight / (float) desiredHeight);
        int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth / (float) desiredWidth);

        //Setting properties to obtain the desired result
        if (heightRatio > 1 || widthRatio > 1) {
            if (heightRatio > widthRatio) {
                bmpFactoryOptions.inSampleSize = heightRatio;
            } else {
                bmpFactoryOptions.inSampleSize = widthRatio;
            }
        }

        //Rerstoring the Options
        bmpFactoryOptions.inJustDecodeBounds = false;

        addOptions(bmpFactoryOptions, bitmapsPool);

        //Loading Bitmap
        return BitmapFactory.decodeFile(url, bmpFactoryOptions);
    }

    public Bitmap scaleUsingInTargetDensity(String url, int desiredHeight, int desiredWidth, Set<SoftReference<Bitmap>> bitmapsPool) {
        //Options creation
        BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();

        //Reading source resolution
        bmpFactoryOptions.inJustDecodeBounds = true;
        Bitmap bm = BitmapFactory.decodeFile(url, bmpFactoryOptions);

        //Setting properties to obtain the desired result
        bmpFactoryOptions.inScaled = true;
        bmpFactoryOptions.inDensity = desiredWidth;
        bmpFactoryOptions.inTargetDensity = bmpFactoryOptions.outWidth;

        //Rerstoring the Options
        bmpFactoryOptions.inJustDecodeBounds = false;

        addOptions(bmpFactoryOptions, bitmapsPool);

        //Loading Bitmap
        return BitmapFactory.decodeFile(url, bmpFactoryOptions);
    }

    public Bitmap scaleUsingCombinedTechniques(String url, int desiredHeight, int desiredWidth, Set<SoftReference<Bitmap>> bitmapsPool) {
        //Options creation
        BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();

        //Reading source resolution
        bmpFactoryOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(url, bmpFactoryOptions);

        int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight / (float) desiredHeight);
        int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth / (float) desiredWidth);

        //Setting properties to obtain the desired result
        if (heightRatio > 1 || widthRatio > 1) {
            if (heightRatio > widthRatio) {
                bmpFactoryOptions.inSampleSize = heightRatio;
            } else {
                bmpFactoryOptions.inSampleSize = widthRatio;
            }
        }
        bmpFactoryOptions.inScaled = true;
        bmpFactoryOptions.inDensity = desiredWidth;
        bmpFactoryOptions.inTargetDensity = desiredWidth * bmpFactoryOptions.inSampleSize;

        //Rerstoring the Options
        bmpFactoryOptions.inJustDecodeBounds = false;

        addOptions(bmpFactoryOptions, bitmapsPool);

        //Loading Bitmap
        return BitmapFactory.decodeFile(url, bmpFactoryOptions);
    }


    public Bitmap decode(String url) {
        //Options creation
        BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();

        bmpFactoryOptions.inPreferredConfig = Bitmap.Config.RGB_565;

        //Loading Bitmap
        return BitmapFactory.decodeFile(url, bmpFactoryOptions);
    }


    private void addOptions(BitmapFactory.Options options, Set<SoftReference<Bitmap>> bitmapsPool) {
        options.inMutable = true;
        Bitmap inBitmap = getBitmapFromPool(options, bitmapsPool);
        if (inBitmap != null) {
            options.inBitmap = inBitmap;
        }
    }

    private Bitmap getBitmapFromPool(BitmapFactory.Options options, Set<SoftReference<Bitmap>> bitmapsPool) {
        Bitmap bitmap = null;
        if (bitmapsPool != null && !bitmapsPool.isEmpty()) {
            synchronized (bitmapsPool) {
                final Iterator<SoftReference<Bitmap>> iterator
                        = bitmapsPool.iterator();
                Bitmap item;
                while (iterator.hasNext()) {
                    item = iterator.next().get();
                    if (null != item && item.isMutable()) {
                        if (canBitmapBeReused(item, options)) {
                            bitmap = item;
                            iterator.remove();
                            break;
                        }
                    } else {
                        iterator.remove();
                    }
                }
            }
        }
        return bitmap;
    }

    private boolean canBitmapBeReused(
            Bitmap bitmap, BitmapFactory.Options options) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int width = options.outWidth / options.inSampleSize;
            int height = options.outHeight / options.inSampleSize;
            int byteCount = width * height * getBytesPerPixel(bitmap.getConfig());
            return byteCount <= bitmap.getAllocationByteCount();
        }
        return bitmap.getWidth() == options.outWidth
                && bitmap.getHeight() == options.outHeight
                && options.inSampleSize == 1;
    }

    private int getBytesPerPixel(Bitmap.Config config) {
        switch (config) {
            case ARGB_8888:
                return 4;
            case RGB_565:
            case ARGB_4444:
                return 2;
            default:
            case ALPHA_8:
                return 1;
        }
    }



}
