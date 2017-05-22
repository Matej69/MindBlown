package com.mindblown.drunkbearzz.mindblown;

import android.content.Context;
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
    public static int maxDatabaseQuestion = 3;
    public static int maxProgress = 3;
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




    //Database info
    /*
    static private Firebase databaseRoot;       //root is always same so it can be stored once
    static public Firebase GetDatabaseRoot()
    {
        if(databaseRoot == null)
            databaseRoot = new Firebase("https://mindblown-cb605.firebaseio.com/");
        return databaseRoot;
    }
    */
/*
    static public Firebase GetDatabaseCategory(QuestionInfo.E_CATEGORY _cat)
    {
        return databaseRoot = new Firebase("https://mindblown-cb605.firebaseio.com/"+String.valueOf(_cat));
    }
*/




}
