package com.example.demo.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GJZ
 */

public class BaseResponse {

    @SerializedName("code")
    public int code;

    @SerializedName("msg")
    public String msg;
}
