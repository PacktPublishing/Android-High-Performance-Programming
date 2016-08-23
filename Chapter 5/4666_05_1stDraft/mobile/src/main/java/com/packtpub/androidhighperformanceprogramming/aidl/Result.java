package com.packtpub.androidhighperformanceprogramming.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Result implements Parcelable {
    private String result;
    private int code;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.result);
        dest.writeInt(this.code);
    }

    public Result() {
    }

    protected Result(Parcel in) {
        this.result = in.readString();
        this.code = in.readInt();
    }

    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}