package com.mbembac.letsmeetup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import android.widget.ArrayAdapter;

import java.util.List;
import android.widget.ListView;
import java.util.ArrayList;

public class FriendActivity extends Activity {

    Button addfriend;
    Button findfriend;

    String finduser;
    EditText findusertxt;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find_friends);

        addfriend = (Button) findViewById(R.id.addfriend_button);
        findfriend = (Button) findViewById(R.id.findfriend_button);

        findusertxt = (EditText) findViewById(R.id.find_user_box);

        final ArrayList<String> list = new ArrayList<String>();
        final ListView getlist = (ListView) findViewById(R.id.friendresults);

        // Add Friend Button Click Listener
        findfriend.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                finduser = findusertxt.getText().toString();

                ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
                query.whereContains("username",finduser);

                query.findInBackground(new FindCallback<ParseObject>() {

                    public void done(List<ParseObject> results, ParseException e) {

                        if (e == null) {

                             for (ParseObject singleresult : results) {
                             String x = singleresult.toString();
                             list.add(x);
                             }

                            ArrayAdapter adapter = new ArrayAdapter<String>(FriendActivity.this, android.R.layout.simple_list_item_1, list);
                            getlist.setAdapter(adapter);

                        }
                    }
                });
            }
        });
    }
}