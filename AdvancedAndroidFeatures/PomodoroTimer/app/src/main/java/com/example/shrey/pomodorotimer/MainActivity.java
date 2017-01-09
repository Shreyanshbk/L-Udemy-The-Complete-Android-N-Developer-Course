package com.example.shrey.pomodorotimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    Button button;
    MediaPlayer mp;
    CountDownTimer timer;
    String originalTime = "00:00";
    boolean goClick = true;
    public String timerShow(long millis){

        int seconds = (int) (millis/ 1000) % 60 ;
        int minutes = (int) ((millis / (1000*60)) % 60);
        String s;
        boolean flagsec = false, flagmin = false;
        if (seconds / 10 == 0){
            flagsec = true;
        }
        if(minutes / 10 == 0){
            flagmin = true;
        }
        if(flagmin && flagsec){
            s = "0" + Integer.toString(minutes) + ":" + "0" +Integer.toString(seconds);
        }
        else if(flagmin){
            s = "0" + Integer.toString(minutes) + ":" + Integer.toString(seconds);
        }
        else if(flagsec){
            s = Integer.toString(minutes) + ":" + "0" +Integer.toString(seconds);
        }
        else{
            s = Integer.toString(minutes) + ":" + Integer.toString(seconds);
        }
        //textView.setText(s);
        return s;
    }

    public void click(View v){
        if (goClick){
            goClick = false;
            button.setText("STOP");
            seekBar.setEnabled(false);
            int progress = seekBar.getProgress();
            timer = new CountDownTimer(progress, 1000){

                @Override
                public void onTick(long millisUntilFinished) {
                    Log.i("ksdbk",String.valueOf(millisUntilFinished));
                    String s = timerShow(millisUntilFinished);
                    Log.i("Time", s);
                    textView.setText(s);
                }

                @Override
                public void onFinish() {
                    mp.start();
                }
            }.start();
        }
        else{
            goClick = true;
            button.setText("Go");
            seekBar.setEnabled(true);
            timer.cancel();
            textView.setText(originalTime);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(originalTime);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(1500000);
        button = (Button) findViewById(R.id.button);
        mp = MediaPlayer.create(this, R.raw.air);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                originalTime = timerShow(progress);
                textView.setText(originalTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
