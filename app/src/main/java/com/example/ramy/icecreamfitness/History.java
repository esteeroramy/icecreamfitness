package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        //The bottom navigation bar functionality
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        //Toast.makeText(Home.this, "Going to Home", Toast.LENGTH_SHORT).show();
                        i = new Intent(History.this, Home.class);
                        startActivity(i);
                        break;
                    case R.id.action_history:
                        //Toast.makeText(Home.this, "Going to History", Toast.LENGTH_SHORT).show();
                        i = new Intent(History.this, History.class);
                        startActivity(i);
                        break;
                    case R.id.action_progress:
                        //Toast.makeText(Home.this, "Going to Progress", Toast.LENGTH_SHORT).show();
                        i = new Intent(History.this, Progress.class);
                        startActivity(i);
                        break;
                }
                return true;
            }
        });

        final Button settings = (Button) findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i;
                i = new Intent(History.this, Settings.class);
                startActivity(i);
            }
        });

        final Button profile = (Button) findViewById(R.id.profile_button);
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i;
                i = new Intent(History.this, Profile.class);
                startActivity(i);
            }
        });

    }
}
