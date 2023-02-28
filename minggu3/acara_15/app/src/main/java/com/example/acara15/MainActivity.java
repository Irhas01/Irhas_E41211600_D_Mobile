package com.example.acara15;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acara15.Mahasiswa;
import com.example.acara15.MahasiswaAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MahasiswaAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Huda", "E41211492", "08123456769"));
        mahasiswaArrayList.add(new Mahasiswa("Nurul Hudi", "E41211493", "08123457789"));
        mahasiswaArrayList.add(new Mahasiswa("Nurul ", "E41211494", "08123456489"));
        mahasiswaArrayList.add(new Mahasiswa("Salwi", "E41211495", "08123456289"));
    }
}