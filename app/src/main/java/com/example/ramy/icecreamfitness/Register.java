package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DBManager(this, null, null, 1);

        setContentView(R.layout.activity_register);

        final Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i;
                i = new Intent(Register.this, login.class);
                startActivity(i);
            }
        });

        final Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText username = (EditText) findViewById(R.id.username);
                final EditText password = (EditText) findViewById(R.id.password);
                final EditText cpassword = (EditText) findViewById(R.id.cpassword);
                final EditText email = (EditText) findViewById(R.id.email);

                String error;

                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(email.getText().toString());
                boolean matchFound = m.matches();

                if (username.getText().toString().trim().isEmpty()) {
                    error = "Username Is Required";
                } else if (password.getText().toString().trim().isEmpty()){
                    error = "Password Is Required";
                } else if (cpassword.getText().toString().trim().isEmpty()){
                    error = "Confirm Password Is Required";
                } else if (email.getText().toString().trim().isEmpty()) {
                    error = "Email Is Required";
                } else if (!matchFound) {
                    error = "Email Format is not Valid";
                } else if (password.getText().toString().equals(cpassword.getText().toString() )) {
                    error = "";
                    users myUser = new users(username.getText().toString(), password.getText().toString(), email.getText().toString());
                    boolean out = dbManager.addUser(myUser);
                    if (out) {
                        Intent i;
                        i = new Intent(Register.this, login.class);
                        startActivity(i);
                    } else {
                        error = "Username In Use";
                    }
                } else {
                    error = "Passwords do not Match";
                }

                final TextView err = (TextView) findViewById(R.id.errorText);
                err.setText(error);
            }
        });
    }
}
