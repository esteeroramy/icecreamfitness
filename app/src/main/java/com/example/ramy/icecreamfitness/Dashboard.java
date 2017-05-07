package com.example.ramy.icecreamfitness;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: add workout name to the top
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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
    }
}
