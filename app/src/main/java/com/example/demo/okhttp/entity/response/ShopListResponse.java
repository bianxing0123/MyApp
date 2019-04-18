package com.example.demo.okhttp.entity.response;

import com.example.demo.base.BaseResponse;
import com.example.demo.okhttp.entity.entity.ShopInfoEntity;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class ShopListResponse extends BaseResponse {

    @SerializedName("data")
    public ArrayList<ShopInfoEntity> shopList;
}
