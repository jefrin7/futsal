package com.example.bookingfutsal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DBDataSource extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "booking.db";
    private static final int DATABASE_VERTSION = 1;
    public DBDataSource(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERTSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table booking(no integer primary key, nama text null, tgl text null, jam text null, lapangan text null, biaya text null, keterangan text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
    }

}