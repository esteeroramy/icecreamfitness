package com.example.ramy.icecreamfitness;

/**
 * Created by Ramy on 2017-05-05.
 */

/*
DATABASE SCHEMA

users (user, pass, email)
loggedin (user)
excer (name, useweights, split)
workouts (name, days)
workdetails (name, day, excer, sets, reps, inc, otherday, dec, failure)
userwork (user, workout)
userworkout (user, name, day, date)
userdata (user, workout, day, excer, set, reps, weight, date)
defaults (user, workout, day, excer, weight)

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

    private static final int DATABASE_VERSION = 60;
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
    public static final String exer_split = "split";

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

    //this is the defaults table
    //defaults (user, workout, day, excer, weight)
    public static final String TABLE_DEFAULTS = "defaults";
    public static final String defaults_id = "_id";
    public static final String defaults_user = "user";
    public static final String defaults_workout = "workout";
    public static final String defaults_day = "day";
    public static final String defaults_excer = "excer";
    public static final String defaults_weight = "weight";

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
                exer_useweights + " INTEGER, " +
                exer_split + " INTEGER" +
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

        query = "CREATE TABLE " + TABLE_DEFAULTS + "(" +
                defaults_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                defaults_user + " TEXT, " +
                defaults_workout + " TEXT, " +
                defaults_day + " INTEGER, " +
                defaults_excer + " TEXT, " +
                defaults_weight + " REAL" +
                ");";
        db.execSQL(query);

        //Add all the exercises
        ContentValues values = new ContentValues();
        values.put(exer_name, "increase");
        values.put(exer_useweights, 1);
        values.put(exer_split, 1);
        db.insert(TABLE_EXER, null, values);

        values.clear();
        values.put(exer_name, "decrease");
        values.put(exer_useweights, 1);
        values.put(exer_split, 1);
        db.insert(TABLE_EXER, null, values);

        values.clear();
        values.put(exer_name, "percentage");
        values.put(exer_useweights, 1);
        values.put(exer_split, 0);
        db.insert(TABLE_EXER, null, values);

        values.clear();
        values.put(exer_name, "body");
        values.put(exer_useweights, 0);
        values.put(exer_split, 0);
        db.insert(TABLE_EXER, null, values);

        //Add all the workouts
        values.clear();
        values.put(workouts_name, "workout1");
        values.put(workouts_days, 2);
        db.insert(TABLE_WORKOUTS, null, values);

        values.clear();
        values.put(workouts_name, "workout2");
        values.put(workouts_days, 3);
        db.insert(TABLE_WORKOUTS, null, values);



        //Add all the workout details
        values.clear();
        values.put(workdetails_name, "workout1");
        values.put(workdetails_day, 1);
        values.put(workdetails_excer, "increase");
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
        values.put(workdetails_excer, "decrease");
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
        values.put(workdetails_excer, "percentage");
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
        values.put(workdetails_excer, "body");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);


        values.clear();
        values.put(workdetails_name, "workout1");
        values.put(workdetails_day, 2);
        values.put(workdetails_excer, "increase");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);

        values.clear();
        values.put(workdetails_name, "workout1");
        values.put(workdetails_day, 2);
        values.put(workdetails_excer, "decrease");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 0.0);
        values.put(workdetails_otherday, 1);
        values.put(workdetails_dec, 2.5);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);

        values.clear();
        values.put(workdetails_name, "workout1");
        values.put(workdetails_day, 2);
        values.put(workdetails_excer, "percentage");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 0.0);
        values.put(workdetails_otherday, 1);
        values.put(workdetails_dec, -0.1);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);







        values.clear();
        values.put(workdetails_name, "workout2");
        values.put(workdetails_day, 1);
        values.put(workdetails_excer, "increase");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);

        values.clear();
        values.put(workdetails_name, "workout2");
        values.put(workdetails_day, 1);
        values.put(workdetails_excer, "decrease");
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
        values.put(workdetails_excer, "percentage");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);

        values.clear();
        values.put(workdetails_name, "workout2");
        values.put(workdetails_day, 3);
        values.put(workdetails_excer, "body");
        values.put(workdetails_sets, 3);
        values.put(workdetails_reps, 5);
        values.put(workdetails_inc, 2.5);
        values.put(workdetails_otherday, 0);
        values.put(workdetails_dec, 0.0);
        values.put(workdetails_failure, 0);
        db.insert(TABLE_WORKDETAILS, null, values);















        //Add all the workouts for users
        values.clear();
        values.put(userwork_user, "a");
        values.put(userwork_workout, "workout1");
        db.insert(TABLE_USERWORK, null, values);
/*
        //Add some user workout days
        values.clear();
        values.put(userworkout_user, "a");
        values.put(userworkout_name, "workout1");
        values.put(userworkout_day, 1);
        values.put(userworkout_date, 2017050722);
        db.insert(TABLE_USERWORKOUT, null, values);

        values.clear();
        values.put(userworkout_user, "a");
        values.put(userworkout_name, "workout1");
        values.put(userworkout_day, 2);
        values.put(userworkout_date, 2017050752);
        db.insert(TABLE_USERWORKOUT, null, values);

        values.clear();
        values.put(userworkout_user, "a");
        values.put(userworkout_name, "workout1");
        values.put(userworkout_day, 1);
        values.put(userworkout_date, 2017050755);
        db.insert(TABLE_USERWORKOUT, null, values);

        values.clear();
        values.put(userworkout_user, "a");
        values.put(userworkout_name, "workout1");
        values.put(userworkout_day, 2);
        values.put(userworkout_date, 2017050788);
        db.insert(TABLE_USERWORKOUT, null, values);
*/
/*

        //Add some workout data for the user a
        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 4);  //failed set
        values.put(userdata_weight, 35.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 35.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 35.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 45.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 45.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 45.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 55.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 55.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 55.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "body");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 65.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "body");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 65.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "body");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 65.0);
        values.put(userdata_date, 2017050722);
        db.insert(TABLE_USERDATA, null, values);
*/

        //day 2


/*
        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 37.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 37.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 37.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 42.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 42.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 42.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 49.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 49.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 49.5);
        values.put(userdata_date, 2017050752);
        db.insert(TABLE_USERDATA, null, values);

        //day 3

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 40.0);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 40.0);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 40.0);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 47.5);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 47.5);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 47.5);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 57.5);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 57.5);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 57.5);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "body");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 65.0);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "body");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 65.0);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 1);
        values.put(userdata_excer, "body");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 65.0);
        values.put(userdata_date, 2017050755);
        db.insert(TABLE_USERDATA, null, values);


        //day 4

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 42.5);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 42.5);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "increase");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 42.5);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);


        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 45.0);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 45.0);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "decrease");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 45.0);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 1);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 51.75);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 2);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 51.75);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);

        values.clear();
        values.put(userdata_user, "a");
        values.put(userdata_workout, "workout1");
        values.put(userdata_day, 2);
        values.put(userdata_excer, "percentage");
        values.put(userdata_set, 3);
        values.put(userdata_reps, 5);
        values.put(userdata_weight, 51.75);
        values.put(userdata_date, 2017050788);
        db.insert(TABLE_USERDATA, null, values);
*/
        //defaults (user, workout, day, excer, weight)
        //add the data for the defaults table
        values.clear();
        values.put(defaults_user, "a");
        values.put(defaults_workout, "workout1");
        values.put(defaults_day, 1);
        values.put(defaults_excer, "increase");
        values.put(defaults_weight, 30.0);
        db.insert(TABLE_DEFAULTS, null, values);

        values.clear();
        values.put(defaults_user, "a");
        values.put(defaults_workout, "workout1");
        values.put(defaults_day, 1);
        values.put(defaults_excer, "decrease");
        values.put(defaults_weight, 40.0);
        db.insert(TABLE_DEFAULTS, null, values);

        values.clear();
        values.put(defaults_user, "a");
        values.put(defaults_workout, "workout1");
        values.put(defaults_day, 1);
        values.put(defaults_excer, "percentage");
        values.put(defaults_weight, 50.0);
        db.insert(TABLE_DEFAULTS, null, values);

        values.clear();
        values.put(defaults_user, "a");
        values.put(defaults_workout, "workout1");
        values.put(defaults_day, 1);
        values.put(defaults_excer, "body");
        values.put(defaults_weight, 60.0);
        db.insert(TABLE_DEFAULTS, null, values);
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERDATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEFAULTS);
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
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + users_user + "=\"" + user
                + "\" and " + users_pass + "=\"" + pass + "\";";

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
        String query = "SELECT " + userwork_workout + " FROM " + TABLE_USERWORK + " WHERE "
                + userwork_user + "= \"" + user + "\";";

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

    public int getLastDay(String workout, String user) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT MAX(" + userworkout_date + ") AS " + userworkout_date + ", " +
                userworkout_day + " FROM " + TABLE_USERWORKOUT + " WHERE "
                + userworkout_user + "= \"" + user + "\" AND " + userworkout_name + "= \""
                + workout + "\" ;";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        int toreturn;
        try {
            toreturn = Integer.parseInt(c.getString(c.getColumnIndex(userworkout_day)));
            return toreturn;
        } catch (Exception e) {
            return -1;
        }
    }

    public int getNextDay(String workout, String user) {
        //workouts (name, days)
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + workouts_days + " FROM " + TABLE_WORKOUTS + " WHERE "
                + workouts_name + "= \"" + workout + "\";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        int lastDay = getLastDay(workout, user);
        if (lastDay == Integer.parseInt(c.getString(c.getColumnIndex(workouts_days)).toString())) {
            return 1;
        } else if (lastDay == -1) {
            return 1;
        } else {
            return lastDay + 1;
        }
    }

    public int getLastDateDay(String workout, String user, int day) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT MAX(" + userworkout_date + ") AS date FROM " + TABLE_USERWORKOUT + " WHERE "
                + userworkout_user + "= \"" + user + "\" AND " + userworkout_name + "= \""
                + workout + "\" AND " + userworkout_day + " = \"" + day + "\";";
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

    public String getDefaults(String user, String workout, String excer) {
        String query;
        SQLiteDatabase db = getWritableDatabase();

        //userdata (user, workout, day, excer, set, reps, weight, date)
        query = "SELECT " + defaults_weight + " FROM " + TABLE_DEFAULTS
                + " WHERE " + defaults_user + " = \"" + user + "\" AND " + defaults_excer
                + " = \"" + excer + "\" AND " + defaults_workout +
                " = \"" + workout + "\"";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        return c.getString(c.getColumnIndex(defaults_weight));
    }

    //TODO: HERE IS WHERE THINGS HAVE TO CHANGE ----------------------------------------------------------------------------------------------------------------------------------------------------

   // public String getLastExer(String user, int date, String workout) {
   //     return "";
   // }

    public String getNextExer(String user, String workout) {
        String query;
        SQLiteDatabase db = getWritableDatabase();
        String bigReturn = "";


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
        defaults (user, workout, day, excer, weight)

        weight (user, weight, date)

         */
        query = "SELECT * FROM " + TABLE_WORKDETAILS + " WHERE " + workdetails_name + " = \"" + workout
            + "\" AND " + workdetails_day + " = \"" + getNextDay(workout, user) + "\";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (! c.isAfterLast()) {
            query = "SELECT " + exer_useweights + " FROM " + TABLE_EXER + " WHERE "
                    + exer_name + " = \"" + c.getString(c.getColumnIndex(userdata_excer)) + "\";";
            Cursor d = db.rawQuery(query, null);
            d.moveToFirst();

            //Formatting the return
            bigReturn += ("  " + c.getString(c.getColumnIndex(userdata_excer))
            );

            for (int i = 0; i < 15 - c.getString(c.getColumnIndex(userdata_excer)).length(); i++) {
                bigReturn += " ";
            }

            int thereps;
            if (c.getString(c.getColumnIndex(workdetails_failure)).equals("1")) {
                bigReturn += "  " + c.getString(c.getColumnIndex(workdetails_sets)) + "xFAIL";
                for (int i = 0; i < 6 - (c.getString(c.getColumnIndex(workdetails_sets)) + "xFAIL").length(); i++) {
                    bigReturn += " ";
                }
                thereps = -1;
            } else {
                bigReturn += "  " + c.getString(c.getColumnIndex(workdetails_sets)) + "x" +
                        c.getString(c.getColumnIndex(workdetails_reps));
                for (int i = 0; i < 6 - (c.getString(c.getColumnIndex(workdetails_sets)) + "x" +
                        c.getString(c.getColumnIndex(workdetails_reps))).length(); i++) {
                    bigReturn += " ";
                }
                thereps = Integer.parseInt(c.getString(c.getColumnIndex(workdetails_reps)));
            }

            if (d.getString(d.getColumnIndex(exer_useweights)).equals("1")) {

                query = "SELECT MAX(" + userdata_date + ") AS " + userdata_date + ", * FROM " + TABLE_USERDATA
                        + " WHERE " + userdata_user + " = \"" + user + "\" AND "
                        + userdata_excer + " = \"" + c.getString(c.getColumnIndex(userdata_excer)) + "\" AND "
                        + userdata_workout + " = \"" + workout + "\";";

                Cursor e = db.rawQuery(query, null);
                e.moveToFirst();


                if (c.getString(c.getColumnIndex(workdetails_otherday)).equals("0")) {
                    if (e.getString(e.getColumnIndex(userdata_weight)) == null) {
                        bigReturn += "  " + getDefaults(user, workout, c.getString(c.getColumnIndex(workdetails_excer))) + "\n";
                    } else {
                        query = "SELECT * FROM " + TABLE_WORKDETAILS + " WHERE " + workdetails_name + " = \"" + workout
                                + "\" AND " + workdetails_day + " = \"" + e.getString(e.getColumnIndex(userdata_day))
                                + "\" AND " + workdetails_excer + " = \"" + e.getString(e.getColumnIndex(userdata_excer))+ "\";";
                        Cursor g = db.rawQuery(query, null);
                        g.moveToFirst();
                        if (g.getString(g.getColumnIndex(workdetails_otherday)).equals("1")) {
                            query = "SELECT MAX(" + userdata_date + ") AS " + userdata_date + ", * FROM " + TABLE_USERDATA
                                    + " WHERE " + userdata_user + " = \"" + user + "\" AND "
                                    + userdata_excer + " = \"" + c.getString(c.getColumnIndex(userdata_excer)) + "\" AND "
                                    + userdata_workout + " = \"" + workout + "\" AND "
                                    + userdata_day + " = \"" + getNextDay(workout, user) + "\";";

                            Cursor h = db.rawQuery(query, null);
                            h.moveToFirst();

                            if (completed(user, workout, c.getString(c.getColumnIndex(workdetails_excer)), thereps)) {
                                float inc = Float.parseFloat(c.getString(c.getColumnIndex(workdetails_inc)));
                                bigReturn += "  " + (Float.parseFloat(h.getString(h.getColumnIndex(userdata_weight))) + inc) + "\n";
                            } else {
                                bigReturn += "  " + h.getString(h.getColumnIndex(userdata_weight)) + "\n";
                            }
                        } else {

                            if (completed(user, workout, c.getString(c.getColumnIndex(workdetails_excer)), thereps)) {
                                float inc = Float.parseFloat(c.getString(c.getColumnIndex(workdetails_inc)));
                                bigReturn += "  " + (Float.parseFloat(e.getString(e.getColumnIndex(userdata_weight))) + inc) + "\n";
                            } else {
                                bigReturn += "  " + e.getString(e.getColumnIndex(userdata_weight)) + "\n";
                            }
                        }
                    }
                } else {
                    query = "SELECT MAX(" + userdata_date + ") AS " + userdata_date + ", * FROM " + TABLE_USERDATA
                            + " WHERE " + userdata_user + " = \"" + user + "\" AND "
                            + userdata_excer + " = \"" + c.getString(c.getColumnIndex(workdetails_excer)) + "\" AND "
                            + userdata_workout + " = \"" + workout + "\" AND "
                            + userdata_day + " = \"" + c.getString(c.getColumnIndex(workdetails_otherday)) + "\";";
                    Cursor f = db.rawQuery(query, null);
                    f.moveToFirst();
                    //System.out.println(c.getString(c.getColumnIndex(workdetails_dec)));


                    float ch = Float.parseFloat(c.getString(c.getColumnIndex(workdetails_dec)));

                    if (ch > -1.0 && ch < 1.0) {
                        //percentage decrease
                        bigReturn += "  " + (Float.parseFloat(f.getString(f.getColumnIndex(userdata_weight)))
                                + (ch*Float.parseFloat(f.getString(f.getColumnIndex(userdata_weight))))) + "\n";
                    } else {
                        //other decrease
                        bigReturn += "  " + (Float.parseFloat(f.getString(f.getColumnIndex(userdata_weight))) - ch) + "\n";
                        //System.out.println(d.getString(d.getColumnIndex(userdata_weight)));
                    }
                }
            } else {
                bigReturn += "  BW\n";
            }
            c.moveToNext();
        }
        return bigReturn;
    }

    public boolean completed(String user, String workout, String excer, int reps) {

        String query;
        SQLiteDatabase db = getWritableDatabase();

        query = "SELECT MAX(" + userdata_date + ") AS " + userdata_date + ", * FROM " + TABLE_USERDATA
                + " WHERE " + userdata_user + " = \"" + user + "\" AND "
                + userdata_excer + " = \"" + excer + "\" AND "
                + userdata_workout + " = \"" + workout + "\";";


        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (Integer.parseInt(c.getString(c.getColumnIndex(userdata_reps))) != reps) {
                return false;
            }
            c.moveToNext();
        }
        return true;
    }


    //FUNCTIONS FOR THE USERDATA TABLE
    public String getLastExer(String user, int date, String workout) {
        //figure out the exercises that use weights
        //for the ones that use weights get the exercises, sets, reps, and weight.
        //for the ones that do not, get the exercises, sets, reps
        //display them in a good way and return a string (one thing on each line
        String query;
        SQLiteDatabase db = getWritableDatabase();

        //userdata (user, workout, day, excer, set, reps, weight, date)
        query = "SELECT DISTINCT " + userdata_excer + ", " + userdata_weight + ", " + userdata_day + " FROM " + TABLE_USERDATA
                + " WHERE " + userdata_workout + " = \"" + workout + "\" AND " + userdata_date +
                " = \"" + date + "\" AND " + userdata_user + " = \"" + user + "\"";


        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        String bigReturn = "";

        while (! c.isAfterLast()) {
            //workdetails (name, day, excer, sets, reps, inc, otherday, dec, failure)
            query = "SELECT " + workdetails_sets + ", " + workdetails_reps + ", " + workdetails_failure +
                    " FROM " + TABLE_WORKDETAILS + " WHERE " + workdetails_name + " = \"" + workout + "\" AND " +
                    workdetails_day + " = \"" + c.getString(c.getColumnIndex(userdata_day)) + "\" AND " +
                    workdetails_excer + " = \"" + c.getString(c.getColumnIndex(userdata_excer)) + "\";";

            Cursor d = db.rawQuery(query, null);
            d.moveToFirst();

            query = "SELECT " + exer_useweights + " FROM " + TABLE_EXER + " WHERE "
                    + exer_name + " = \"" + c.getString(c.getColumnIndex(userdata_excer)) + "\";";
            Cursor e = db.rawQuery(query, null);
            e.moveToFirst();

            //Formatting the return
            bigReturn += ("  " + c.getString(c.getColumnIndex(userdata_excer))
                    );

            for (int i = 0; i < 15 - c.getString(c.getColumnIndex(userdata_excer)).length(); i++) {
                bigReturn += " ";
            }
            if (d.getString(d.getColumnIndex(workdetails_failure)).equals("1")) {
                bigReturn += "  " + d.getString(d.getColumnIndex(workdetails_sets)) + "xFAIL";
                for (int i = 0; i < 6 - (d.getString(d.getColumnIndex(workdetails_sets)) + "xFAIL").length(); i++) {
                    bigReturn += " ";
                }
            } else {
                bigReturn += "  " + d.getString(d.getColumnIndex(workdetails_sets)) + "x" +
                        d.getString(d.getColumnIndex(workdetails_reps));
                for (int i = 0; i < 6 - (d.getString(d.getColumnIndex(workdetails_sets)) + "x" +
                        d.getString(d.getColumnIndex(workdetails_reps))).length(); i++) {
                    bigReturn += " ";
                }
            }

            if (e.getString(e.getColumnIndex(exer_useweights)).equals("1")) {
                bigReturn += "  " + c.getString(c.getColumnIndex(userdata_weight));
            } else {
                bigReturn += "  " + "BW";
            }

            bigReturn += "\n";
            c.moveToNext();
        }
        return bigReturn;
    }

    public ArrayList<String> AvailableExers(String user){

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + workouts_name + " FROM " + TABLE_WORKOUTS + " WHERE "
                + workouts_name + " not in ( SELECT " + userworkout_name + " FROM "
                + TABLE_USERWORKOUT + " WHERE " + userworkout_user + " = \"" + user + "\");";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        ArrayList<String> toReturn = new ArrayList<>();
        while (!c.isAfterLast()) {
            toReturn.add(c.getString(c.getColumnIndex(exer_name)));
            c.moveToNext();
        }
        return toReturn;
    }

    //workouts (name, days)
    //workdetails (name, day, excer, sets, reps, inc, otherday, dec, failure)

    public String getWorkoutDetails(String workout) {
        String toReturn = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + workouts_days + " FROM " + TABLE_WORKOUTS + " WHERE "
                + workouts_name + "= \"" + workout + "\";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        toReturn += workout + ":\n\n";
        if (c.getString(c.getColumnIndex(workouts_days)).equals("1")) {
            toReturn += "Total: " + c.getString(c.getColumnIndex(workouts_days)) + " Day\n";
        } else {
            toReturn += "Total: " + c.getString(c.getColumnIndex(workouts_days)) + " Days\n";
        }
        Cursor d;
        for (int i = 1; i < Integer.parseInt(c.getString(c.getColumnIndex(workouts_days)))+1; i++) {
            query = "SELECT * FROM " + TABLE_WORKDETAILS + " WHERE " + workdetails_name + " = \"" + workout + "\" AND "
                    + workdetails_day + " = \"" + Integer.toString(i) + "\";";
            d = db.rawQuery(query, null);
            d.moveToFirst();
            toReturn += "Day " + Integer.toString(i) + ":\n";

            while (!d.isAfterLast()) {
                toReturn += "  " + d.getString(d.getColumnIndex(workdetails_excer));
                for (int j = 0; j < 15 - d.getString(d.getColumnIndex(workdetails_excer)).length(); j++) {
                    toReturn += " ";
                }

                if (d.getString(d.getColumnIndex(workdetails_failure)).equals("1")) {
                    toReturn += "  " + d.getString(d.getColumnIndex(workdetails_sets)) + "xFAIL";
                    for (int j = 0; j < 6 - (d.getString(d.getColumnIndex(workdetails_sets)) + "xFAIL").length(); j++) {
                        toReturn += " ";
                    }
                } else {
                    toReturn += "  " + d.getString(d.getColumnIndex(workdetails_sets)) + "x" +
                            d.getString(d.getColumnIndex(workdetails_reps));
                    for (int j = 0; j < 6 - (d.getString(d.getColumnIndex(workdetails_sets)) + "x" +
                            d.getString(d.getColumnIndex(workdetails_reps))).length(); j++) {
                        toReturn += " ";
                    }
                }

                toReturn += "\n";
                d.moveToNext();
            }
        }
        return toReturn;
    }


    public ArrayList<String> getExercises(String workout) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor d;
        String query = "SELECT DISTINCT " + workdetails_excer + " FROM " + TABLE_WORKDETAILS + " WHERE " + workdetails_name + " = \"" + workout + "\" AND "
                + workdetails_excer + " not in (SELECT " + exer_name + " FROM " + TABLE_EXER + " WHERE " + exer_useweights + " = \"0\");";
        d = db.rawQuery(query, null);
        d.moveToFirst();

        ArrayList<String> toReturn = new ArrayList<>();

        while (!d.isAfterLast()) {
            toReturn.add(d.getString(d.getColumnIndex(workdetails_excer)));
            d.moveToNext();
        }
        return toReturn;
    }

    public void saveWorkout(String user, String workoutName, int day, int date){

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

        values.put(userworkout_user, user);
        values.put(userworkout_name, workoutName);
        values.put(userworkout_day, day);
        values.put(userworkout_date, date);
        db.insert(TABLE_USERWORKOUT, null, values);

    }

    public void saveExer (String user, String workout, int day, String exer, int set, int reps, float weight, int date) {


        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(userdata_user, user);
        values.put(userdata_workout, workout);
        values.put(userdata_day, day);
        values.put(userdata_excer, exer);
        values.put(userdata_set, set);
        values.put(userdata_reps, reps);
        values.put(userdata_weight, weight);
        values.put(userdata_date, date);
        db.insert(TABLE_USERDATA, null, values);

    }
}