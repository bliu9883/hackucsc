package com.example.brian.hackucsc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Brian on 1/21/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "USER.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "USER_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "START";
    public static final String COL_3 = "END";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INT PRIMARY KEY AUTOINCREMENT, START TEXT, END TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String start, String end){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, start);
        contentValues.put(COL_3, end);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }
}
