package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                //TODO: add more checks for the information
                if (password.getText().toString().equals(cpassword.getText().toString() )) {
                    users myUser = new users(username.getText().toString(), password.getText().toString(), email.getText().toString());
                    dbManager.addUser(myUser);
                    Intent i;
                    i = new Intent(Register.this, login.class);
                    startActivity(i);
                } else {
                    //password and cpassword do not match TODO: put some error
                }
            }
        });
    }
}
