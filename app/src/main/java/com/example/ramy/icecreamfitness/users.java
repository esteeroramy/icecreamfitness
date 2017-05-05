package com.example.ramy.icecreamfitness;

/**
 * Created by Ramy on 2017-05-05.
 */

public class users {

    private int _id;
    private String _user;
    private String _pass;
    private String _email;

    public users(String user, String pass, String email) {
        this._user = user;
        this._pass = pass;
        this._email = email;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    public void set_pass(String _pass) {
        this._pass = _pass;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public int get_id() {

        return _id;
    }

    public String get_user() {
        return _user;
    }

    public String get_pass() {
        return _pass;
    }

    public String get_email() {
        return _email;
    }
}
