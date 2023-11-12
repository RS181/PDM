package com.example.testconnectionrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //ver slides lab4
    private class SendAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                return sendGet(params[0]);
            } catch (Exception e) {
                Log.e("TESTE", "Error in AsyncTask: " + e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // Handle the result here
            if (result != null) {
                Log.d("TESTE", "Response: " + result);

                // todo: Do something with the response


            } else {
                Log.e("TESTE", "Error: Unable to get response");
            }
        }
    }


    //dado um url manda um get (e retorna uma string)
    public static String  sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");


        int responseCode = con.getResponseCode();
        Log.d("TESTE","Sending 'GET' request to URL : " + url);
        Log.d("TESTE","Response Code : " + responseCode);

        //lé o conteudo da resposta
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString(); //here is your response which is in string type, but remember that the format is json.

    }


    //função que começa um get (com url dado)
    //todo : colocar um url
    public void startGet(View view) throws Exception {
        Log.d("TESTE" , "Click");
//        String s = sendGet("http://35.195.14.2/movie/all");
        new SendAsyncTask().execute("http://35.195.14.2/movie/all");
    }
}