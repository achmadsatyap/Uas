package com.satya.uas.Model;

public class Biodata {
    public String namaLengkap, noHp, umur, alamat, email;
    public Biodata() {

    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Biodata(String namaLengkap, String noHp, String umur, String alamat, String email) {
        this.namaLengkap = namaLengkap;
        this.noHp = noHp;
        this.umur = umur;
        this.alamat = alamat;
        this.email = email;
    }
}
