package com.mindblown.drunkbearzz.mindblown;

import com.firebase.client.Firebase;

/**
 * Created by Matej on 21/05/2017.
 */
public class DatabaseInit extends android.app.Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
