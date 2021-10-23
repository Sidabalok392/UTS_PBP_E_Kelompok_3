package com.example.easy_learning.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.easy_learning.model.ClassTodo;

import java.util.List;

@Dao
public interface ClassTodoDao {
    @Query("SELECT * FROM classtodo")
    List<ClassTodo> getAllClass();

    @Insert
    void insertClassTodo(ClassTodo classTodo);

    @Update
    void updateClassTodo(ClassTodo classTodo);

    @Delete
    void deleteClassTodo(ClassTodo classTodo);
}