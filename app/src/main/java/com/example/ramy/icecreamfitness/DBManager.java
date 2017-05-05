package com.example.ramy.icecreamfitness;

/**
 * Created by Ramy on 2017-05-05.
 */

/*
DATABASE SCHEMA

users (user, pass, email)
workouts (name, days)
workdetails (name, day, excer, sets, reps, inc)
userwork (user, workout)
userdata (workout, excer, set, reps, date)
userworkout (name, day, date)
weight (user, weight, date)
loggedin (user)
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "fitness.db";

    //This is the users table
    public static final String TABLE_USERS = "users";
    public static final String users_id = "_id";
    public static final String users_user = "user";
    public static final String users_pass = "pass";
    public static final String users_email = "email";

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + "(" +
                users_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                users_user + " TEXT, " +
                users_pass + " TEXT, " +
                users_email + " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //FUNCTIONS FOR THE USERS TABLE
    public void addUser(users user) {
        ContentValues values = new ContentValues();
        values.put(users_user, user.get_user());
        values.put(users_pass, user.get_pass());
        values.put(users_email, user.get_email());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public boolean login(String user, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        System.out.println("testing");
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + users_user + "=\"" + user + "\" and " + users_pass + "=\"" + pass + "\";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        return (c.getCount() == 1);
    }
}
