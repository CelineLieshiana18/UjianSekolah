package com.talenta.ujiansekolah;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.talenta.ujiansekolah.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private SessionManagement sessionManagement;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sessionManagement = new SessionManagement(MainActivity.this);
        if(sessionManagement.getSession() == 0){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        setContentView(binding.getRoot());
    }

}