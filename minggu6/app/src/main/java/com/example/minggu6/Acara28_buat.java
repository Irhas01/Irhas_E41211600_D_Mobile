package com.example.minggu6;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class Acara28_buat extends Acara28{

    protected Cursor cursor;
    Acara28_helper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text5;
    RadioButton radio1, radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara28_buat);

        dbHelper = new Acara28_helper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        radio1 = (RadioButton) findViewById(R.id.radioButton1);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        text3.setOnClickListener((arg0) -> {
            // buat datepicker dialog dan tampilkan pada text3
            Calendar newCalendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(Acara28_buat.this, (view, year, monthOfYear, dayOfMonth) -> {
                // set date pada text3 format yyyy-mm-dd
                text3.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });


        ton1.setOnClickListener((arg0) -> {
            // TODO Auto-generated method stub
            String no = text1.getText().toString();
            String nama = text2.getText().toString();
            String tgl = text3.getText().toString();
            String jk = null;
            if (radio1.isChecked()) {
                jk = radio1.getText().toString();
            } else {
                jk = radio2.getText().toString();
            }
            String alamat = text5.getText().toString();
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("insert into biodata(no, nama, tgl, jk, alamat) " +
                    "values('" + no + "','" + nama + "','" + tgl + "','" + jk + "','" + alamat + "')");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            Acara28.ma.RefreshList();
            finish();
        });
        ton2.setOnClickListener((arg0) -> {
            // TODO Auto-generated method stub
            finish();
        });
    }
}
