package com.mindblown.drunkbearzz.mindblown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainMenu extends AppCompatActivity {

    private Firebase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        QuestionWriter.InitDatabase();
        QuestionReader.InitDatabaseValueListeners();


    }

    public void OnStartButton(View v)
    {

        //Global.ResetAnswersCorrectness();
        //Intent intent = new Intent(this, LevelAdvancement.class);
        //startActivity(intent);
    }

    public void OnExitButton(View v)
    {
            QuestionInfo info = QuestionReader.GetRandQuestionInfo(QuestionInfo.E_CATEGORY.DINOSAURS);
            Global.Write(getApplicationContext(),info.question);
        //finish();
    }



}
