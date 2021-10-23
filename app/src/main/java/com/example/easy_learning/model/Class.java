package com.example.easy_learning.model;

public class Class {
    private String classs;

    private String namaPelajaran;
    private String gambarPelajaran;

    public Class(String classs, String namaPelajaran, String gambarPelajaran) {
        this.classs = classs;
        this.namaPelajaran = namaPelajaran;
        this.gambarPelajaran = gambarPelajaran;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getNamaPelajaran() {
        return namaPelajaran;
    }

    public void setNamaPelajaran(String namaPelajaran) {
        this.namaPelajaran = namaPelajaran;
    }

    public String getGambarPelajaran() {
        return gambarPelajaran;
    }

    public void setGambarPelajaran(String gambarPelajaran) {
        this.gambarPelajaran = gambarPelajaran;
    }
}
