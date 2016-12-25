package com.example.shrey.numbershape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void makeToast(String s){
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    public boolean isTriangular(int n){
        if (n == 1){
            return true;
        }
        int start = 1;
        int counter = 2;
        while(n > start){
            start = start + counter;
            counter++ ;
            if (start == n ){
                return true;
            }
        }
        return false; 
    }

    public boolean isSquare(int n){
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n){
            return true;
        }
        else{
            return false;
        }
    }

    public void clicker(View v){
        EditText num = (EditText) findViewById(R.id.num);
        int number = Integer.parseInt(num.getText().toString());
        String s = "";
        boolean f1 = isTriangular(number);
        boolean f2 = isSquare(number);
        if (f1 && f2){
            makeToast("Both");
        }
        else if (f1){
            makeToast("Triangular");
        }
        else if(f2){
            makeToast("Square");
        }
        else{
            makeToast("None");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
