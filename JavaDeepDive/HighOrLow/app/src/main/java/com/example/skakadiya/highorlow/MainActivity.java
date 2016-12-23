package com.example.skakadiya.highorlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int random ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumbergenerator();
    }

    private void randomNumbergenerator() {
        Random rand = new Random();
        random = rand.nextInt(20) + 1 ;
    }

    public void makeToast(String s){
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    public void clicker(View view){
        EditText num =  (EditText) findViewById(R.id.num);
        int number = Integer.parseInt(num.getText().toString());
        if (number == random){
            makeToast("Perfect!! Let's Play again");
            randomNumbergenerator();
        }
        else if(number > random){
            makeToast("Go a little Lower");
        }
        else{
            makeToast("Go a little Higher");
        }
        num.setText("");
    }
}
