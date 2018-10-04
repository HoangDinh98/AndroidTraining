package com.flashdev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static String DATABASE_NAME="db.androidtraining";
    private String TABLE_NAME="users";
    private String CREATE_TABLE = "CREATE TABLE users (username text, password text)";
    private String DELETE_TABLE = "DROP TABLE IF EXISTS users";

    public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }

    public  void insertUser(String name, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",name);
        values.put("password", pass);
        db.insert(TABLE_NAME,null,values);
    }

    public ArrayList<String> getUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from users";
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<String> userlists = new ArrayList<>();
        while (cursor.moveToNext()){
            String u = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            userlists.add(u);
        }
        return userlists;
    }
}
