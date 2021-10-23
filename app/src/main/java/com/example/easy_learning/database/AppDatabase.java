package com.example.easy_learning.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.easy_learning.dao.TodoDao;
import com.example.easy_learning.model.Todo;

@Database(entities={Todo.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();

}