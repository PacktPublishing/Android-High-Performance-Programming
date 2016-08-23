package com.packtpub.androidhighperformanceprogramming.flatbuffer;

import android.util.Log;

import java.io.InputStream;
import java.nio.ByteBuffer;

public class FlatBufferHandler {

    private User loadFlatBuffer(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return User.getRootAsUser(bb);
    }

}

