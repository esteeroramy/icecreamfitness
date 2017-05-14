package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SelectExercises extends AppCompatActivity {

    DBManager dbManager;
    public static String toadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_exercises);

        dbManager = new DBManager(this, null, null, 1);
        ArrayList<String> workouts = dbManager.AvailableExers(Home.user);
        workouts.add(0,"Custom Workout");
        RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.mainhere);

        Button button;
        RelativeLayout.LayoutParams buttonLayout;

        for (int j = 1; j < workouts.size()+1; j++) {

            button = new Button(this);
            button.setText(workouts.get(j-1));
            button.setTextSize(17);
            button.setTextColor(Color.WHITE);
            button.setId(j);
            buttonLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.FILL_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            //button.setBackgroundColor(Color.DKGRAY);
            buttonLayout.addRule(RelativeLayout.BELOW, j - 1);
            if (j == 1) {
                buttonLayout.setMargins(0, 20, 0, 10);
            } else {
                buttonLayout.setMargins(0, 10, 0, 10);
            }

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (((Button) v).getText().toString().equals("Custom Workout")) {
                        //custom workout
                    } else {
                        //selected workout
                        toadd = ((Button) v).getText().toString();
                        Intent i;
                        i = new Intent(SelectExercises.this, AddWorkout.class);
                        startActivity(i);
                    }
                }
            });

            mainLayout.addView(button, buttonLayout);
        }
    }
}
