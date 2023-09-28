package com.example.activitylyfecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private int mcount = 0 ;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount  = (TextView) findViewById(R.id.showCount);

        //Restore the State
        if (savedInstanceState != null){

            mcount = savedInstanceState.getInt("Count");
            mShowCount.setText(String.valueOf(mcount));
        }
    }

    public void IncreaseCount(View view) {
        //Log.d(LOG_TAG,"->" + String.valueOf(mcount));
        mcount++;
        if (mShowCount != null){
            mShowCount.setText(String.valueOf(mcount));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("Count",mcount);
    }
}