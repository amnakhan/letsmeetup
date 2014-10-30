package com.mbembac.letsmeetup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuInflater;
import com.parse.ParseUser;

public class Welcome extends Activity {

    // Declare Variable
    Button logout;
    Button friendme;


    private Welcome context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // Get the view from singleitemview.xml
        setContentView(R.layout.welcome);

        Button map = (Button) findViewById(R.id.map_button);
        map.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friendMap;
                friendMap = new Intent(context, FriendMapActivty.class);
                startActivity(friendMap);
            }
        });


        friendme = (Button) findViewById(R.id.friendme_button);
        logout = (Button) findViewById(R.id.logout);


        Typeface customFont = Typeface.createFromAsset(getAssets(),"BLACKJAR.ttf");
        TextView b = (TextView) findViewById(R.id.welcometitle);


        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        //String struser = currentUser.getUsername();
        String x = currentUser.get("first_name").toString();

        String firstLetter = x.substring(0,1).toUpperCase();
        String restLetters = x.substring(1).toLowerCase();
        x = firstLetter + restLetters;

        // Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);
        txtuser.setTypeface(customFont);

        // Set the currentUser String into TextView
        txtuser.setTextColor(Color.DKGRAY);
        txtuser.isOpaque();
        txtuser.setText("Welcome " + x + "!");


        // Find Friends Button Click Listener
        friendme.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                Intent intent = new Intent(Welcome.this,
                        FriendActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Logout Button Click Listener
        logout.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Logout current user
                ParseUser.logOut();
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Debug.stopMethodTracing();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        int titleId = getResources().getIdentifier("action_bar_title", "id",
                "android");

        TextView yourTextView = (TextView) findViewById(titleId);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"Chi-TownNF.ttf");
        yourTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        yourTextView.setTypeface(customFont);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}