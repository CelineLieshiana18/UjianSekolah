package com.talenta.ujiansekolah;

import android.content.Context;
import android.content.SharedPreferences;

import com.talenta.ujiansekolah.Entity.Siswa;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_NIS = "session_student";//nis
    String SESSION_NO_ABSEN = "no_absen";
    String SESSION_UNIT = "unit";
    String SESSION_KELAS = "kelas";
    String SESSION_NAME = "nama";

    public SessionManagement(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(Siswa s){
        editor.putInt(SESSION_NIS,s.getNis()).commit();
        editor.putString(SESSION_KELAS,s.getKelas()).commit();
        editor.putString(SESSION_NAME,s.getNama()).commit();
        editor.putInt(SESSION_NO_ABSEN,s.getNo_absen()).commit();
        editor.putString(SESSION_UNIT,s.getUnit()).commit();
    }

    public int getSession(){
        return sharedPreferences.getInt(SESSION_NIS,0);
    }

    public int getSESSION_NO_ABSEN() {
        return sharedPreferences.getInt(SESSION_NO_ABSEN,0);
    }

    public String getSESSION_UNIT() {
        return sharedPreferences.getString(SESSION_UNIT,"");
    }

    public String getSESSION_KELAS() {
        return sharedPreferences.getString(SESSION_KELAS,"");
    }

    public String getSESSION_NAME() {
        return sharedPreferences.getString(SESSION_NAME,"");
    }

    public void clearSession(){
        editor.putInt(SESSION_NIS,0).commit();
        editor.putInt(SESSION_KELAS,0).commit();
        editor.putInt(SESSION_NO_ABSEN,0).commit();
        editor.putInt(SESSION_NAME,0).commit();
        editor.putInt(SESSION_UNIT,0).commit();
    }

}
