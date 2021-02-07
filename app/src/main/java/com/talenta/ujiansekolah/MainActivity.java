package com.talenta.ujiansekolah;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.talenta.ujiansekolah.Entity.Siswa;
import com.talenta.ujiansekolah.Entity.WSResponseSiswa;
import com.talenta.ujiansekolah.Fragment.FragmentUtama;
import com.talenta.ujiansekolah.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private SessionManagement sessionManagement;
    private ActivityMainBinding binding;
    private String URL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sessionManagement = new SessionManagement(MainActivity.this);
        if(sessionManagement.getSession() == 0){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            Fragment fragment = new FragmentUtama();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_utama,fragment).commit();
            setContentView(binding.getRoot());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuappbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.logout:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                sessionManagement.clearSession();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void getDataUjian() {
        URL = VariabelGlobal.link_ip+"students/ujian/"+sessionManagement.getSession();
        System.out.println("URL : "+URL);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            if(object.get("status").equals("Success")){
                                Gson gson = new Gson();
                                WSResponseSiswa weatherResponse = gson.fromJson(object.toString(), WSResponseSiswa.class);
                                Siswa siswa = new Siswa(weatherResponse.getData().get(0));
//                                openMain();
                            } else{
                                Toast.makeText(MainActivity.this,"NIK dan Nama Tidak Ditemukan",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this,"masuk catch",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Jaringan Error",Toast.LENGTH_LONG).show();
                    }
                }){
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}