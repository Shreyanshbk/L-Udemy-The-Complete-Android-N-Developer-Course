package com.example.shrey.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.demovideo);
        MediaController mC = new MediaController(this);
        mC.setAnchorView(vv);
        vv.setMediaController(mC);
        vv.start();
    }
}
