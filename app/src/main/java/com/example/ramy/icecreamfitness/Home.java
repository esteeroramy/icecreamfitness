package com.example.ramy.icecreamfitness;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;
import android.content.Intent;
import android.view.View;

import android.widget.*;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Set up the information for the previous workout
        RelativeLayout myLayout = (RelativeLayout)findViewById(R.id.prev);
        TextView headder = new TextView(this);
        headder.setText("Previous"); //the title
        headder.setTextSize(26);
        headder.setTextColor(Color.BLACK);
        headder.setId(5);
        RelativeLayout.LayoutParams headderLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        TextView body = new TextView(this); //the dta to display TODO: could make it all vertical
        body.setText("\n     asdfasdfasdf         asdfasdasdf" +
                "\n     asdfasdfadsf         asdfasdfasdfa" +
                "\n     asdasdasdasd       asdfasdfasdf");
        body.setTextSize(14);
        body.setTextColor(Color.BLACK);
        body.setId(6);
        RelativeLayout.LayoutParams bodyLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        bodyLayout.addRule(RelativeLayout.BELOW, headder.getId());
        myLayout.addView(headder, headderLayout);
        myLayout.addView(body, bodyLayout);

        //The information for the next workout
        RelativeLayout myLayout1 = (RelativeLayout)findViewById(R.id.next);
        TextView headder1 = new TextView(this);
        headder1.setText("Next"); //the title
        headder1.setTextSize(26);
        headder1.setTextColor(Color.BLACK);
        headder1.setId(7);
        RelativeLayout.LayoutParams headder1Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        TextView body1 = new TextView(this); //the information to display
        body1.setText("\n     asdfasdfasdf         asdfasdasdf" +
                "\n     asdfasdfadsf         asdfasdfasdfa" +
                "\n     asdasdasdasd       asdfasdfasdf");
        body1.setTextSize(14);
        body1.setTextColor(Color.BLACK);
        body1.setId(8);
        RelativeLayout.LayoutParams body1Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        body1Layout.addRule(RelativeLayout.BELOW, headder1.getId());
        myLayout1.addView(headder1, headder1Layout);
        myLayout1.addView(body1, body1Layout);

        //The bottom navigation bar functionality
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        //Toast.makeText(Home.this, "Going to Home", Toast.LENGTH_SHORT).show();
                        i = new Intent(Home.this, Home.class);
                        startActivity(i);
                        break;
                    case R.id.action_history:
                        //Toast.makeText(Home.this, "Going to History", Toast.LENGTH_SHORT).show();
                        i = new Intent(Home.this, History.class);
                        startActivity(i);
                        break;
                    case R.id.action_progress:
                        //Toast.makeText(Home.this, "Going to Progress", Toast.LENGTH_SHORT).show();
                        i = new Intent(Home.this, Progress.class);
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
                i = new Intent(Home.this, Settings.class);
                startActivity(i);
            }
        });

        final Button profile = (Button) findViewById(R.id.profile_button);
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i;
                i = new Intent(Home.this, Profile.class);
                startActivity(i);
            }
        });

    }
}
