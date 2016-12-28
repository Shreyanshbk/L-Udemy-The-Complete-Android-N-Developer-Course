package com.example.shrey.gameconnect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    boolean flag = false;
    int[] a = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void reset(){
        ImageView b = (ImageView) findViewById(R.id.i1);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i2);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i3);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i4);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i5);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i6);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i7);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i8);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        b = (ImageView) findViewById(R.id.i9);
        b.setClickable(true);
        b.setImageResource(R.drawable.pad);

        for(int i = 0; i<a.length; i++){
            a[i] = -1;
        }

    }

    public void makeToast(String s){
        Toast.makeText(MainActivity.this, s + " Wins!! Let's Play Again", Toast.LENGTH_SHORT).show();
        reset();
    }

    public boolean checkWin(){

        Log.i("Cuurent Array Status : " ,  Arrays.toString(a));
        if (a[0] == 1){
            if (a[1] == 1 && a[2] == 1){
                return true;
            }
            if (a[3] == 1 && a[6] ==1 ){
                return true;
            }
            if (a[4] == 1 && a[8] == 1){
                return true;
            }
        }
        if(a[0] == 0){
            if (a[1] == 0 && a[2] == 0){
                return true;
            }
            if (a[3] == 0 && a[6] ==0 ){
                return true;
            }
            if (a[4] == 0 && a[8] == 0){
                return true;
            }
        }
        if(a[1] == 1){
            if (a[4] == 1 && a[7] == 1){
                return true;
            }
        }
        if(a[1] == 0) {
            if (a[4] == 0 && a[7] == 0){
                return true;
            }
        }
        if(a[2] == 1){
            if (a[4] == 1 && a[6] == 1){
                return true;
            }
            if(a[5] == 1 && a[8] == 1){
                return true;
            }
        }
        if(a[2] == 0){
            if (a[4] == 0 && a[6] == 0){
                return true;
            }
            if(a[5] == 0 && a[8] == 0){
                return true;
            }
        }
        if (a[3] == 1){
            if (a[4] == 1 && a[5] == 1) {
                return true;
            }
        }
        if (a[3] == 0){
            if (a[4] == 0 && a[5] == 0) {
                return true;
            }
        }
        if(a[6] == 1 ){
            if (a[4] == 1 && a[2] == 1){
                return true;
            }
            if (a[7] == 1 && a[8] == 1){
                return true;
            }
        }
        if(a[6] == 0 ){
            if (a[4] == 0 && a[2] == 0){
                return true;
            }
            if (a[7] == 0 && a[8] == 0){
                return true;
            }
        }
        return false;
    }


    public void f1(View v){
        ImageView i1 = (ImageView) findViewById(R.id.i1);
        i1.setClickable(false);
        if (flag){
            i1.setImageResource(R.drawable.yellow);
            a[0] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }

        }
        else{
            i1.setImageResource(R.drawable.reb);
            a[0] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f2(View v){
        ImageView i2 = (ImageView) findViewById(R.id.i2);
        i2.setClickable(false);
        if (flag){
            i2.setImageResource(R.drawable.yellow);
            a[1] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }

        }
        else{
            i2.setImageResource(R.drawable.reb);
            a[1] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f3(View v){
        ImageView i3 = (ImageView) findViewById(R.id.i3);
        i3.setClickable(false);
        if (flag){
            i3.setImageResource(R.drawable.yellow);
            a[2] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }

        }
        else{
            i3.setImageResource(R.drawable.reb);
            a[2] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f4(View v){
        ImageView i4 = (ImageView) findViewById(R.id.i4);
        i4.setClickable(false);
        if (flag){
            i4.setImageResource(R.drawable.yellow);
            a[3] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }

        }
        else{
            i4.setImageResource(R.drawable.reb);
            a[3] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f5(View v){
        ImageView i5 = (ImageView) findViewById(R.id.i5);
        i5.setClickable(false);
        if (flag){
            i5.setImageResource(R.drawable.yellow);
            a[4] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }

        }
        else{
            i5.setImageResource(R.drawable.reb);
            a[4] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f6(View v){
        ImageView i6 = (ImageView) findViewById(R.id.i6);
        i6.setClickable(false);
        if (flag){
            i6.setImageResource(R.drawable.yellow);
            a[5] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }
        }
        else{
            i6.setImageResource(R.drawable.reb);
            a[5] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f7(View v){
        ImageView i7 = (ImageView) findViewById(R.id.i7);
        i7.setClickable(false);
        if (flag){
            i7.setImageResource(R.drawable.yellow);
            a[6] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }
        }
        else{
            i7.setImageResource(R.drawable.reb);
            a[6] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f8(View v){
        ImageView i8 = (ImageView) findViewById(R.id.i8);
        i8.setClickable(false);
        if (flag){
            i8.setImageResource(R.drawable.yellow);
            a[7] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }
        }
        else{
            i8.setImageResource(R.drawable.reb);
            a[7] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }

    public void f9(View v){
        ImageView i9 = (ImageView) findViewById(R.id.i9);
        i9.setClickable(false);
        if (flag){
            i9.setImageResource(R.drawable.yellow);
            a[8] = 1;
            flag = false;
            if(checkWin()){
                makeToast("Yellow");
            }
        }
        else{
            i9.setImageResource(R.drawable.reb);
            a[8] = 0;
            flag = true;
            if(checkWin()){
                makeToast("Red");
            }
        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
