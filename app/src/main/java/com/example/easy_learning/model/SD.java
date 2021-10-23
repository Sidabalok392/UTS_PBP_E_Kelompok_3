package com.example.easy_learning.model;


public class SD {
    private int idFoto_SD;
    private String nama_pelajaran_SD;
    private String deskripsi_SD;

    public SD(int idFoto_SD, String nama_pelajaran_SD, String deskripsi_SD) {
        this.idFoto_SD = idFoto_SD;
        this.nama_pelajaran_SD = nama_pelajaran_SD;
        this.deskripsi_SD = deskripsi_SD;
    }

    public int getIdFoto_SD() {
        return idFoto_SD;
    }

    public void setIdFoto_SD(int idFoto_SD) {
        this.idFoto_SD = idFoto_SD;
    }

    public String getNama_pelajaran_SD() {
        return nama_pelajaran_SD;
    }

    public void setNama_pelajaran_SD(String nama_pelajaran_SD) {
        this.nama_pelajaran_SD = nama_pelajaran_SD;
    }

    public String getDeskripsi_SD() {
        return deskripsi_SD;
    }

    public void setDeskripsi_SD(String deskripsi_SD) {
        this.deskripsi_SD = deskripsi_SD;
    }
}
