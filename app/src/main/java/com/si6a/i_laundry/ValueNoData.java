package com.si6a.i_laundry;

import com.google.gson.annotations.SerializedName;

public class ValueNoData {
    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
