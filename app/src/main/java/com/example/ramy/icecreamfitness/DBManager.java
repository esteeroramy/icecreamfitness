package com.example.ramy.icecreamfitness;

/**
 * Created by Ramy on 2017-05-05.
 */

/*
DATABASE SCHEMA

users (user, pass, email)
loggedin (user)
excer (name, useweights)
workouts (name, days)
workdetails (name, day, excer, sets, reps, inc, otherday, dec, failure)
userwork (user, workout)
userworkout (user, name, day, date)
userdata (user, workout, day, excer, set, reps, weight, date)


weight (user, weight, date)

 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.provider.*;
import android.provider.Settings;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 19;
    private static final String DATABASE_NAME = "fitness.db";

    //This is the users table
    //users (user, pass, email)
    public static final String TABLE_USERS = "users";
    public static final String users_id = "_id";
    public static final String users_user = "user";
    public static final String users_pass = "pass";
    public static final String users_email = "email";

    //This is the loggedin table
    //loggedin (user)
    public static final String TABLE_LOGGEDIN = "loggedin";
    public static final String loggedin_id = "_id";
    public static final String loggedin_user = "user";

    //This is the exer table
    //excer (name)
    public static final String TABLE_EXER = "exer";
    public static final String exer_id = "_id";
    public static final String exer_name = "name";
    public static final String exer_useweights = "useweights";

    //This is the workouts table
    //workouts (name, days)
    public static final String TABLE_WORKOUTS = "workouts";
    public static final String workouts_id = "_id";
    public static final String workouts_name = "name";
    public static final String workouts_days = "days";

    //This is the workdetaiils table
    //workdetails (name, day, excer, sets, reps, inc, otherday, dec, failure)
    public static final String TABLE_WORKDETAILS = "workdetails";
    public static final String workdetails_id = "_id";
    public static final String workdetails_name = "name";
    public static final String workdetails_day = "day";
    public static final String workdetails_excer = "excer";
    public static final String workdetails_sets = "sets";
    public static final String workdetails_reps = "reps";
    public static final String workdetails_inc = "inc";
    public static final String workdetails_otherday = "otherday";
    public static final String workdetails_dec = "dec";
    public static final String workdetails_failure = "failure";

    //This is the workouts table
    //userwork (user, workout)
    public static final String TABLE_USERWORK = "userwork";
    public static final String userwork_id = "_id";
    public static final String userwork_user = "user";
    public static final String userwork_workout = "workout";

    //This is the userworkout table
    //userworkout (user, name, day, date)
    public static final String TABLE_USERWORKOUT = "userworkout";
    public static final String userworkout_id = "_id";
    public static final String userworkout_user = "user";
    public static final String userworkout_name = "name";
    public static final String userworkout_day = "day";
    public static final String userworkout_date = "date";

    //this is the userdata table
    //userdata (user, workout, day, excer, set, reps, date)
    public static final String TABLE_USERDATA = "userdata";
    public static final String userdata_id = "_id";
    public static final String userdata_user = "user";
    public static final String userdata_workout = "workout";
    public static final String userdata_day = "day";
    public static final String userdata_excer = "excer";
    public static final String userdata_set = "sets";
    public static final String userdata_reps = "reps";
    public static final String userdata_weight = "weight";
    public static final String userdata_date = "date";


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
                exer_name + " TEXT, " +
                exer_useweights + " INTEGER" +
                ");";
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_WORKOUTS + "(" +
                workouts_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                workouts_name + " TEXT, " +
                workouts_days + " INTEGER" +
                ");";
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_WORKDETAILS + "(" +
                workdetails_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                workdetails_name + " TEXT, " +
                workdetails_day + " INTEGER, " +
                workdetails_excer + " TEXT, " +
                workdetails_sets + " INTEGER, " +
                workdetails_reps + " INTEGER, " +
                workdetails_inc + " REAL, " +
                workdetails_otherday + " INTEGER, " +
                workdetails_dec + " REAL, " +
                workdetails_failure + " INTEGER" +
                ");";
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_USERWORK + "(" +
                userwork_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                userwork_user + " TEXT, " +
                userwork_workout + " TEXT" +
                ");";
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_USERWORKOUT + "(" +
                userworkout_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                userworkout_user + " TEXT, " +
                userworkout_name + " TEXT, " +
                userworkout_day + " INTEGER, " +
                userworkout_date + " INTEGER" +
                ");";
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_USERDATA + "(" +
                userdata_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                userdata_user + " TEXT, " +
                userdata_workout + " TEXT, " +
                userdata_day + " INTEGER, " +
                userdata_excer + " TEXT, " +
                userdata_set + " INTEGER, " +
                userdata_reps + " INTEGER, " +
                userdata_weight + " REAL, " +
                userdata_date + " INTEGERS" +
                ");";
        db.execSQL(query);

        //Add all the exercises
        ContentValues values = new ContentValues();
        values.put(exer_name, "ex1");
        values.put(exer_useweights, 1);
        db.insert(TABLE_EXER, null, values);

        values.clear();
        values.put(exer_name, "ex2");
        values.put(exer_useweights, 0);
        db.insert(TABLE_EXER, null, values);

        values.clear();
        values.put(exer_name, "ex3");
        values.put(exer_useweights, 1);
        db.insert(TABLE_EXER, null, values);

        //Add all the workouts
        values.clear();
        values.put(workouts_name, "workout1");
        values.put(workouts_days, 1);
        db.insert(TABLE_WORKOUTS, null, values);

        values.clear();
        values.put(workouts_name, "workout2");
        values.put(workouts_days, 2);
        db.insert(TABLE_WORKOUTS, null, values);

        //Add all the workout details
        values.clear();
        values.put(workdetails_name, "workout1");
        values.put(workdetails_day, 1);
        values.put(workdetails_excer, "ex1");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);

        values.clear();
        values.put(workdetails_name, "workout1");
        values.put(workdetails_day, 1);
        values.put(workdetails_excer, "ex2");
        values.put(workdetails_sets, 0);
        values.put(workdetails_reps, 0);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 1);
        db.insert(TABLE_WORKDETAILS, null, values);

        values.clear();
        values.put(workdetails_name, "workout2");
        values.put(workdetails_day, 1);
        values.put(workdetails_excer, "ex1");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);

        values.clear();
        values.put(workdetails_name, "workout2");
        values.put(workdetails_day, 2);
        values.put(workdetails_excer, "ex2");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 0.0);
        values.put(workdetails_otherday, 1);
        values.put(workdetails_dec, 0.1);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);


        //Add all the workouts for users
        values.clear();
        values.put(userwork_user, "a");
        values.put(userwork_workout, "workout1");
        db.insert(TABLE_USERWORK, null, values);

        values.clear();
        values.put(userwork_user, "a");
        values.put(userwork_workout, "workout2");
        db.insert(TABLE_USERWORK, null, values);

        //Add some user workout days
        values.clear();
        values.put(userworkout_user, "a");
        values.put(userworkout_name, "workout1");
        values.put(userworkout_day, 1);
        values.put(userworkout_date, 2017050522);
        db.insert(TABLE_USERWORKOUT, null, values);

        values.clear();
        values.put(userworkout_user, "a");
        values.put(userworkout_name, "workout1");
        values.put(userworkout_day, 1);
        values.put(userworkout_date, 2017050722);
        db.insert(TABLE_USERWORKOUT, null, values);

        //Add some workout data for the user a
        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "ex1");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 52);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "ex1");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 52);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "ex1");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 52);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGGEDIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKDETAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERWORK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERWORKOUT);
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


    //FUNCTIONS FOR THE USERWORK TABLE
    public ArrayList<String> getUserWorkouts(String user) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + userwork_workout + " FROM " + TABLE_USERWORK + " WHERE " + userwork_user + "= \"" + user + "\";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        ArrayList<String> theWorkouts = new ArrayList<>();

        while (! c.isAfterLast()) {
            theWorkouts.add(c.getString(c.getColumnIndex(userwork_workout)));
            c.moveToNext();
        }

        return theWorkouts;
    }

    //FUNCTIONS FOR THE USERWORKOUT TABLE
    //TODO: get the date of the previous workout
    //TODO: check if there was even a previous exercise
    public int getLastDate(String workout, String user) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT MAX(" + userworkout_date + ") AS date FROM " + TABLE_USERWORKOUT + " WHERE "
                + userworkout_user + "= \"" + user + "\" AND " + userworkout_name + "= \""
                + workout + "\" ;";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        int toreturn;
        try {
            toreturn = Integer.parseInt(c.getString(c.getColumnIndex(userworkout_date)));
            return toreturn;
        } catch (Exception e) {
            return -1;
        }
    }

    //FUNCTIONS FOR THE USERDATA TABLE
    public String getLastExer(String user, int date, String workout) {
        //figure out the exercises that use weights
        //for the ones that use weights get the exercises, sets, reps, and weight.
        //for the ones that do not, get the exercises, sets, reps
        //display them in a good way and return a string (one thing on each line
        return "";
    }

    public String getNextExer(String user, String workout) {
        //figure out the exercises that use weights
        //for the ones that use weights get the data and increment accordingly
        //for the ones that go till failure, dont increment anything
        //display them in a good way and return a string (one thing on each line
        return "";
    }

}
