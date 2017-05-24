package com.mindblown.drunkbearzz.mindblown;

import android.content.Context;
import android.os.Handler;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Matej on 19/05/2017.
 */

public class QuestionReader{


    private static int randQID = 0;
    private  static QuestionInfo questionInfo = new QuestionInfo("", "", "", "", "");
    static public QuestionInfo GetRandQuestionInfo(QuestionInfo.E_CATEGORY _cat)
    {
        //Get random question ID
        Random rand = new Random();
        randQID = rand.nextInt(Global.maxDatabaseQuestion);

        //Get random question info
        Firebase question = new Firebase("https://mindblown-cb605.firebaseio.com/"+_cat.toString()+"/Q"+randQID);
        question.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of all question in category Q1,Q2,Q3,...
                HashMap<String, String> Qmap = dataSnapshot.getValue(HashMap.class);
                questionInfo = new QuestionInfo(Qmap.get("Q"), Qmap.get("A1"), Qmap.get("A2"), Qmap.get("A3"), Qmap.get("C"));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        return questionInfo;
    }




    /*
    //Trigger some event listeners for first time(Some weird stuff)
    static private boolean isDatabaseListenerSetup = false;
    public static void InitDatabaseValueListener()
    {
        if(!isDatabaseListenerSetup)
        {
            //GetRandQuestionInfo(QuestionInfo.E_CATEGORY.INTERNET);
            isDatabaseListenerSetup = true;
        }
    }
    */

}
