package com.jhteck.mvvmdemo.api;

import com.jhteck.mvvmdemo.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:15
 */
public interface Api {
    @GET("users/{userId}")
    Call<User> getUser(
            @Path("userId") String userId
    );
}


