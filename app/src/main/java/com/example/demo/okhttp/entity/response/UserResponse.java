package com.example.demo.okhttp.entity.response;

import com.example.demo.base.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class UserResponse extends BaseResponse {

    @SerializedName("data")
    public int id;
}
