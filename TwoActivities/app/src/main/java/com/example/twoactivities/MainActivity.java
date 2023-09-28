package com.example.twoactivities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //public constant to define the key for a particular type of response
    public static final int TEXT_REQUEST = 1;

    //variables to hold the reply header and reply TextView elements
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    /*public constant  to define the key for the Intent extra:*/
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    /*private variable at the top of the class to hold the EditText*/
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Using findViewById() to get a reference to the EditText and assign it to that private variable*/
        mMessageEditText = findViewById(R.id.editText_main);

        /*get reply part*/

        // gets the views "necessary" for the display of text
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    /* Explination of onActivityResult
    * requestCode you set when you launched the Activity with startActivityForResult()
    * the resultCode set in the launched Activity (usually one of RESULT_OK or RESULT_CANCELED)
    * Intent data that contains the data returned from the launch Activity
    *  */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                //get the Intent extra from the response Intent (data). Here the key for the extra is the EXTRA_REPLY constant from SecondActivity:
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                //set the visibility of the reply header to true
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                //Set the reply TextView text to the reply, and set its visibility to true:
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }


    /*When you click the Send button, MainActivity sends the Intent and the Android system launches SecondActivity, which appears on the screen.*/
    public void lauchSecondActivity(View view) {

        Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, SecondActivity.class);


        /*get the text from the EditText as a string */
        String message = mMessageEditText.getText().toString();

        /*Add that string to the Intent as an extra with the EXTRA_MESSAGE constant as the key and the string as the value*/
        intent.putExtra(EXTRA_MESSAGE, message);


        //Inicia a atividade "seconactivity"
        //startActivity(intent);
        startActivityForResult(intent,TEXT_REQUEST);


    }
}