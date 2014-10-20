package com.mbembac.letsmeetup;

/**
 * Created by amnakhan on 10/17/14.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginSignupActivity extends Activity {
    // Declare Variables
    Button loginbutton;
    Button registerbutton;
    Button lostpwbutton;

    String usernametxt;
    String passwordtxt;

    EditText password;
    EditText username;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from main.xml
        setContentView(R.layout.loginsignup);
        // Locate EditTexts in main.xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        // Locate Buttons in main.xml
        loginbutton = (Button) findViewById(R.id.login);
        registerbutton = (Button) findViewById(R.id.register);
        lostpwbutton = (Button) findViewById(R.id.lostpw);

        // Sign up Button Click Listener
        registerbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(LoginSignupActivity.this,
                        CreateAccountActivity.class);
                startActivity(intent);
                finish();

            }
        });

        // Lost Pw Button Click Listener
        lostpwbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(LoginSignupActivity.this,
                        LostPasswordActivity.class);
                startActivity(intent);
                finish();

            }
        });


        // Login Button Click Listener
        loginbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                usernametxt = username.getText().toString().toLowerCase();
                passwordtxt = password.getText().toString();

                // Send data to Parse.com for verification
                ParseUser.logInInBackground(usernametxt, passwordtxt,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {
                                    // If user exist and authenticated, send user to Welcome.class
                                    Intent intent = new Intent(
                                            LoginSignupActivity.this,
                                            Welcome.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),
                                            "You are now logged on!",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "No such user exists. Don't forget to Register!",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });



    }
}