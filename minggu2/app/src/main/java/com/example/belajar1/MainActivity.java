package com.example.belajar1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
    }
    public void menu(View view){
        Intent intent = new Intent(MainActivity.this,linierActivity.class);
        startActivity(intent);
    }
    public void menu2(View view){
        Intent intent = new Intent(MainActivity.this,relativeActivity.class);
        startActivity(intent);
    }
    public void menu3(View view){
        Intent intent = new Intent(MainActivity.this,constraintLayout.class);
        startActivity(intent);
    }public void menu4(View view){
        Intent intent = new Intent(MainActivity.this,framelayout.class);

        startActivity(intent);
    }

    public void menu5(View view){
        Intent intent = new Intent(MainActivity.this,table_layout.class);

        startActivity(intent);
    }
    public void menu6(View view){
        Intent intent = new Intent(MainActivity.this,materialdesign.class);

        startActivity(intent);
    }
    public void menu7(View view){
        Intent intent = new Intent(MainActivity.this,horizontal_layout.class);

        startActivity(intent);
    }
    public void menu8(View view){
        Intent intent = new Intent(MainActivity.this,vertikal_layout.class);

        startActivity(intent);
    }
}