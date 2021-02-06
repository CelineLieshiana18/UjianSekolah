package com.talenta.ujiansekolah.Entity;

import java.util.ArrayList;

public class WSResponseSiswa {
    private String status;
    private String message;
    private ArrayList<Siswa> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Siswa> getData() {
        return data;
    }

    public void setSiswa(ArrayList<Siswa> siswa) {
        this.data = siswa;
    }
}
