package com.si6a.i_laundry;

import com.google.gson.annotations.SerializedName;

public class ValueData<T> {
    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    private T data;

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
