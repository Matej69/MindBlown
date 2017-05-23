package com.mindblown.drunkbearzz.mindblown;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by Matej on 19/05/2017.
 */
public class Global {



    //Global Toast method
    public static void Write(Context _con, String _txt)
    {
        Toast.makeText(_con, _txt, Toast.LENGTH_LONG).show();
    }



    //Game state info
    public static int maxDatabaseQuestion = 5;
    public static int maxProgress = 5;
    public static int progress = 0;
    public static QuestionInfo.E_CATEGORY category = QuestionInfo.E_CATEGORY.ANIMALS;
    public static void Progress()
    {
        progress++;
        if(progress >= maxProgress)
        {
            progress = 0;
            category = QuestionInfo.E_CATEGORY.values()[category.ordinal()+1];
        }
    }
    public static void ResetProgress()
    {
        progress = 0;
    }

    public static int correctAnswers = 0;
    public static int incorrectAnswers = 0;
    public static void ResetAnswersCorrectness()
    {
        correctAnswers = incorrectAnswers = 0;
    }


    //Connectivity
    static public boolean IsConnectedToInternet(Context con)
    {
        ConnectivityManager connectManager = (ConnectivityManager)con.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
           connectManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
            return true;
        else
            return false;
    }







}
