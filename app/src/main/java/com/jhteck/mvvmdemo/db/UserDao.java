package com.jhteck.mvvmdemo.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jhteck.mvvmdemo.model.User;

/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:16
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void  insertUser(User user);

    @Delete
    void  deleteStudent(User user);

    @Query("SELECT * FROM user WHERE name=:name")
    LiveData<User> getUserByName(String name);
}

