package com.example.shrey.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void tabledisplay(int a){
        ListView listView = (ListView) findViewById(R.id.tables);
        ArrayList<Integer> table = new ArrayList<>();
        for (int i = 0 ; i < 20; i++ ){
            table.add(a*(1+i));
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,table);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabledisplay(1);


        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(19);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = seekBar.getProgress();
                tabledisplay(value+1);
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
