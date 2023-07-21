package com.jhteck.mvvmdemo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jhteck.mvvmdemo.model.User;

/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:17
 */
@Database(entities = {User.class}, version = 2,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "user_db";
    private static UserDatabase userDatabase;

    public static synchronized UserDatabase getInstance(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserDatabase.class,
                            DATABASE_NAME)
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDao userDao();
}

