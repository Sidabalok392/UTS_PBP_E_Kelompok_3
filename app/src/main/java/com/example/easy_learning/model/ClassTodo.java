package com.example.easy_learning.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="classtodo")
public class ClassTodo {
    @PrimaryKey(autoGenerate=true)
    private int id;

    @ColumnInfo(name="iduser")
    private int iduser;

    @ColumnInfo(name="namapelajaran")
    private String namapelajaran;

    @ColumnInfo(name="gambarpelajaran")
    private String gambarpelajaran;

    @ColumnInfo(name="deskripsipelajaran")
    private String deskripsipelajaran;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNamapelajaran() {
        return namapelajaran;
    }

    public void setNamapelajaran(String namapelajaran) {
        this.namapelajaran = namapelajaran;
    }

    public String getGambarpelajaran() {
        return gambarpelajaran;
    }

    public void setGambarpelajaran(String gambarpelajaran) {
        this.gambarpelajaran = gambarpelajaran;
    }

    public String getDeskripsipelajaran() {
        return deskripsipelajaran;
    }

    public void setDeskripsipelajaran(String deskripsipelajaran) {
        this.deskripsipelajaran = deskripsipelajaran;
    }
}