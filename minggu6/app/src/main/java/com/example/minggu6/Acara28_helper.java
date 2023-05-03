package com.example.minggu6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Acara28_helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biodata.db";
    private static final int DATABASE_VERSION = 1;
    public Acara28_helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table biodata(no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO Biodata (no, nama, tgl, jk, alamat) VALUES ('1', 'JI', '2000-09-08', 'Laki-laki', 'Jl. Jalan');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
