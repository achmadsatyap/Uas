package com.satya.uas.Model;

public class Biodata {
    public String NamaLengkap, NoHp, Umur, Alamat, Email;
    public Biodata() {

    }

    public String getNamaLengkap() {
        return NamaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        NamaLengkap = namaLengkap;
    }

    public String getNoHp() {
        return NoHp;
    }

    public void setNoHp(String noHp) {
        NoHp = noHp;
    }

    public String getUmur() {
        return Umur;
    }

    public void setUmur(String umur) {
        Umur = umur;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Biodata(String namaLengkap, String noHp, String umur, String alamat, String email) {
        NamaLengkap = namaLengkap;
        NoHp = noHp;
        Umur = umur;
        Alamat = alamat;
        Email = email;
    }
}
