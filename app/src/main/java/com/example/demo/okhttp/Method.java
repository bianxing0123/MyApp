package com.example.demo.okhttp;


import com.example.demo.okhttp.entity.entity.UserEntity;
import com.example.demo.okhttp.entity.response.UserResponse;

import rx.Observable;

public class Method {

    public Observable<UserResponse> getLogin(UserEntity entity) {
        return DAL.shareDAL.currencyAIPService().login(entity);
    }

}
