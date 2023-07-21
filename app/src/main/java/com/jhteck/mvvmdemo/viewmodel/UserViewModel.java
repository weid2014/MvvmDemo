package com.jhteck.mvvmdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jhteck.mvvmdemo.MyApplication;
import com.jhteck.mvvmdemo.db.UserDao;
import com.jhteck.mvvmdemo.db.UserDatabase;
import com.jhteck.mvvmdemo.model.User;
import com.jhteck.mvvmdemo.resposity.UserRepository;

/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:18
 */
public class UserViewModel  extends AndroidViewModel {
    private LiveData<User> user;
    private UserRepository userRepository;
    private  String userName = "MichaelYe";

    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase database = MyApplication.getUserDatabase();
        UserDao userDao = database.userDao();
        userRepository = new UserRepository(userDao,MyApplication.getApi());
        user = userRepository.getUser(userName);
    }

    public LiveData<User> getUser() {
        return user;
    }
    public void  refresh(){
        userRepository.refresh(userName);
    }
}


