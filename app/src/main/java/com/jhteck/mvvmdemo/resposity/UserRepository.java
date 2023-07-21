package com.jhteck.mvvmdemo.resposity;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.jhteck.mvvmdemo.api.Api;
import com.jhteck.mvvmdemo.db.UserDao;
import com.jhteck.mvvmdemo.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:18
 */
public class UserRepository {
    private  String TAG = this.getClass().getName();
    private UserDao userDao;
    private Api api;

    public UserRepository(UserDao userDao, Api api) {
        this.userDao = userDao;
        this.api = api;
    }

    public LiveData<User> getUser(final  String name){
        refresh(name);
        return  userDao.getUserByName(name);
    }

    public void refresh(String name) {
        api.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()!=null){
                    //存储到数据库中
                    insertUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void insertUser(User body) {
        //开启工作线程，插入数据到数据库
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(body);
            }
        });
    }
}

