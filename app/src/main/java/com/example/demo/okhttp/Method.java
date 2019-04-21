package com.example.demo.okhttp;


import com.example.demo.okhttp.entity.entity.UserEntity;
import com.example.demo.okhttp.entity.response.FoodDetailResponse;
import com.example.demo.okhttp.entity.response.FoodTypeResponse;
import com.example.demo.okhttp.entity.response.ShopListResponse;
import com.example.demo.okhttp.entity.response.UserResponse;

import rx.Observable;

public class Method {

    public Observable<UserResponse> getLogin(UserEntity entity) {
        return DAL.shareDAL.currencyAIPService().login(entity);
    }

    public Observable<ShopListResponse> getShopList() {
        return DAL.shareDAL.currencyAIPService().getShopList();
    }

    public Observable<FoodTypeResponse> getFoodType(int shopid){
        return DAL.shareDAL.currencyAIPService().getFoodType(shopid);
    }

    public Observable<FoodDetailResponse> getFoodDetail(int shopid){
        return DAL.shareDAL.currencyAIPService().getFoodDetail(shopid);
    }

}
