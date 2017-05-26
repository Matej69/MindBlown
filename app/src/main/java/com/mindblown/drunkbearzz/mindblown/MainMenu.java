package com.mindblown.drunkbearzz.mindblown;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainMenu extends AppCompatActivity {

    //private Firebase database;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        context = getApplicationContext();


    }




    public void OnStartButton(View v)
    {
        if(Global.IsConnectedToInternet(getApplicationContext()))
        {
            Global.ResetAnswersCorrectness();
            Intent intent = new Intent(context, LevelAdvancement.class);
            startActivity(intent);
        }
        else
            Global.Write(getApplicationContext(), "YOU MUST BE CONNECTED TO INTERNET");
    }



}
