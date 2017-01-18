package com.example.shrey.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listact);

        ListView lst = (ListView) findViewById(R.id.lst);
        final ArrayList<String> friends = new ArrayList<>();

        friends.add("Hardik");
        friends.add("Ashok");
        friends.add("Mayank");
        friends.add("Akshay");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, friends);
        lst.setAdapter(arrayAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Act2.class);
                intent.putExtra("username", friends.get(position));
                startActivity(intent);
            }
        });
    }
}
