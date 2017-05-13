package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView title = (TextView) findViewById(R.id.textView);
        title.setText(Home.workoutName);

        dbManager = new DBManager(this, null, null, 1);
        int lastDate = dbManager.getLastDate(Home.workoutName, Home.user);

        if (lastDate != -1) {
            //Set up the information for the previous workout
            RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.prev);
            TextView headder = new TextView(this);
            headder.setText("Previous"); //the title
            headder.setTextSize(26);
            headder.setTextColor(Color.BLACK);
            headder.setId(5);
            RelativeLayout.LayoutParams headderLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            //getting the information


            TextView body = new TextView(this); //the dta to display
            body.setTypeface(Typeface.MONOSPACE);
            body.setText(dbManager.getLastExer(Home.user, lastDate, Home.workoutName));
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
        } else {
            RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.prev);
            myLayout.setVisibility(View.GONE);
        }

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
        body1.setText(dbManager.getNextExer(Home.user, Home.workoutName));
        body1.setTextSize(14);
        body1.setTypeface(Typeface.MONOSPACE);
        body1.setTextColor(Color.BLACK);
        body1.setId(8);
        RelativeLayout.LayoutParams body1Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        body1Layout.addRule(RelativeLayout.BELOW, headder1.getId());
        myLayout1.addView(headder1, headder1Layout);
        myLayout1.addView(body1, body1Layout);
        myLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //workoutName = ((TextView) v.findViewById(9)).getText().toString();
                Intent i;
                i = new Intent(Dashboard.this, Workout.class);
                startActivity(i);
            }
        });
    }
}
