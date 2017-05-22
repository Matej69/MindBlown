package com.mindblown.drunkbearzz.mindblown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinishGameActivity extends AppCompatActivity {

    TextView txt_correctAnswers;
    TextView txt_incorrectAnswers;
    TextView txt_rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_game);

        InitGUIRefrences();
        SetFinalScoreValues();

    }


    private void InitGUIRefrences()
    {
        txt_correctAnswers = (TextView)findViewById(R.id.txt_correct);
        txt_incorrectAnswers = (TextView)findViewById(R.id.txt_incorrect);
        txt_rank = (TextView)findViewById(R.id.txt_rank);
    }

    private void SetFinalScoreValues()
    {
        txt_correctAnswers.setText("Correct : "+String.valueOf( Global.correctAnswers));
        txt_incorrectAnswers.setText("Incorrect : "+String.valueOf(Global.incorrectAnswers));
        txt_rank.setText(String.valueOf("Rank : "+(float)Global.correctAnswers/(float)Global.incorrectAnswers));
    }




}
