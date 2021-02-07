package com.talenta.ujiansekolah.Fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.talenta.ujiansekolah.Entity.Ujian;
import com.talenta.ujiansekolah.Entity.WSResponseUjian;
import com.talenta.ujiansekolah.R;
import com.talenta.ujiansekolah.SessionManagement;
import com.talenta.ujiansekolah.VariabelGlobal;
import com.talenta.ujiansekolah.databinding.FragmentUtamaBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentUtama extends Fragment {
    private FragmentUtamaBinding binding;
    private SessionManagement sessionManagement;
    private ArrayList<Ujian> ujians = new ArrayList<>();
    private ArrayAdapter<Ujian> ujianArrayAdapter;
    private String URL;

    @Override
    public void onStart() {
        super.onStart();
        loadUjian();
    }

    public ArrayList<Ujian> getUjians() {
        ujians = new ArrayList<>();
        return ujians;
    }

    public ArrayAdapter<Ujian> getUjianArrayAdapter() {
        if(ujianArrayAdapter == null){
            ujianArrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_dropdown_item_1line, ujians);
        }
        return ujianArrayAdapter;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sessionManagement = new SessionManagement(getActivity());
        binding = FragmentUtamaBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    public void allInPage(){
        binding.btnSubmitUjian.setOnClickListener(v -> {

        });
        binding.spinUjian.setAdapter(getUjianArrayAdapter());
    }
    private void loadUjian(){
        URL = VariabelGlobal.link_ip+"students/ujian/"+sessionManagement.getSession();
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Uri uri = Uri.parse(URL).buildUpon().build();
        System.out.println(uri);
        StringRequest request = new StringRequest(Request.Method.GET, uri.toString(), response -> {
            try {
                JSONObject object = new JSONObject(response);
                Gson gson = new Gson();
                WSResponseUjian weatherResponse = gson.fromJson(object.toString(), WSResponseUjian.class);
                ujians.addAll(weatherResponse.getData());
                getUjianArrayAdapter().notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Toast.makeText(getActivity(),"error", Toast.LENGTH_SHORT).show();
            error.printStackTrace();
        });
        queue.add(request);
    }
}