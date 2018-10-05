package com.flashdev.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.flashdev.Config;
import com.flashdev.objects.User;

import java.util.ArrayList;

public class UserModel extends SQLiteOpenHelper {
    private String tableName = "users";
    private String tableCreation = "CREATE TABLE IF NOT EXISTS users (name text, email text)";
    private String tableDeletion = "DROP TABLE IF EXISTS users";

    public UserModel(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Config.DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(tableDeletion);
        onCreate(db);
    }

    public void insertUser(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        db.insert(tableName, null, values);
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM users";
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<User> userlists = new ArrayList<>();
        while (cursor.moveToNext()){
            String userName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            userlists.add(new User(userName, userEmail));
        }
        return userlists;
    }
}
