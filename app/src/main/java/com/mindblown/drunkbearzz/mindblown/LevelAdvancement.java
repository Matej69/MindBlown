package com.mindblown.drunkbearzz.mindblown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import android.os.Handler;
import java.lang.Runnable;



public class LevelAdvancement extends AppCompatActivity {

    TextView txt_category;
    TextView txt_categoryNum;

    Handler hand_nextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_advancement);

        SetRefrences();
        InitValues();
        InitNextScreenHandler(1500);


    }

    private void SetRefrences()
    {
        //GUI refrences
        txt_category = (TextView)findViewById(R.id.txt_category);
        txt_categoryNum = (TextView)findViewById(R.id.txt_categoryNum);
    }
    private void InitValues()
    {
        txt_category.setText(String.valueOf(Global.category));
        txt_categoryNum.setText(String.valueOf(Global.category.ordinal()));
    }

    private void InitNextScreenHandler(int _time)
    {
        hand_nextScreen = new Handler();
        hand_nextScreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LevelAdvancement.this, QuestionActivity.class));
            }
        },_time);

    }






}
