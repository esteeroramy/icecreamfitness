package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        boolean loggedIn = false;

        if (loggedIn) {
            Intent i;
            i = new Intent(login.this, Home.class);
            startActivity(i);
        } else {
            setContentView(R.layout.activity_login);
            dbManager = new DBManager(this, null, null, 1);

            final Button register = (Button) findViewById(R.id.register);
            register.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i;
                    i = new Intent(login.this, Register.class);
                    startActivity(i);
                }
            });

            final Button login = (Button) findViewById(R.id.login);
            login.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    final EditText username = (EditText) findViewById(R.id.username);
                    final EditText password = (EditText) findViewById(R.id.password);

                    String error;

                    if (username.getText().toString().trim().isEmpty()) {
                        error = "Username Is Required";
                    } else if (password.getText().toString().trim().isEmpty()){
                        error = "Password Is Required";
                    } else if (dbManager.login(username.getText().toString(), password.getText().toString())) {
                        error = "";
                        Intent i;
                        i = new Intent(login.this, Home.class);
                        startActivity(i);
                    } else {
                        error = "Invalid Login";
                    }

                    final TextView err = (TextView) findViewById(R.id.errorText);
                    err.setText(error);
                }
            });
        }
    }

}
