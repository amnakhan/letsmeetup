package com.mbembac.letsmeetup;

/**
 * Created by amnakhan on 10/16/14.
 */
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import android.app.Application;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "HAX3UEY7MZ1nfP7UhrkwvWH7FFutZ1vdf0fKzmP7", "sqT98AlebubQTHlwvv5GCpmgk66LiLYOBZBJhMCJ");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }

}
