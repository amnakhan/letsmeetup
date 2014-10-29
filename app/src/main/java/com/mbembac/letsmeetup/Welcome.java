package com.mbembac.letsmeetup;


/**
 * Created by amnakhan on 10/16/14.
 */

import com.parse.ParseUser;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

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

//        Button map = (Button) findViewById(R.id.find_friends_button);
//        map.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent friendMap;
//                friendMap = new Intent(context, FriendMapActivty.class);
//                startActivity(friendMap);
//            }
//        });


        friendme = (Button) findViewById(R.id.friendme_button);
        logout = (Button) findViewById(R.id.logout);


        Typeface customFont = Typeface.createFromAsset(getAssets(),"font1.ttf");
        TextView b = (TextView) findViewById(R.id.welcometitle);
        b.setTypeface(customFont);

        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        //String struser = currentUser.getUsername();
        String x = currentUser.get("first_name").toString();

        // Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);


        // Set the currentUser String into TextView
        txtuser.setTextColor(Color.BLACK);
        txtuser.setText("You are logged in as " + x);


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

}