package com.example.androidproje;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String user=getIntent().getExtras().getString("username");
    }
}
