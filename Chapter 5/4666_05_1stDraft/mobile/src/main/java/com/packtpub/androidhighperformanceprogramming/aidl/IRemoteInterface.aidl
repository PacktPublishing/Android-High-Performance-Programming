package com.packtpub.androidhighperformanceprogramming.aidl;

import com.packtpub.androidhighperformanceprogramming.aidl.Result;

interface IRemoteInterface {
    boolean sendResult(in Result result);
}