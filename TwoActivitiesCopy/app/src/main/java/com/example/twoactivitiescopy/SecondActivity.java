package com.example.twoactivitiescopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //variable that holds the EditText
    private EditText mReply;

    //Key for the Intent extra
    public static  final String  EXTRA_REPLY =
            "com.example.android.twoactivitiescopy.extra.REPLY";

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

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
        Log.d(LOG_TAG,"---------");
        Log.d(LOG_TAG,"onCreate Second");

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

        Log.d(LOG_TAG, "End SeconActivity");

        /*Call finish() to close the Activity and return to MainActivity*/
        finish();
    }

    /*Activity life cycle*/

    /*onStart() -> what happens when we start this activity*/
    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart Second");
    }

    /*onPause() -> what happens when we pause an activity (exemple leave or have it "pinned")*/
    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause Second");
    }

    /*onRestart() -> what happens when u restart the app,after its benn stopped */
    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart Second");
    }

    /*onResume() -> what happens after you start or after u pause the activity and its resumed*/
    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume Second");
    }

    /*onStop() -> what happens when you stop an activity (pinned,leave to another activity ,etc...)*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop Second");
    }

    /*onDestroy() -> what happens when you completly leave the activity*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy Second");
    }

}