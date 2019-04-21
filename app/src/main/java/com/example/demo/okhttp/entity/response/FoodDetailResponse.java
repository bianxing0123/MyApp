package com.example.demo.okhttp.entity.response;

import com.example.demo.base.BaseResponse;
import com.example.demo.okhttp.entity.entity.FoodBean;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class FoodDetailResponse extends BaseResponse {

    @SerializedName("data")
    public ArrayList<FoodBean> foodBeanArrayList;
}
