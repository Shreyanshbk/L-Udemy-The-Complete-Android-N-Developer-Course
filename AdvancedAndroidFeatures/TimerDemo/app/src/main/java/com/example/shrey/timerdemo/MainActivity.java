package com.example.shrey.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("Look the millisec", String.valueOf(millisUntilFinished/1000));
            }

            public void onFinish(){
                Log.i("haha", "Finished");
            }

        }.start();

        /*

        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                // Code to run in every second
                handler.postDelayed(this, 1000);
                Log.i("Hi run runned", "Great a second");
            }
        };
        handler.post(run);

        */
    }
}
