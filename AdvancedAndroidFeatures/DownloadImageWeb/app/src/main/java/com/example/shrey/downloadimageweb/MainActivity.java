package com.example.shrey.downloadimageweb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView quoteView;

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                Log.i("Here",urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream in = urlConnection.getInputStream();
                Bitmap myBit = BitmapFactory.decodeStream(in);
                return myBit;

            } catch (Exception e) {

                Log.i("Here","Something in the try didn't work" );
                e.printStackTrace();
            }
            return null;
        }
    }

    public void click(View v){
        //https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwix9ILFgLfRAhWIrFQKHYjADzwQjRwIBw&url=https%3A%2F%2Fwww.pinterest.com%2Fexplore%2Fgood-vibes-quotes%2F&psig=AFQjCNE__UKsFfILXYU1f9rIFDVYGPCd-w&ust=1484117592636265
        ImageDownloader task = new ImageDownloader();
        Bitmap myImage = null;
        try {
            myImage = task.execute("http://vignette2.wikia.nocookie.net/powerlisting/images/7/71/Buddha_Quote_3.jpg/revision/latest?cb=20130417215047").get();
            quoteView.setImageBitmap(myImage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteView = (ImageView) findViewById(R.id.quoteView);
    }
}
