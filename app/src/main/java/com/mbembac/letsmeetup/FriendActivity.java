package com.mbembac.letsmeetup;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import java.util.List;
import java.util.ArrayList;
import com.parse.ParseUser;

public class FriendActivity extends Activity {

    Button addfriend;
    Button findfriend;
    Button goback;

    String finduser;
    EditText findusertxt;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_find_friends);

        addfriend = (Button) findViewById(R.id.addfriend_button);
        findfriend = (Button) findViewById(R.id.findfriend_button);
        goback = (Button) findViewById(R.id.go_back_friends);

        findusertxt = (EditText) findViewById(R.id.find_user_box);

        final ArrayList<String> list = new ArrayList<String>();
        final ListView getlist = (ListView) findViewById(R.id.friendresults);
        getlist.setBackgroundColor(Color.argb(12, 24, 34, 23));
        getlist.setCacheColorHint(Color.DKGRAY);


        // Add Friend Button Click Listener
        findfriend.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                finduser = findusertxt.getText().toString();

                ParseQuery<ParseUser> query = ParseUser.getQuery();

                query.findInBackground(new FindCallback<ParseUser>() {
                    @Override
                    public void done(List<ParseUser> objects, ParseException e) {

                        if (e == null) {
                            if (!finduser.equals("")) {
                                String x = finduser;
                                for (ParseUser oneObject : objects) {
                                    if (oneObject.getUsername().contains(x)) {
                                        if(!list.contains(oneObject.getUsername())) {
                                            list.add(oneObject.getUsername());
                                        }
                                    }
                                }
                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FriendActivity.this, android.R.layout.simple_list_item_1, list);

                                getlist.setAdapter(arrayAdapter);
                            }
                            if (finduser.equals("")) {
                                Toast.makeText(getApplicationContext(),
                                        "Enter a username to search.",
                                        Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "An error occurred.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        // Go Back to Home Page Click Listener
        goback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(FriendActivity.this,
                        Welcome.class);
                startActivity(intent);
                finish();

            }
        });


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

