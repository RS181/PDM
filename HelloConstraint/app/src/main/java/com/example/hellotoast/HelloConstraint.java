package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HelloConstraint extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
            if (mCount != 0){
                Button b = (Button) findViewById(R.id.zero);
                 b.setBackgroundColor(Color.parseColor("#8A8A8A"));
            }

            if (mCount % 2 == 0)
                view.setBackgroundColor(Color.parseColor("#1658DC"));
            else
                view.setBackgroundColor(Color.parseColor("#0FFF50"));
        }
    }

    public void toZero(View view) {
        mCount = 0;
        mShowCount.setText(Integer.toString(mCount));
        view.setBackgroundColor(Color.parseColor("#FFC0CB"));
    }
}