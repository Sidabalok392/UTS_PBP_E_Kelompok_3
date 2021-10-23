package com.example.easy_learning.model;


public class SMP {
    private int idFoto_SMP;
    private String nama_pelajaran_SMP;
    private String deskripsi_SMP;

    public SMP(int idFoto_SMP, String nama_pelajaran_SMP, String deskripsi_SMP) {
        this.idFoto_SMP = idFoto_SMP;
        this.nama_pelajaran_SMP = nama_pelajaran_SMP;
        this.deskripsi_SMP = deskripsi_SMP;
    }

    public int getIdFoto_SMP() {
        return idFoto_SMP;
    }

    public void setIdFoto_SMP(int idFoto_SMP) {
        this.idFoto_SMP = idFoto_SMP;
    }

    public String getNama_pelajaran_SMP() {
        return nama_pelajaran_SMP;
    }

    public void setNama_pelajaran_SMP(String nama_pelajaran_SMP) {
        this.nama_pelajaran_SMP = nama_pelajaran_SMP;
    }

    public String getDeskripsi_SMP() {
        return deskripsi_SMP;
    }

    public void setDeskripsi_SMP(String deskripsi_SMP) {
        this.deskripsi_SMP = deskripsi_SMP;
    }
}
