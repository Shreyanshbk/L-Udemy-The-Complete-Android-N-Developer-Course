package com.example.skakadiya.currencyconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clicker(View v) {
        EditText money = (EditText) findViewById(R.id.money);
        Double d = Double.parseDouble(money.getText().toString()) * 70;
        String s = Double.toString(d);
        Toast.makeText(MainActivity.this, "₹ " + String.format("%.2f" , d).toString() , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
