package com.example.skakadiya.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void clicker(View view) {
        ImageView imgView = (ImageView) findViewById(R.id.imgView);
        imgView.setImageResource(R.drawable.image2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
