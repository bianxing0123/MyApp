package com.example.demo.okhttp;

import com.example.demo.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DAL {

    public InterfaceName interfaceName;

    public static final DAL shareDAL = new DAL();

    private DAL(){
    }

    public InterfaceName currencyAIPService(){
        OkHttpClient.Builder httpClientBuilder =new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(54000, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(54000,TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(54000,TimeUnit.SECONDS);
        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.interceptors().add(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl("http://192.168.31.102:8080"+"/MyService/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(DALCallAdapterFactory.create())
                .build();
        interfaceName = retrofit.create(InterfaceName.class);
        return interfaceName;
    }
}
