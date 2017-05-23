package com.mindblown.drunkbearzz.mindblown;

import android.content.Context;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

/**
 * Created by Matej on 21/05/2017.
 */
public class QuestionWriter {

    //Write child
    static private void CreateChild(Firebase _parent, String _nameID, String _val)
    {
        Firebase child = _parent.child(_nameID);
        child.setValue(_val);
    }


    static private int numOfQ = 0;
    static public void AddQuestionToDatabase(QuestionInfo.E_CATEGORY _cat, QuestionInfo _questionInfo)
    {
        Firebase category = new Firebase("https://mindblown-cb605.firebaseio.com/"+_cat.toString());

        //Add new Question with name Q+numOfQ
        Firebase newQ = category.child("Q"+String.valueOf(numOfQ));
        numOfQ++;
        //Add new Question properties as childreen
        CreateChild(newQ, "Q", _questionInfo.question);
        CreateChild(newQ, "A1", _questionInfo.answer1);
        CreateChild(newQ, "A2", _questionInfo.answer2);
        CreateChild(newQ, "A3", _questionInfo.answer3);
        CreateChild(newQ, "C", _questionInfo.correctAnswer);
    }



    //**************************************** DATABASE CREATION ********************************************
    //*********************************** WILL NOT BE IN FINAL BUILD ***************************************
    //Init all categories
    static private void InitCategoriesToDatabase()
    {
        Firebase databaseRoot = new Firebase("https://mindblown-cb605.firebaseio.com/");
        for(QuestionInfo.E_CATEGORY category : QuestionInfo.E_CATEGORY.values())
            CreateChild(databaseRoot, category.toString(), "0");
    }

    static public void InitDatabase()
    {
        InitCategoriesToDatabase();

        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Tako2 32asto?", "Tako", "Nako", "Vako", "Nako"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("111111", "Tako", "Nako", "Vako", "Nako"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("WWWWWWWW WWWWWWWWWWWWWWWWWWWW WWWWWWWWWWWWWWWWWWWWWWW WWWWWWWWWWW WWWWWWWWWWW WWWWWWWWW WWWWWWWWW WWWWWWWWWWWW", "Tako", "Nako", "Vako", "Nako"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Ko je jako los u programiranju, al onak, stavno los da to nije normalno", "Luka", "Ante", "Luka i Ante", "Luka i Ante"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Gdje je matej?", "U klubu", "U maminon podrumu", "Kod cure", "U maminon podrumu"));
    }


}
