package com.example.easy_learning.model;


public class SMA {
    private int idFoto_SMA;
    private String nama_pelajaran_SMA;
    private String deskripsi_SMA;

    public SMA(int idFoto_SMA, String nama_pelajaran_SMA, String deskripsi_SMA) {
        this.idFoto_SMA = idFoto_SMA;
        this.nama_pelajaran_SMA = nama_pelajaran_SMA;
        this.deskripsi_SMA = deskripsi_SMA;
    }

    public int getIdFoto_SMA() {
        return idFoto_SMA;
    }

    public void setIdFoto_SMA(int idFoto_SMA) {
        this.idFoto_SMA = idFoto_SMA;
    }

    public String getNama_pelajaran_SMA() {
        return nama_pelajaran_SMA;
    }

    public void setNama_pelajaran_SMA(String nama_pelajaran_SMA) {
        this.nama_pelajaran_SMA = nama_pelajaran_SMA;
    }

    public String getDeskripsi_SMA() {
        return deskripsi_SMA;
    }

    public void setDeskripsi_SMA(String deskripsi_SMA) {
        this.deskripsi_SMA = deskripsi_SMA;
    }
}
