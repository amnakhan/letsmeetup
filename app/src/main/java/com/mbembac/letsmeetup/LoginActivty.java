package com.mbembac.letsmeetup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LoginActivty extends ActionBarActivity {

    private final String TAG = ((Object) this).getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);

        Log.e(TAG, "+++ In onCreate() +++");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_activty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void login(View view) {
        Intent intent = new Intent(this, CloseFriendsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "+++ In onStart() +++");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "+++ In onResume() +++");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "+++ In onPause() +++");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "+++ In onDestroy() +++");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "+++ In onStop() +++");

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG, "+++ In onRestart() +++");
    }
}
