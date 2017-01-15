package com.example.shrey.jsonplay;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class Downloader extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url ;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data != -1){
                    result += (char) data;
                    data = reader.read();
                }
                return result;
            }

            catch (Exception e){

                e.printStackTrace();

            }

            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(s);
                String weather = jsonObject.getString("weather");
                //Log.i("Data Arrived", weather);
                JSONArray arr = new JSONArray(weather);

                for (int i = 0 ; i< arr.length(); i++){
                    JSONObject jsonPart = arr.getJSONObject(i);
                    Log.i("Main : " , jsonPart.getString("main"));
                    Log.i("Description : ", jsonPart.getString("description"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Downloader task = new Downloader();
        task.execute("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=ed5ad400abb804e3dbad90e4935c16e1");
    }
}
