package com.example.minggu6;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

public class Acara26_2 extends Acara26{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara26_2);
        textView = (TextView) findViewById(R.id.getText);
    }

    public void back(View view) {
        Intent intent = new Intent(Acara26_2.this, Acara26.class);
        startActivity(intent);
    }

    public void getPublic(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myData.txt");
        String data = getData(myFile);
        if (data != null) {
            textView.setText(data);
        } else {
            textView.setText("No data found");
        }
    }

    public void getPrivate(View view) {
        File folder = getExternalFilesDir("Yoga");
        File myFile = new File(folder, "myData2.txt");
        String data = getData(myFile);
        if (data != null) {
            textView.setText(data);
        } else {
            textView.setText("No data found");
        }
    }

    private String getData(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char) read);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
