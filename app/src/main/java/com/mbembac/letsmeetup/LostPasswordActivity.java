package com.mbembac.letsmeetup;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import android.view.MenuInflater;


public class LostPasswordActivity extends Activity {

    Button goback;
    Button sendpw;

    EditText email;
    String emailtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_lost_password);

        goback = (Button) findViewById(R.id.go_back_button);
        sendpw = (Button) findViewById(R.id.send_button);

        email = (EditText) findViewById(R.id.send_email);

        // send password to user
        sendpw.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {


                emailtxt = email.getText().toString().toLowerCase();

                try {
                    ParseUser.requestPasswordReset(emailtxt);
                    Toast.makeText(
                            getApplicationContext(),
                            "An email has been sent for you to reset your password.",
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(LostPasswordActivity.this,
                            LoginSignupActivity.class);
                    startActivity(intent);

                } catch (ParseException e) {
                    Toast.makeText(
                            getApplicationContext(),
                            "An error occurred while sending the email.",
                            Toast.LENGTH_LONG).show();
                }
            }

        });


        // go back button from lost password page
        goback.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(LostPasswordActivity.this,
                        LoginSignupActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
