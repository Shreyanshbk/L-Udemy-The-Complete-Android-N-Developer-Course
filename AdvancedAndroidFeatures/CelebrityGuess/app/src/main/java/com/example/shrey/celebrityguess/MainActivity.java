package com.example.shrey.celebrityguess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> imageLoc, celebName;
    int imageIterator = 0;
    ImageView imageView;
    int buttonNumber;
    Button b1,b2,b3,b4;

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... address) {
            URL imageUrl;
            HttpURLConnection imageConnection;

            try {
                imageUrl = new URL(address[0]);
                imageConnection = (HttpURLConnection) imageUrl.openConnection();
                imageConnection.connect();
                InputStream in = imageConnection.getInputStream();
                Bitmap myImage = BitmapFactory.decodeStream(in);
                return myImage;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    public int randomGenerator(int max, int min, int exception){
        Random r = new Random();
        int randomNum = r.nextInt(max-min+1) + min;
        while(randomNum == exception){
            randomNum = r.nextInt(max-min+1) + min;
        }
        return randomNum;
    }

    public void viewSetter() {
        ImageDownloader imgtask = new ImageDownloader();
        try {
            Bitmap theImage = imgtask.execute(imageLoc.get(imageIterator)).get();
            imageView.setImageBitmap(theImage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        buttonNumber = randomGenerator(4, 1, buttonNumber);

        int random1 = randomGenerator(imageLoc.size()-1, 0, imageIterator);
        int random2 = randomGenerator(imageLoc.size()-1, 0, imageIterator);
        int random3 = randomGenerator(imageLoc.size()-1, 0, imageIterator);



        if (buttonNumber == 1 ){
            b1.setText(celebName.get(imageIterator));
            b2.setText(celebName.get(random1));
            b3.setText(celebName.get(random2));
            b4.setText(celebName.get(random3));
        }
        else if (buttonNumber == 2){
            b2.setText(celebName.get(imageIterator));
            b1.setText(celebName.get(random1));
            b3.setText(celebName.get(random2));
            b4.setText(celebName.get(random3));
        }
        else if (buttonNumber == 3){
            b3.setText(celebName.get(imageIterator));
            b1.setText(celebName.get(random1));
            b2.setText(celebName.get(random2));
            b4.setText(celebName.get(random3));
        }
        else if (buttonNumber == 4){
            b4.setText(celebName.get(imageIterator));
            b1.setText(celebName.get(random1));
            b3.setText(celebName.get(random2));
            b2.setText(celebName.get(random3));
        }


        imageIterator++;

    }

    public void click(View v){
        int right = Integer.parseInt(String.valueOf(v.getTag()));
        if (right == buttonNumber){
            Toast.makeText(getApplicationContext(), "Correct!!", Toast.LENGTH_SHORT).show();
        }
        else{
            String s = celebName.get(imageIterator - 1);
            Toast.makeText(getApplicationContext(), "Whoops!!Missed. The correct Name is " + s, Toast.LENGTH_SHORT).show();
        }
        viewSetter();
    }

    public class HtmlDownloader extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    result += (char) data;
                    data = reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);

        HtmlDownloader task = new HtmlDownloader();
        String html = "";
        try {
            html = task.execute("http://www.posh24.com/celebrities").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        imageLoc = new ArrayList<String>();
        celebName = new ArrayList<String>();
        Pattern p = Pattern.compile("src=\"(.*?)\" alt=\"(.*?)\"/>");
        Matcher m = p.matcher(html);
        while (m.find()) {
            imageLoc.add(m.group(1));
            celebName.add(m.group(2));
        }


        viewSetter();

    }
}
