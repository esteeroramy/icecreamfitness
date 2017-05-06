package com.example.ramy.icecreamfitness;

/**
 * Created by Ramy on 2017-05-05.
 */

/*
DATABASE SCHEMA

users (user, pass, email)
loggedin (user)

excer (name)
workouts (name, days)
workdetails (name, day, excer, sets, reps, inc)
userwork (user, workout)
userdata (workout, excer, set, reps, date)
userworkout (name, day, date)
weight (user, weight, date)

 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 10;
    private static final String DATABASE_NAME = "fitness.db";

    //This is the users table
    public static final String TABLE_USERS = "users";
    public static final String users_id = "_id";
    public static final String users_user = "user";
    public static final String users_pass = "pass";
    public static final String users_email = "email";

    //This is the loggedin table
    public static final String TABLE_LOGGEDIN = "loggedin";
    public static final String loggedin_id = "_id";
    public static final String loggedin_user = "user";

    //This is the exer table
    public static final String TABLE_EXER = "exer";
    public static final String exer_id = "_id";
    public static final String exer_name = "name";

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

        query = "CREATE TABLE " + TABLE_LOGGEDIN + "(" +
                loggedin_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                loggedin_user + " TEXT" +
                ");";
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_EXER + "(" +
                exer_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                exer_name + " TEXT" +
                ");";
        db.execSQL(query);

        ContentValues values = new ContentValues();
        values.put(exer_name, "a");
        values.put(exer_name, "b");
        values.put(exer_name, "c");
        db.insert(TABLE_EXER, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGGEDIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXER);
        onCreate(db);
    }

    //FUNCTIONS FOR THE USERS TABLE
    public boolean addUser(users user) {
        if (! userExists(user.get_user())) {
            ContentValues values = new ContentValues();
            values.put(users_user, user.get_user());
            values.put(users_pass, user.get_pass());
            values.put(users_email, user.get_email());
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TABLE_USERS, null, values);
            db.close();
            return true;
        }
        return false;
    }

    private boolean userExists(String user) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + users_user + "=\"" + user + "\";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        return (c.getCount() == 1);
    }

    public boolean login(String user, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        System.out.println("testing");
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + users_user + "=\"" + user + "\" and " + users_pass + "=\"" + pass + "\";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        if (c.getCount() == 1) {
            query = "DELETE FROM " + TABLE_LOGGEDIN + ";";
            db.execSQL(query);

            ContentValues values = new ContentValues();
            values.put(loggedin_user, user);
            db.insert(TABLE_LOGGEDIN, null, values);
            db.close();
            return true;
        } else {
            db.close();
            return false;
        }
    }

    //FUNCTIONS FOR THE LOGGEDIN TABLE
    public String loggedin() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_LOGGEDIN + ";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        if (c.getCount() == 1) {
            return c.getString(c.getColumnIndex(loggedin_user));
        } else {
            return "NONE";
        }
    }

    public void logout() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TABLE_LOGGEDIN + ";";
        db.execSQL(query);
    }

    //FUNCTIONS FOR THE EXER TABLE
    public void addExers() {
        ContentValues values = new ContentValues();
        values.put(exer_name, "a");
        //values.put(exer_name, "b");
        //values.put(exer_name, "c");
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EXER, null, values);
        db.close();
    }

}
