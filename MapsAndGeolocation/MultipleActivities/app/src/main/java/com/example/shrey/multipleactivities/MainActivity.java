package com.example.shrey.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button b1,b2,b3,b4;

    public void newact(View v){
        Intent intent = new Intent(getApplicationContext(), listact.class);
        startActivity(intent);
    }

    public void click(View v){
        String s = "";
        if (v.getTag().toString().equals(Integer.toString(1))){
            s = b1.getText().toString();
        }
        else if (v.getTag().toString().equals(Integer.toString(2))){
            s = b2.getText().toString();
        }
        else if (v.getTag().toString().equals(Integer.toString(4))){
            s = b4.getText().toString();
        }
        else {
            s = b3.getText().toString();
        }
        Log.i("Acticity se, ", s);
        Intent intent = new Intent(getApplicationContext(), Act2.class);
        intent.putExtra("username",s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
    }
}
