package com.example.easy_learning.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="todo")
public class Todo {
    @PrimaryKey(autoGenerate=true)
    private int id;

    @ColumnInfo(name="nama")
    private String nama;

    @ColumnInfo(name="umur")
    private String umur;

    @ColumnInfo(name="alamat")
    private String alamat;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="notelp")
    private String notelp;

    @ColumnInfo(name="username")
    private String username;

    @ColumnInfo(name="password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama=nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur=umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat=alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp=notelp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }
}