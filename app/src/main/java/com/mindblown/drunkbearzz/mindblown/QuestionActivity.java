package com.mindblown.drunkbearzz.mindblown;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class QuestionActivity extends AppCompatActivity {

    TextView txt_question;
    ProgressBar bar_progress;
    ArrayList<Button> buttonList;

    QuestionInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        InitGUIRefrences();
        InitValues();

        if(Global.IsConnectedToInternet(getApplicationContext()))
            InitNewQuestion();
        else
            OnDisconect();


    }


    private void InitGUIRefrences()
    {
        txt_question = (TextView)findViewById(R.id.txt_question);
        bar_progress = (ProgressBar)findViewById(R.id.bar_progress);
        buttonList = new ArrayList();
        buttonList.add((Button) findViewById(R.id.btn_answer1));
        buttonList.add((Button) findViewById(R.id.btn_answer2));
        buttonList.add((Button) findViewById(R.id.btn_answer3));
    }
    private void InitValues()
    {
        bar_progress.setMax(Global.maxProgress);
        bar_progress.setProgress(Global.progress);
    }
    private void ReadInfoToGUI(QuestionInfo _questionInfo)
    {
        txt_question.setText(_questionInfo.question);
        bar_progress.setProgress(Global.progress);
        buttonList.get(0).setText(_questionInfo.answer1);
        buttonList.get(1).setText(_questionInfo.answer2);
        buttonList.get(2).setText(_questionInfo.answer3);
    }



    //Go to next screen after XXX seconds
    private void CreateOnClickHandler(final boolean _didClickCorrect)
    {
        Handler hand_waitAfterAnswer = new Handler();
        hand_waitAfterAnswer.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (_didClickCorrect)
                {
                    Global.Progress();
                    Global.correctAnswers++;
                    //if category is done, and new category is assigned(after Progress() it will be 0)
                    if (Global.progress == 0)
                    {
                        //if max category is reached
                        if (Global.category != QuestionInfo.E_CATEGORY.MAX)
                            startActivity(new Intent(QuestionActivity.this, LevelAdvancement.class));
                        else
                            startActivity(new Intent(QuestionActivity.this, FinishGameActivity.class));
                    }
                    //if we're just progressing in current category
                    else
                    {
                        if (Global.IsConnectedToInternet(getApplicationContext()))
                            InitNewQuestion();
                        else
                            OnDisconect();

                    }
                }
                else
                {
                    Global.ResetProgress();
                    Global.incorrectAnswers++;
                    if (Global.IsConnectedToInternet(getApplicationContext()))
                        startActivity(new Intent(QuestionActivity.this, LevelAdvancement.class));
                    else
                        OnDisconect();
                }
            }
        }, 2000);
    }


    private void InitNewQuestion()
    {
        //Refresh info for GUI
        info = QuestionReader.GetRandQuestionInfo(Global.category);
        ReadInfoToGUI(info);
        //Refresh button attributes
        for (Button curBtn : buttonList )
        {
            curBtn.setBackgroundColor(0xFF5cdeff);
            curBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnAnswerClicked(v);
                }
            });
        }
    }




    public void OnAnswerClicked(View v)
    {

        //Change colors of correct/incorrect answers when clicked
        Button clickedBtn = (Button)v;
        for (Button curBtn : buttonList )
        {
            //if this button is right
            if(info.correctAnswer.equals(curBtn.getText()))
            {
                curBtn.setBackgroundColor(Color.GREEN);
            }
            //if clicked button is this button and it's not right answer
            if(clickedBtn.equals(curBtn) && !info.correctAnswer.equals(clickedBtn.getText()))
            {
                clickedBtn.setBackgroundColor(Color.RED);
            }

            //disable further answers clickability
            curBtn.setOnClickListener(null);
        }
        //Create Handle
        boolean didClickCorrect = (info.correctAnswer.equals(clickedBtn.getText())) ? true : false;
        CreateOnClickHandler(didClickCorrect);
    }

    public void OnDisconect()
    {
        startActivity(new Intent(this, MainMenu.class));
        Global.Write(getApplicationContext(), "YOU MUST BE CONNECTED TO INTERNET");
    }









}
