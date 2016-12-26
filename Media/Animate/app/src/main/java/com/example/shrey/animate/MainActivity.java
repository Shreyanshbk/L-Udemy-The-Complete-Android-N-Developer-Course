package com.example.shrey.animate;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View v){

        /*
        A major thing I learnt is that all the methods of animations are automatically merged though written on different lines.
         */
        ImageView img = (ImageView) findViewById(R.id.img);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        img2.setClickable(false);
        img2.animate().alpha(0f).setDuration(2000);
        img.animate().translationXBy(2000f).setDuration(2000);
        img.animate().rotation(180f).setDuration(2000);
        img.animate().scaleX(0.5f).setDuration(2000);
        img.animate().rotation(180f).setDuration(2000);
        img.animate().scaleY(0.5f).setDuration(1000);
        img.animate().rotation(360f).scaleY(1f).scaleX(1f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setTranslationX(-2000f);
    }
}
