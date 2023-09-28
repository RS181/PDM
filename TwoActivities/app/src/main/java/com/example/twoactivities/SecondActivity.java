package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //variable that holds the EditText
    private EditText mReply;

    //Key for the Intent extra
    public static  final String  EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Saves the editText
        mReply = findViewById(R.id.editText_second);

        /*Modify SecondActivity to get the extras and display the message*/

        /*Get the Intent that activated this Activity*/
        Intent intent = getIntent();

        /*Get the string containing the message from the Intent extras using the MainActivity.EXTRA_MESSAGE static variable as the key:*/
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        /*Use findViewByID() to get a reference to the TextView for the message from the layout*/
        TextView textview = findViewById(R.id.text_message);

        /*Set the text of the TextView to the string from the Intent extra*/

        textview.setText(message);


    }

    public void returnReply(View view) {

        /*Get the text of the EditText as a string:*/
        String reply = mReply.getText().toString();

        /*Create a new intent for the response—don't reuse the Intent object that you received from the original request.*/
        Intent replyIntent = new Intent();

        /*Add the reply string from the EditText to the new intent as an Intent extra. Because extras are key/value pairs, here the key is EXTRA_REPLY, and the value is the reply:*/
        replyIntent.putExtra(EXTRA_REPLY,reply);


        /*Set the result to RESULT_OK to indicate that the response was successful. The Activity class defines the result codes, including RESULT_OK and RESULT_CANCELLED.*/
        setResult(RESULT_OK,replyIntent);

        /*Call finish() to close the Activity and return to MainActivity*/
        finish();
    }

}