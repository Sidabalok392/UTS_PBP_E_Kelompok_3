package com.example.easy_learning.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClassTodo {
    private Context context;
    private static DatabaseClassTodo databaseClassTodo;

    private ClassAppDatabase database;

    public DatabaseClassTodo(Context context) {
        this.context=context;
        database= Room.databaseBuilder(context,ClassAppDatabase.class,"classtodo")
                .allowMainThreadQueries().build();
    }

    public static synchronized DatabaseClassTodo getInstance(Context context) {
        if(databaseClassTodo == null) {
            databaseClassTodo=new DatabaseClassTodo(context);
        }
        return databaseClassTodo;
    }

    public ClassAppDatabase getDatabase() { return database; }
}
