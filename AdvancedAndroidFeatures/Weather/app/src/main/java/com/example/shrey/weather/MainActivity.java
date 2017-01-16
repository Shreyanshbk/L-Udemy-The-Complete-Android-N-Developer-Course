package com.example.shrey.weather;

import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.spec.ECField;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView textView;
    public class Downloader extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection;
            try{
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
                System.out.println("hguybjkl;?");
                //Toast.makeText(getApplicationContext(), "No Weather", Toast.LENGTH_SHORT).show();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String printable = "";
            try {
                JSONObject jsonObject = new JSONObject(s);
                String weatherforecast = jsonObject.getString("weather");
                JSONArray arr = new JSONArray(weatherforecast);
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);
                    printable += jsonPart.getString("main") + ":";
                    printable += jsonPart.getString("description") + "   ";
                }
                Log.i("hgchgh", printable);
                if (printable != "") {
                    textView.setText(printable);
                    textView.setBackgroundColor(0xFFFF0000);
                }
                else{
                    Toast.makeText(getApplicationContext(), "No Weather", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "No weather", Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void click (View v){
        String location = editText.getText().toString();
        try {
            location = URLEncoder.encode(location, "UTF-8");
            String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid=ed5ad400abb804e3dbad90e4935c16e1";
            Log.i("U R L : ", url);
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            Downloader task = new Downloader();
            task.execute(url);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "NO weather", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
    }

}
