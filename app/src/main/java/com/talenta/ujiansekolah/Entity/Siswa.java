package com.talenta.ujiansekolah.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Siswa implements Parcelable {
    private int nik;
    private String nama;
    private String unit;
    private String kelas;
    private int no_absen;

    public Siswa(Siswa siswa) {
        this.nik = siswa.nik;
        this.nama = siswa.nama;
        this.unit = siswa.unit;
        this.kelas = siswa.kelas;
        this.no_absen = siswa.no_absen;
    }

    protected Siswa(Parcel in) {
        nik = in.readInt();
        nama = in.readString();
        unit = in.readString();
        kelas = in.readString();
        no_absen = in.readInt();
    }

    public static final Creator<Siswa> CREATOR = new Creator<Siswa>() {
        @Override
        public Siswa createFromParcel(Parcel in) {
            return new Siswa(in);
        }

        @Override
        public Siswa[] newArray(int size) {
            return new Siswa[size];
        }
    };

    public int getNis() {
        return nik;
    }

    public void setNis(int nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getNo_absen() {
        return no_absen;
    }

    public void setNo_absen(int no_absen) {
        this.no_absen = no_absen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(nik);
        dest.writeString(nama);
        dest.writeString(unit);
        dest.writeString(kelas);
        dest.writeInt(no_absen);
    }
}
