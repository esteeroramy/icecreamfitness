package com.example.ramy.icecreamfitness;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;


import android.widget.*;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RelativeLayout myLayout = (RelativeLayout)findViewById(R.id.prev);
        TextView headder = new TextView(this);
        headder.setText("Previous");
        headder.setTextSize(30);
        headder.setTextColor(Color.BLACK);
        headder.setId(5);
        RelativeLayout.LayoutParams headderLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        TextView body = new TextView(this);
        body.setText("\n     asdfasdfasdf         asdfasdasdf" +
                "\n     asdfasdfadsf         asdfasdfasdfa" +
                "\n     asdasdasdasd       asdfasdfasdf");
        body.setTextSize(16);
        body.setTextColor(Color.BLACK);
        body.setId(6);
        RelativeLayout.LayoutParams bodyLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        bodyLayout.addRule(RelativeLayout.BELOW, headder.getId());
        myLayout.addView(headder, headderLayout);
        myLayout.addView(body, bodyLayout);

        ///////////////////////////////
        //This is the second section///
        ///////////////////////////////

        RelativeLayout myLayout1 = (RelativeLayout)findViewById(R.id.next);
        TextView headder1 = new TextView(this);
        headder1.setText("Next");
        headder1.setTextSize(30);
        headder1.setTextColor(Color.BLACK);
        headder1.setId(7);
        RelativeLayout.LayoutParams headder1Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        TextView body1 = new TextView(this);
        body1.setText("\n     asdfasdfasdf         asdfasdasdf" +
                "\n     asdfasdfadsf         asdfasdfasdfa" +
                "\n     asdasdasdasd       asdfasdfasdf");
        body1.setTextSize(16);
        body1.setTextColor(Color.BLACK);
        body1.setId(8);
        RelativeLayout.LayoutParams body1Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        body1Layout.addRule(RelativeLayout.BELOW, headder1.getId());
        myLayout1.addView(headder1, headder1Layout);
        myLayout1.addView(body1, body1Layout);




/*

               <TextView
            android:id="@+id/btxt"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="This is a test"
            android:textColor="#000000"
            android:textSize="40sp"
            />
*/
        /*

                    android:id="@+id/btxt"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textColor="#000000"
            android:textSize="40sp"
         */


        //LinearLayout item = (LinearLayout)findViewById(R.id.backend);
        //View child = getLayoutInflater().inflate(R.layout.activity_home, null);
        //item.addView(myb);
        //item.addView(t);






/*

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(Home.this, "Going to Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_history:
                        Toast.makeText(Home.this, "Going to History", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_progress:
                        Toast.makeText(Home.this, "Going to Progress", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
*/
    }
}
