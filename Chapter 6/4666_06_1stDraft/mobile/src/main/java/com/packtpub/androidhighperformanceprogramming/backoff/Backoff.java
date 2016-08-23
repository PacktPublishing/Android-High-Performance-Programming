package com.packtpub.androidhighperformanceprogramming.backoff;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import javax.net.ssl.SSLHandshakeException;

public class Backoff {
    private static final int BASE_DURATION = 1000;
    private static final int[] BACK_OFF = new int[]{1, 2, 4, 8, 16, 32, 64};

    public static InputStream execute(String urlString) {
        for (int attempt = 0; attempt < BACK_OFF.length; attempt++) {
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                return connection.getInputStream();
            } catch (SocketTimeoutException | SSLHandshakeException e) {
                try {
                    Thread.sleep(BACK_OFF[attempt] * BASE_DURATION);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
