package com.example.demo.okhttp;


import com.example.demo.okhttp.entity.entity.UserEntity;
import com.example.demo.okhttp.entity.response.ShopListResponse;
import com.example.demo.okhttp.entity.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface InterfaceName {

    @POST("userLoginService/userLogin")
    Observable<UserResponse> login(@Body UserEntity entity);

    @POST("shopListService/shopList")
    Observable<ShopListResponse> getShopList();

}
