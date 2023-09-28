package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Intent part

        //Get the Intent that activated this Activity
        Intent intent = getIntent();

        //Get the string containing the message from the Intent extras using the MainActivity.EXTRA_MESSAGE static variable as the key
        String value = intent.getStringExtra(MainActivity.EXTRA_VALUE);

        //Use findViewByID() to get a reference to the TextView for the message from the layout
        TextView textView = findViewById(R.id.text_value);

        //Set the text of the TextView to the string from the Intent extra
        textView.setText("->" + value);

    }
}