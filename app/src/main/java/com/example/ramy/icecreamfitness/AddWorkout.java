package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AddWorkout extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);
        dbManager = new DBManager(this, null, null, 1);
        TextView details = (TextView) findViewById(R.id.details);
        details.setTypeface(Typeface.MONOSPACE);
        details.setText(dbManager.getWorkoutDetails(SelectExercises.toadd));

        ArrayList<String> exer = dbManager.getExercises(SelectExercises.toadd);


        RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.defaults);

        TextView tv;
        RelativeLayout.LayoutParams tvLayout;

        EditText et;
        RelativeLayout.LayoutParams etLayout;

        for (int j = 1; j < exer.size()+1; j++) {

            tv = new TextView(this);
            tv.setText(exer.get(j-1));
            tv.setTextSize(17);
            tv.setId(j);
            tv.setTextColor(Color.BLACK);
            tvLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            tvLayout.setMargins(0,45,0,0);
            tvLayout.addRule(RelativeLayout.BELOW, j - 1);
            mainLayout.addView(tv, tvLayout);
            et = new EditText(this);
            et.setTextSize(15);
            et.setTextColor(Color.BLACK);
            et.setId(j*100);
            etLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            etLayout.addRule(RelativeLayout.BELOW, 100*(j-1));
            etLayout.addRule(RelativeLayout.RIGHT_OF, tv.getId());
            etLayout.setMargins(20,0,0,0);
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            mainLayout.addView(et, etLayout);
        }
    }
}
