package com.example.checkboxes_and_etc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CheckBox> itens_selecionados;

    /*Variaveil que contem todas as checkbox's*/
    private CheckBox chocolate ;
    private CheckBox sprinkles;
    private CheckBox crusted;
    private CheckBox cherries;
    private CheckBox orio;

    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Atribuimos as variaves globais da classe a respetiva view
        chocolate = (CheckBox)findViewById(R.id.chocolate_checkbox);
        sprinkles = (CheckBox)findViewById(R.id.Sprinkles_checkbox);
        crusted = (CheckBox)findViewById(R.id.Crusted_nuts_checkbox);
        cherries = (CheckBox)findViewById(R.id.Cherries_checkbox);
        orio = (CheckBox)findViewById(R.id.Orio_cookie_crumbles_checkbox);

    }

    public void showToast(View view) {

        //Mensangens debug
        Log.d("D","checked chocolate = " + chocolate.isChecked());
        Log.d("D","checked sprinkles = " + sprinkles.isChecked());
        Log.d("D","checked crusted = " + crusted.isChecked());
        Log.d("D","checked cherries = " + cherries.isChecked());
        Log.d("D","checked orio = " + orio.isChecked());

        //Inicializamos o arraylist
        itens_selecionados = new ArrayList<>();

        //Adicionamos todos os Checkbox a um arraylist
        itens_selecionados.add(chocolate);
        itens_selecionados.add(sprinkles);
        itens_selecionados.add(crusted);
        itens_selecionados.add(cherries);
        itens_selecionados.add(orio);


        //Inicializamos a mensagem
        message = "";
        for (CheckBox c  :  itens_selecionados){
            if (c.isChecked())
                message += c.getText().toString() + " ";
        }

        displayToast(message);

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}