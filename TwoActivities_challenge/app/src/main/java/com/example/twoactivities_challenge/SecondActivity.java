package com.example.twoactivities_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /*Modify SecondActivity to get the extras and display the message*/

        //get the Intent tha activated this Activity
        Intent intent = getIntent();

        //Get the string containing the message from the Intent extras using the MainActivity.EXTRA_MESSAGE static variable as the key
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Use findViewByID() to get a reference to the TextView for the message from the layout
        TextView textView = findViewById(R.id.text_message);

        //Set the text of the TextView to the string from the Intent extra
        textView.setText(message);
    }
}