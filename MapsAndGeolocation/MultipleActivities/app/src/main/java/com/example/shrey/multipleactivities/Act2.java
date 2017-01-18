package com.example.shrey.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Act2 extends AppCompatActivity {


    public void back(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        Intent intent = getIntent();
        String s = intent.getStringExtra("username");
        Toast.makeText(this, "Hi, " + s, Toast.LENGTH_SHORT).show();
    }
}
