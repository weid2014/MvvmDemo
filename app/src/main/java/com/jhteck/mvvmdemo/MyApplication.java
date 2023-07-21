package com.jhteck.mvvmdemo;

import android.app.Application;

import com.jhteck.mvvmdemo.api.Api;
import com.jhteck.mvvmdemo.api.RetrofitClient;
import com.jhteck.mvvmdemo.db.UserDatabase;

/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:18
 */
public class MyApplication extends Application {
    private static UserDatabase userDatabase;
    private static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        userDatabase = UserDatabase.getInstance(this);
        api = RetrofitClient.getInstance().getApi();
    }

    public static UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public  static Api getApi() {
        return api;
    }
}


