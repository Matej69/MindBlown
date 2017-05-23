package com.mindblown.drunkbearzz.mindblown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CloseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close);
        finish();
    }
}
