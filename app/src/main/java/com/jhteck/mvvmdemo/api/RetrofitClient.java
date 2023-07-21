package com.jhteck.mvvmdemo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:15
 */
public class RetrofitClient {
    private  static  final  String BASE_URL = "https://api.github.com/";
    private  static  RetrofitClient retrofitClient;
    private Retrofit retrofit;

    public RetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public  static  synchronized  RetrofitClient getInstance(){
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();
        }
        return  retrofitClient;
    }

    public  Api getApi(){
        return  retrofit.create(Api.class);
    }
}


