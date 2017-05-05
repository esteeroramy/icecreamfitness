package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final Button settings = (Button) findViewById(R.id.back_button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i;
                i = new Intent(Profile.this, Home.class);
                startActivity(i);
            }
        });
    }
}
