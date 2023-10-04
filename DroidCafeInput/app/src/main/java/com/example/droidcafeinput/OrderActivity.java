package com.example.droidcafeinput;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.res.Resources;
public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Create the spinner

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.

        int current_id = view.getId();  //saves de int associated with the current view

        //Create the id constants for each radiobutton
        final int same_day_id = R.id.sameday;
        final int next_day_id = R.id.nextday;
        final int pick_up_id = R.id.pickup;

        //Instead of switch case , i did if and else
        if (current_id == same_day_id){
            //Same day service
            displayToast(getString(R.string.same_day_messenger_service));
            return;
        }
        else if (current_id == next_day_id){
            //Next day delivery
            displayToast(getString(R.string.next_day_ground_delivery));
            return;
        }
        else if (current_id == pick_up_id){
            //Pick up
            displayToast(getString(R.string.pick_up));
            return;
        }
    }


    /*<?> is a Java type wildcard, enabling the method to be flexible enough to accept any type of AdapterView as an argument*/
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Not used in this case
    }


}