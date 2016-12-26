package com.example.shrey.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View v){
        ImageView imgView = (ImageView) findViewById(R.id.imgView);
        imgView.animate().alpha(0f).setDuration(2000);
        ImageView imgView2 = (ImageView) findViewById(R.id.imgView2);
        imgView2.animate().alpha(1f).setDuration(2000);
        imgView2.setClickable(true);
        imgView.setClickable(false);
    }


    public void fade2(View v){
        ImageView imgView = (ImageView) findViewById(R.id.imgView);
        imgView.animate().alpha(1f).setDuration(2000);
        ImageView imgView2 = (ImageView) findViewById(R.id.imgView2);
        imgView2.animate().alpha(0f).setDuration(2000);
        imgView.setClickable(true);
        imgView2.setClickable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
