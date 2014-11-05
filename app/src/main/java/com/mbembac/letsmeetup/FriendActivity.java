package com.mbembac.letsmeetup;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.List;
import java.util.ArrayList;

import com.parse.ParseUser;

public class FriendActivity extends Fragment {

    Button addfriend;
    Button findfriend;
   // Button goback;

    String finduser;
    EditText findusertxt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_find_friends, container, false);

//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

//        setContentView(R.layout.activity_find_friends);



        addfriend = (Button) v.findViewById(R.id.addfriend_button);
        findfriend = (Button) v.findViewById(R.id.findfriend_button);
        //goback = (Button) v.findViewById(R.id.go_back_friends);

        findusertxt = (EditText) v.findViewById(R.id.find_user_box);

        final ArrayList<String> list = new ArrayList<String>();
        final ListView getlist = (ListView) v.findViewById(R.id.friendresults);
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
                                        if (!list.contains(oneObject.getUsername())) {
                                            list.add(oneObject.getUsername());
                                        }
                                    }
                                }
                                ArrayAdapter<String> arrayAdapter =
                                        new ArrayAdapter<String>(getActivity(), R.layout.custom_layout, list);
                                getlist.setAdapter(arrayAdapter);
                            }
                            if (finduser.equals("")) {
                                Toast.makeText(getActivity(),
                                        "Enter a username to search.",
                                        Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getActivity(),
                                    "An error occurred.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        getlist.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String x = parent.getItemAtPosition(position).toString();
                //send friend request to other user
            }
        });

        // Add Friend Button Click Listener
        addfriend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showSimplePopUp();
            }
        });


//        // Go Back to Home Page Click Listener
//        goback.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View arg0) {
//
//                Intent intent = new Intent(getActivity(),
//                        Welcome.class);
//                startActivity(intent);
//                //finish();
//
//            }
//        });

    return v;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//
//        int titleId = getResources().getIdentifier("action_bar_title", "id",
//                "android");
//
//        TextView yourTextView = (TextView) findViewById(titleId);
//        Typeface customFont = Typeface.createFromAsset(getAssets(), "Chi-TownNF.ttf");
//        yourTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
//        yourTextView.setTypeface(customFont);
//
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_activity_actions, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // app icon in action bar clicked; goto parent activity.
//                this.finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private void showSimplePopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        helpBuilder.setTitle("Add Friend?");
        helpBuilder.setMessage("Send friend request to");
        helpBuilder.setPositiveButton("Add Friend",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });
        helpBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Close window
                    }
                });
        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

}

