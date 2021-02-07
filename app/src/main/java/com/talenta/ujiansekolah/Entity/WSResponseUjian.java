package com.talenta.ujiansekolah.Entity;

import java.util.ArrayList;

public class WSResponseUjian {
    private String status;
    private String message;
    private ArrayList<Ujian> data;

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

    public ArrayList<Ujian> getData() {
        return data;
    }

    public void setData(ArrayList<Ujian> ujians) {
        this.data = ujians;
    }
}
