package com.example.shrey.gridlayoutdemo;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void clicked(View v){
        int id = v.getId();
        String ourId = v.getResources().getResourceEntryName(id);
        int resourceId = getResources().getIdentifier(ourId, "raw", getPackageName());
        MediaPlayer mp = MediaPlayer.create(this, resourceId);

        mp.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
