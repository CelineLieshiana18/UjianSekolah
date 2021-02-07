package com.talenta.ujiansekolah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import com.talenta.ujiansekolah.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private String nis;
    private String password;
    private String URL;
    public static final String KEY_NIS="nik";
    public static final String KEY_PASSWORD="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        allInPage();
        setContentView(binding.getRoot());
    }

    private void allInPage(){
        binding.btnLogin.setOnClickListener(v -> {
            if(binding.txtNis.getText().toString().trim().equals("") || binding.txtPassword.getText().toString().trim().equals("")){
                Toast.makeText(LoginActivity.this,R.string.field_kosong_siswa_messsage, Toast.LENGTH_SHORT).show();
            }
            else{
                userLogin();
            }
        });
    }

    private void userLogin() {
        nis = binding.txtNis.getText().toString().trim();
        password = binding.txtPassword.getText().toString().trim();
        URL = VariabelGlobal.link_ip+"students/login";
        System.out.println("URL : "+URL);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            if(object.get("status").equals("Success")){
                                Gson gson = new Gson();
                                WSResponseSiswa weatherResponse = gson.fromJson(object.toString(), WSResponseSiswa.class);
                                Siswa siswa = new Siswa(weatherResponse.getData().get(0));
                                System.out.println("nama user : "+siswa.getNama());
                                SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
                                sessionManagement.saveSession(siswa);
                                openMain();
                            } else{
                                Toast.makeText(LoginActivity.this,"NIK dan Nama Tidak Ditemukan",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(LoginActivity.this,"masuk catch",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,"Jaringan Error",Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_NIS,nis);
                map.put(KEY_PASSWORD,password);
                System.out.println(map);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void openMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}