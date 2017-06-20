package com.example.ramy.icecreamfitness;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.WindowManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Workout extends AppCompatActivity {

    DBManager dbManager;
    public String var;
    public RelativeLayout mainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        dbManager = new DBManager(this, null, null, 1);
        String thedata = dbManager.getNextExer(Home.user, Home.workoutName);
        String pattern = "\\s*(.+?)\\s*(\\d+)x(.+?)\\s*(.+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(thedata);

        Button submit;
        RelativeLayout.LayoutParams submitLayout;

        mainLayout = (RelativeLayout)findViewById(R.id.mainhere);

        android.support.v7.widget.Toolbar tb = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);

        Button help;
        RelativeLayout.LayoutParams helpLayout;

        EditText reps;
        RelativeLayout.LayoutParams repsLayout;

        RelativeLayout myLayout;
        RelativeLayout buttonSection;
        TextView headder;
        Button button;
        EditText weightkg;
        RelativeLayout.LayoutParams weightLayoutkg;
        EditText weightlb;
        RelativeLayout.LayoutParams weightLayoutlb;
        RelativeLayout.LayoutParams headderLayout;
        RelativeLayout.LayoutParams buttonLayout;
        RelativeLayout.LayoutParams ButtonSectionLayout;
        RelativeLayout.LayoutParams bigLayout;
        ShapeDrawable rectShapeDrawable;

        TextView kg;
        RelativeLayout.LayoutParams kgLayout;

        TextView lb;
        RelativeLayout.LayoutParams lbLayout;

        int weights = 1000;
        int i = 10;
        while (m.find()) {
            //make the box
            myLayout = new RelativeLayout(this);
            buttonSection = new RelativeLayout(this);
            buttonSection.setId(7);
            myLayout.setId(i);

            //Headder elements
            headder = new TextView(this);
            //make the headder in it
            headder.setText(m.group(1));
            headder.setTextSize(20);
            headder.setTextColor(Color.WHITE);
            headder.setId(weights);
            //put it in the correct place
            headderLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            headderLayout.setMargins(20, 20, 0, 0);
            myLayout.addView(headder, headderLayout);
            buttonSection.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

            if (!m.group(4).equals("BW")) {
                //help button
                help = new Button(this);
                help.setText("");
                help.setTextSize(20);
                //button.setBackgroundColor(Color.GRAY);
                help.setTextColor(Color.WHITE);
                help.setId(weights + 1);
                helpLayout = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                help.setBackgroundResource(R.drawable.ic_help);
                helpLayout.addRule(RelativeLayout.LEFT_OF, 4);
                helpLayout.setMargins(20, 20, 0, 0);
                help.setPadding(0, 0, 0, 0);
                helpLayout.width = 80;
                helpLayout.height = 80;
                myLayout.addView(help, helpLayout);

                help.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        TextView a = (TextView) findViewById(v.getId() - 1);
                        //a.setVisibility(View.INVISIBLE);
                        //a.setText("THIS IS A TEST\nTHIS IS ANOTHER LINE\nTHIS IS A THIRD LINE\nFOUR\nFINVE");
                    }
                });

                //Weight elements
                weightkg = new EditText(this);
                weightkg.setText(m.group(4));
                weightkg.setTextSize(15);
                weightkg.setTextColor(Color.WHITE);
                weightkg.setId(6);
                //put it in the correct place
                weightLayoutkg = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                weightLayoutkg.addRule(RelativeLayout.LEFT_OF, 5);
                myLayout.addView(weightkg, weightLayoutkg);

                //Weight elements
                kg = new TextView(this);
                kg.setText("Kg");
                kg.setTextSize(15);
                kg.setTextColor(Color.WHITE);
                kg.setId(5);
                //put it in the correct place
                kgLayout = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                kgLayout.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                kgLayout.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                kgLayout.setMargins(0, 30, 20, 20);
                myLayout.addView(kg, kgLayout);


                //Weight elements
                weightlb = new EditText(this);
                weightlb.setText(m.group(4));
                weightlb.setTextSize(15);
                weightlb.setTextColor(Color.WHITE);
                weightlb.setId(4);
                //put it in the correct place
                weightLayoutlb = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                weightLayoutlb.addRule(RelativeLayout.LEFT_OF, 3);
                myLayout.addView(weightlb, weightLayoutlb);

                //Weight elements
                lb = new TextView(this);
                lb.setText("Lb /");
                lb.setTextSize(15);
                lb.setTextColor(Color.WHITE);
                lb.setId(3);
                //put it in the correct place
                lbLayout = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                lbLayout.addRule(RelativeLayout.LEFT_OF, 6);
                lbLayout.setMargins(0, 30, 0, 20);
                myLayout.addView(lb, lbLayout);
            } else {
                //Weight elements
                kg = new TextView(this);
                kg.setText("BodyWeight");
                kg.setTextSize(15);
                kg.setTextColor(Color.WHITE);
                kg.setId(5);
                //put it in the correct place
                kgLayout = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                kgLayout.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                kgLayout.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                kgLayout.setMargins(0, 30, 20, 20);
                myLayout.addView(kg, kgLayout);
            }




            //Button elements
            for (int j = 100; j < 100 + Integer.parseInt(m.group(2)); j++) {

                if (!m.group(3).equals("FAIL")) {
                    button = new Button(this);
                    button.setText("");
                    button.setTextSize(20);
                    //button.setBackgroundColor(Color.GRAY);
                    button.setTextColor(Color.WHITE);
                    button.setId(j);
                    buttonLayout = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    //button.text
                    button.setBackgroundResource(R.drawable.gray_round);
                    if (j != 100) {
                        buttonLayout.addRule(RelativeLayout.RIGHT_OF, j - 1);
                    }
                    //buttonLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    buttonLayout.addRule(RelativeLayout.BELOW, headder.getId());
                    button.setPadding(0, 0, 0, 0);
                    buttonLayout.width = 125;
                    buttonLayout.height = 125;
                    buttonLayout.setMargins(30, 50, 30, 20);
                    var = m.group(3);
                    System.out.println(var);

                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Button myb = ((Button) v);
                            String inner = myb.getText().toString();
                            if (inner.equals("")) {
                                myb.setText(var);
                                myb.setBackgroundResource(R.drawable.round_button);
                            } else if (inner.equals("0")) {
                                myb.setText("");
                                myb.setBackgroundResource(R.drawable.gray_round);
                            } else {
                                int number = Integer.parseInt(inner);
                                myb.setText(Integer.toString(number - 1));
                            }
                        }
                    });


                    buttonSection.addView(button, buttonLayout);
                } else {
                    reps = new EditText(this);
                    reps.setText("");
                    reps.setTextSize(20);
                    //button.setBackgroundColor(Color.GRAY);
                    reps.setTextColor(Color.WHITE);
                    reps.setId(j);
                    reps.setInputType(InputType.TYPE_CLASS_NUMBER);
                    repsLayout = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    //button.text
                    if (j != 100) {
                        repsLayout.addRule(RelativeLayout.RIGHT_OF, j - 1);
                    }
                    //buttonLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    repsLayout.addRule(RelativeLayout.BELOW, headder.getId());
                    reps.setPadding(0, 0, 0, 0);
                    repsLayout.setMargins(30, 50, 30, 20);
                    buttonSection.addView(reps, repsLayout);
                }
            }
            ButtonSectionLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            ButtonSectionLayout.addRule(RelativeLayout.BELOW, headder.getId());
            myLayout.addView(buttonSection, ButtonSectionLayout);
            //Big Layout Settings
            bigLayout = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            bigLayout.setMargins(20, 20, 20, 10);

            //add it to the correct position
            if (i == 10) {
                bigLayout.addRule(RelativeLayout.BELOW, tb.getId());
            } else {
                bigLayout.addRule(RelativeLayout.BELOW, i-1);
            }
            myLayout.setPadding(8, 8, 8, 8);

            rectShapeDrawable = new ShapeDrawable();
            Paint paint = rectShapeDrawable.getPaint();

            //paint.setColor(getResources().getColor(R.color.colorPrimary));
            paint.setColor(Color.DKGRAY);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            paint.setStrokeWidth(0);
            myLayout.setBackgroundDrawable(rectShapeDrawable);
            mainLayout.addView(myLayout, bigLayout);
            i += 1;
            weights += 2;
        }

        submit = new Button(this);
        submit.setText("Save Workout");
        submit.setTextSize(20);
        submit.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        submit.setTextColor(Color.WHITE);
        submit.setId(1);
        submitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        submitLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        submitLayout.addRule(RelativeLayout.BELOW, i-1);
        submit.setPadding(20, 0, 20, 0);
        submitLayout.setMargins(0,20,0,0);
        mainLayout.addView(submit, submitLayout);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //nothing for now TODO: add the workout to the workouts of the user
                //TODO: add the workout details
                //TODO: the time thing
                String addName;
                String addWorkout;
                String addExer;
                int addDay;
                int addDate;
                float addweight;
                int addset;
                int addreps;

                DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmm");
                Date date = new Date();
                addDate = Integer.parseInt(dateFormat.format(date));

                addName = Home.user;
                addWorkout = Home.workoutName;
                addDay = Home.day;
                String thedata = dbManager.getNextExer(Home.user, Home.workoutName);
                String pattern = "\\s*(.+?)\\s*(\\d+)x(.+?)\\s*(.+)";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(thedata);

                dbManager.saveWorkout(addName, addWorkout, addDay, addDate);
                int i = 10;
                while (m.find()) {
                    addExer =  m.group(1);

                    RelativeLayout theLayout = (RelativeLayout) findViewById(i);

                    if (!m.group(4).equals("BW")) {
                        addweight = Float.parseFloat(((TextView) theLayout.findViewById(4)).getText().toString());
                    } else {
                        addweight = (float) 0.0;
                    }



                    //Button elements
                    for (int j = 100; j < 100 + Integer.parseInt(m.group(2)); j++) {
                        addset = j-99;
                        RelativeLayout buttons = ((RelativeLayout) theLayout.findViewById(7));

                        if (!m.group(3).equals("FAIL")) {
                            if (!((Button) buttons.findViewById(j)).getText().equals("")) {
                                addreps = Integer.parseInt(((Button) buttons.findViewById(j)).getText().toString());
                            } else {
                                addreps = 0;
                            }
                        } else {
                            if (!((EditText) buttons.findViewById(j)).getText().toString().trim().equals("")) {
                                addreps = Integer.parseInt(((EditText) buttons.findViewById(j)).getText().toString());
                            } else {
                                addreps = 0;
                            }
                        }
                        dbManager.saveExer(addName, addWorkout, addDay, addExer, addset, addreps, addweight, addDate);
                    }
                    i += 1;
                }
                Intent intent;
                intent = new Intent(Workout.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
