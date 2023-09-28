package com.example.twoactivities_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    //definition of the key for the Intent extra
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities_challenge.extra.MESSAGE";

    //Variable to hold the EditText
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign  to the variable the EditText of activity_main.xml
        mMessageEditText = findViewById(R.id.editText_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button 1 clicked");

        Intent intent = new Intent (this, SecondActivity.class);

        //get the text from EditText and turn to a string

        String message = mMessageEditText.getText().toString();

        //add the string to the intent as an extra with the EXTRA_MESSAGE constant
        intent.putExtra(EXTRA_MESSAGE,message);

        startActivity(intent);
    }
}