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

public class Progress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        //The bottom navigation bar functionality
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        //Toast.makeText(Home.this, "Going to Home", Toast.LENGTH_SHORT).show();
                        i = new Intent(Progress.this, Home.class);
                        startActivity(i);
                        break;
                    case R.id.action_history:
                        //Toast.makeText(Home.this, "Going to History", Toast.LENGTH_SHORT).show();
                        i = new Intent(Progress.this, History.class);
                        startActivity(i);
                        break;
                    case R.id.action_progress:
                        //Toast.makeText(Home.this, "Going to Progress", Toast.LENGTH_SHORT).show();
                        i = new Intent(Progress.this, Progress.class);
                        startActivity(i);
                        break;
                }
                return true;
            }
        });

    }
}
