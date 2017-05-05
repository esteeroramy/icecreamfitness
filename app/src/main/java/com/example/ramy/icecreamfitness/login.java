package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                    //TODO: some extra checks on the input information
                    final EditText username = (EditText) findViewById(R.id.username);
                    final EditText password = (EditText) findViewById(R.id.password);
                    if (dbManager.login(username.getText().toString(), password.getText().toString())) {
                        Intent i;
                        i = new Intent(login.this, Home.class);
                        startActivity(i);
                    } else {
                        //login failed TODO: tell the user something
                    }
                }
            });


        }
    }

}
