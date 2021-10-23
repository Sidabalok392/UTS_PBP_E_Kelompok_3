package com.example.easy_learning.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.easy_learning.dao.ClassTodoDao;
import com.example.easy_learning.model.ClassTodo;

@Database(entities={ClassTodo.class}, version=1)
public abstract class ClassAppDatabase extends RoomDatabase {
    public abstract ClassTodoDao classTodoDao();

}