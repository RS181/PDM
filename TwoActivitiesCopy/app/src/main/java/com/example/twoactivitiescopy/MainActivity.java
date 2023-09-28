package com.example.twoactivitiescopy;


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
            "com.example.android.twoactivitiescopy.extra.MESSAGE";

    /*private variable at the top of the class to hold the EditText*/
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log the start of the onCreate() method.
        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG, "onCreate");

        // Initialize all the view variables.
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null){    // the first time we call the app , the bundle is null
            //get the current visibility (true or false) out of the Bundle with the key "reply_visible".
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");

            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible){
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }


    }

    /*See the diagram in the following lin for context about the following methods*/
    //https://developer.android.com/codelabs/android-training-activity-lifecycle-and-state?index=..%2F..%2Fandroid-training#0


    /*onStart() -> what happens when we start this activity*/
    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    /*onPause() -> what happens when we pause an activity (exemple leave or have it "pinned")*/
    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    /*onRestart() -> what happens when u restart the app,after its benn stopped */
    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    /*onResume() -> what happens after you start or after u pause the activity and its resumed*/
    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    /*onStop() -> what happens when you stop an activity (pinned,leave to another activity ,etc...)*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    /*onDestroy() -> what happens when you completly leave the activity*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_text",mReplyTextView.getText().toString());
        }
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
        startActivityForResult(intent, TEXT_REQUEST);


    }
}