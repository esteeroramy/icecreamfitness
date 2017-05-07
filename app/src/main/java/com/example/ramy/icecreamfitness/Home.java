package com.example.ramy.icecreamfitness;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
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

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dbManager = new DBManager(this, null, null, 1);

        ArrayList<String> theWorkouts = dbManager.getUserWorkouts(dbManager.loggedin());


        RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.mainhere);
        android.support.v7.widget.Toolbar tb = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);

        RelativeLayout myLayout;
        TextView headder;
        RelativeLayout.LayoutParams headderLayout;
        RelativeLayout.LayoutParams bigLayout;
        ShapeDrawable rectShapeDrawable;

        for (int i = 10; i < theWorkouts.size()+10; i++) {
            //make the box
            myLayout = new RelativeLayout(this);
            myLayout.setId(i);
            headder = new TextView(this);
            //make the headder in it
            headder.setText(theWorkouts.get(i-10));
            headder.setTextSize(40);
            headder.setTextColor(Color.WHITE);
            //put it in the correct place
            headderLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            headderLayout.setMargins(0, 50, 0, 50);
            headderLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
            myLayout.addView(headder, headderLayout);

            //set up the next step
            myLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i = new Intent(Home.this, Dashboard.class);
                    startActivity(i);
                }
            });

            bigLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            bigLayout.setMargins(20, 20, 20, 20);

            //add it to the correct position
            if (i == 10) {
                bigLayout.addRule(RelativeLayout.BELOW, tb.getId());
            } else {
                bigLayout.addRule(RelativeLayout.BELOW, i-1);
            }
            myLayout.setPadding(8, 8, 8, 8);

            rectShapeDrawable = new ShapeDrawable();
            Paint paint = rectShapeDrawable.getPaint();

            paint.setColor(getResources().getColor(R.color.colorPrimary));
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            paint.setStrokeWidth(0);
            myLayout.setBackgroundDrawable(rectShapeDrawable);
            mainLayout.addView(myLayout, bigLayout);
        }


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

        final Button add = (Button) findViewById(R.id.adding);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: how can I add workouts?
            }
        });

    }
}
