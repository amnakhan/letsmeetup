package com.mbembac.letsmeetup;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class CreateAccountActivity extends Activity {

    Button goback;
    Button signup;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;

    String first_nametxt;
    String last_nametxt;
    String emailtxt;

    EditText first_name;
    EditText last_name;
    EditText email;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

        // Get the view from main.xml
        setContentView(R.layout.activity_create_account);

        // Locate EditTexts in main.xml
        first_name = (EditText) findViewById(R.id.login_first_name);
        last_name = (EditText) findViewById(R.id.login_last_name);
        email = (EditText) findViewById(R.id.create_email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        // Locate Buttons in main.xml
        signup = (Button) findViewById(R.id.signup);
        goback = (Button) findViewById(R.id.go_back_button);

        // Login Button Click Listener
        signup.setOnClickListener(new OnClickListener() {


            public void onClick(View arg0) {

                // Retrieve the text entered from the EditText
                first_nametxt = first_name.getText().toString();
                last_nametxt = last_name.getText().toString();
                emailtxt = email.getText().toString().toLowerCase();
                usernametxt = username.getText().toString().toLowerCase();
                passwordtxt = password.getText().toString();

                // Force user to fill up the form
                if (usernametxt.equals("") && passwordtxt.equals("") && emailtxt.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please fill in the username, password, and email fields.",
                            Toast.LENGTH_LONG).show();

                } else {
                    // Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.put("first_name", first_nametxt);
                    user.put("last_name", last_nametxt);
                    user.setEmail(emailtxt);
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {

                                ParseUser.logInInBackground(usernametxt, passwordtxt, new LogInCallback() {
                                    public void done(ParseUser user, ParseException e) {
                                        Intent intent = new Intent(
                                                CreateAccountActivity.this,
                                                Welcome.class);
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(),
                                                "Successfully Registered!",
                                                Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                });
                            }else {
                                Toast.makeText(getApplicationContext(),
                                        "Whoops! Email or Username already used. Let's try that again.", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });


                }
            }
        });

        // Go Back to Home Page Click Listener
        goback.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(CreateAccountActivity.this,
                        LoginSignupActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}