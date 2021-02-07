package com.talenta.ujiansekolah.Entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Ujian implements Parcelable {
    private int id;
    private String nama;
    private int waktu;
    private String tipe;
    private String tipe_ujian;
    private String waktu_mulai;
    private String jenis;
    private String status;
    private int kkm;
    private String mata_pelajaran;
    private String bab;
    private String tahun_ajaran;
    private String materi_pokok;
    private String nik;
    private String presentase_pg;
    private String presentasi_isian;

    protected Ujian(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        waktu = in.readInt();
        tipe = in.readString();
        tipe_ujian = in.readString();
        waktu_mulai = in.readString();
        jenis = in.readString();
        status = in.readString();
        kkm = in.readInt();
        mata_pelajaran = in.readString();
        bab = in.readString();
        tahun_ajaran = in.readString();
        materi_pokok = in.readString();
        nik = in.readString();
        presentase_pg = in.readString();
        presentasi_isian = in.readString();
    }

    public static final Creator<Ujian> CREATOR = new Creator<Ujian>() {
        @Override
        public Ujian createFromParcel(Parcel in) {
            return new Ujian(in);
        }

        @Override
        public Ujian[] newArray(int size) {
            return new Ujian[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTipe_ujian() {
        return tipe_ujian;
    }

    public void setTipe_ujian(String tipe_ujian) {
        this.tipe_ujian = tipe_ujian;
    }

    public String getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(String waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getKkm() {
        return kkm;
    }

    public void setKkm(int kkm) {
        this.kkm = kkm;
    }

    public String getMata_pelajaran() {
        return mata_pelajaran;
    }

    public void setMata_pelajaran(String mata_pelajaran) {
        this.mata_pelajaran = mata_pelajaran;
    }

    public String getBab() {
        return bab;
    }

    public void setBab(String bab) {
        this.bab = bab;
    }

    public String getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(String tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public String getMateri_pokok() {
        return materi_pokok;
    }

    public void setMateri_pokok(String materi_pokok) {
        this.materi_pokok = materi_pokok;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPresentase_pg() {
        return presentase_pg;
    }

    public void setPresentase_pg(String presentase_pg) {
        this.presentase_pg = presentase_pg;
    }

    public String getPresentasi_isian() {
        return presentasi_isian;
    }

    public void setPresentasi_isian(String presentasi_isian) {
        this.presentasi_isian = presentasi_isian;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nama);
        dest.writeInt(waktu);
        dest.writeString(tipe);
        dest.writeString(tipe_ujian);
        dest.writeString(waktu_mulai);
        dest.writeString(jenis);
        dest.writeString(status);
        dest.writeInt(kkm);
        dest.writeString(mata_pelajaran);
        dest.writeString(bab);
        dest.writeString(tahun_ajaran);
        dest.writeString(materi_pokok);
        dest.writeString(nik);
        dest.writeString(presentase_pg);
        dest.writeString(presentasi_isian);
    }

    
}
