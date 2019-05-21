package com.akb.ferry.akbuts10116154.model;

/**
 * NIM : 10116154
 * Nama : Ferry Hermawan
 * Kelas : IF4
 * Tgl Pengerjaan : 19 Mei 2019
 */

public class TemanModel {
    public String NIM, nama, kelas, telpon, email, instagram;

    public TemanModel() {
    }

    public TemanModel(String NIM, String nama, String kelas, String telpon, String email, String instagram) {
        this.NIM = NIM;
        this.nama = nama;
        this.kelas = kelas;
        this.telpon = telpon;
        this.email = email;
        this.instagram = instagram;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
