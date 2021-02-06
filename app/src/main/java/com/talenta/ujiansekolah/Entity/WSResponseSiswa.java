package com.talenta.ujiansekolah.Entity;

import java.util.ArrayList;

public class WSResponseSiswa {
    private String status;
    private String message;
    private Siswa siswa;

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

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }
}
