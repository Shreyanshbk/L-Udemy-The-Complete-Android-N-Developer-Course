package com.example.shrey.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, start;
    TextView timer, score, question, result;
    int scoreCount = 0;
    int questionCount = 0;
    int correctTag = 2;

    public int randomNumberGenerator(int max, int min, int exception){
        Random r = new Random();
        int random = r.nextInt((max - min)+1) + min;
        if(random == exception){
            return randomNumberGenerator(max, min, exception);
        }
        else{
            return random;
        }
    }

    public void reset(){
        start.setText("Great!! Your Score is " + Integer.toString(scoreCount) + " / " + Integer.toString(questionCount) + "\n Let's Play Again");
        start.setVisibility(start.VISIBLE);
        b1.setVisibility(b1.INVISIBLE);
        b2.setVisibility(b2.INVISIBLE);
        b3.setVisibility(b3.INVISIBLE);
        b4.setVisibility(b4.INVISIBLE);
        timer.setVisibility(timer.INVISIBLE);
        score.setVisibility(score.INVISIBLE);
        question.setVisibility(question.INVISIBLE);
        score.setText("--/--");
        scoreCount = 0;
        questionCount = 0;
        result.setVisibility(result.INVISIBLE);
    }

    public void newQuestionGenerator(){
        int a = randomNumberGenerator(100, 0, 0);
        int b = randomNumberGenerator(100, 0, 0);
        String Q = Integer.toString(a) + " + " + Integer.toString(b);
        question.setText(Q);
        correctTag = randomNumberGenerator(4, 1, correctTag);
        if (correctTag == 1){
            b1.setText(Integer.toString(a+b));
            b2.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b3.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b4.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
        }
        if (correctTag == 2){
            b2.setText(Integer.toString(a+b));
            b1.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b3.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b4.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
        }
        if (correctTag == 3){
            b3.setText(Integer.toString(a+b));
            b2.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b1.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b4.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
        }
        if (correctTag == 4){
            b4.setText(Integer.toString(a+b));
            b2.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b3.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
            b1.setText(Integer.toString(randomNumberGenerator(200, 100, a+b)));
        }

    }

    public void click(View v){
        String tag =(String) v.getTag();
        Log.i("Current Button ", tag);
        questionCount++;
        if (Integer.parseInt(tag) == correctTag) {
            scoreCount++;
            result.setText("BRAVO!!");
        }
        else{
            result.setText("OOPS!! Missed.");
        }
        newQuestionGenerator();
        score.setText(Integer.toString(scoreCount) + "/" + Integer.toString(questionCount));

    }

    public void starter(View v){
        start.setVisibility(v.INVISIBLE);
        b1.setVisibility(v.VISIBLE);
        b2.setVisibility(v.VISIBLE);
        b3.setVisibility(v.VISIBLE);
        b4.setVisibility(v.VISIBLE);
        timer.setVisibility(v.VISIBLE);
        score.setVisibility(v.VISIBLE);
        question.setVisibility(v.VISIBLE);
        result.setVisibility(v.VISIBLE);

        new CountDownTimer(30000 +100, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                timer.setText("0s");
                reset();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        timer = (TextView) findViewById(R.id.timer);
        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);
        start = (Button) findViewById(R.id.start);
        result = (TextView) findViewById(R.id.result);


    }
}
