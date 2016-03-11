package com.changli0914.webviewtest;

/**
 * Created by khaldor on 14/02/16.
 */

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
<<<<<<< HEAD
=======
import com.parse.ParseObject;
>>>>>>> c34e6e92e09e13be3a0404e79c6839651075397b
import com.parse.ParseUser;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

<<<<<<< HEAD
        // Add your initialization code here
=======
        ParseObject.registerSubclass(Pair.class);

>>>>>>> c34e6e92e09e13be3a0404e79c6839651075397b
        Parse.initialize(this);

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
