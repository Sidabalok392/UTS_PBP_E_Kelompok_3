package com.example.easy_learning.model;

public class SMK {
    private int idFoto_SMK;
    private String nama_pelajaran_SMK;
    private String deskripsi_SMK;

    public SMK(int idFoto_SMK, String nama_pelajaran_SMK, String deskripsi_SMK) {
        this.idFoto_SMK = idFoto_SMK;
        this.nama_pelajaran_SMK = nama_pelajaran_SMK;
        this.deskripsi_SMK = deskripsi_SMK;
    }

    public int getIdFoto_SMK() {
        return idFoto_SMK;
    }

    public void setIdFoto_SMK(int idFoto_SMK) {
        this.idFoto_SMK = idFoto_SMK;
    }

    public String getNama_pelajaran_SMK() {
        return nama_pelajaran_SMK;
    }

    public void setNama_pelajaran_SMK(String nama_pelajaran_SMK) {
        this.nama_pelajaran_SMK = nama_pelajaran_SMK;
    }

    public String getDeskripsi_SMK() {
        return deskripsi_SMK;
    }

    public void setDeskripsi_SMK(String deskripsi_SMK) {
        this.deskripsi_SMK = deskripsi_SMK;
    }
}
