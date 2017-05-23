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
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;

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

        //QuestionWriter.InitDatabase();


    }




    public void OnStartButton(View v)
    {
        if(Global.IsConnectedToInternet(getApplicationContext()))
        {
            QuestionReader.InitDatabaseValueListener();

            //We wait for some time because InitDatabaseValueListener initialises itself in separate Thread,
            // Android freezes application when Semaphores are used so we need to wait for some time
            Global.Write(getApplicationContext(), "CONNECTING TO DATABASE...");
            Handler hand = new Handler();
            hand.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Global.ResetAnswersCorrectness();
                    Intent intent = new Intent(context, LevelAdvancement.class);
                    startActivity(intent);
                }
            }, 1500);
        }
        else
            Global.Write(getApplicationContext(), "YOU MUST BE CONNECTED TO INTERNET");
    }

    public void OnExitButton(View v)
    {
        finish();
    }



}
