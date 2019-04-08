package com.example.demo.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/3/1 0001.
 */

public class BaseResponse {

    @SerializedName("code")
    public int code;

    @SerializedName("msg")
    public String msg;
}
