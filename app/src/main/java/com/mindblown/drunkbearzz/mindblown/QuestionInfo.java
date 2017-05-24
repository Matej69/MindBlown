package com.mindblown.drunkbearzz.mindblown;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Created by Matej on 19/05/2017.
 */
public class QuestionInfo {
    public enum E_CATEGORY
    {
        ANIMALS,
        MEMES,
        INTERNET,
        SPORT,
        /*
        TIME,//what was before
        SCIENCE,
        BIOLOGY,
        POKEMON,
        VIDEO_GAMES,
        MOVIES,
        COUNTRIES,
        FOOD,
        DRINK,
        ANIME,
        //what was before
        */
        MAX
    }

    public String question;
    public String answer1;
    public String answer2;
    public String answer3;
    public String correctAnswer;


    public QuestionInfo(String _q, String _a1, String _a2, String _a3, String _c)
    {
        question = _q;
        answer1 = _a1;
        answer2 = _a2;
        answer3 = _a3;
        correctAnswer = _c;
    }
    public boolean IsCorrect(String _answer)
    {
        return (_answer.equals(correctAnswer));
    }



}
