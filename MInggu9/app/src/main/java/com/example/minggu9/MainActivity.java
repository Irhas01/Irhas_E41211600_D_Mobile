package com.example.minggu9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView name = findViewById(R.id.tv_namaMain);
        name.setText("Welcome! " + Preferences.getLoggedInUser(getBaseContext()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.btnLogout){
            Preferences.setLoggedInUser(getBaseContext(),null);
            Preferences.setLoggedInStatus(getBaseContext(),false);
            startActivity(new Intent(getBaseContext(), Login.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}