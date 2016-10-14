package com.dev.touyou.primequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int QUESTION_COUNT = 10;

    TextView textView;

    Random random = new Random();

    int[] questions;
    int point;
    int answerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        questions = new int[QUESTION_COUNT];

        for (int i=0; i<QUESTION_COUNT; i++) {
            int number = random.nextInt(1000);
            Log.d("Number", "Question" + number);
            questions[i] = number;
        }

        point = 0;
        answerCount = 0;

        textView.setText(questions[answerCount] + "");
    }

    public void ok(View v) {
        if (isPrime(questions[answerCount])) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();
            point++;
        } else {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();
        }
        answerCount++;
        if (answerCount == QUESTION_COUNT) {
            textView.setText(point + "点");

            point = 0;
            answerCount = 0;
            return;
        }
        textView.setText(String.valueOf(questions[answerCount]));
    }

    public void no(View v) {
        if (!isPrime(questions[answerCount])) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();
            point++;
        } else {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();
        }
        answerCount++;
        if (answerCount == QUESTION_COUNT) {
            textView.setText(point + "点");

            point = 0;
            answerCount = 0;
            return;
        }
        textView.setText(String.valueOf(questions[answerCount]));
    }

    boolean isPrime(int number) {
        for (int i=2; i<(number+1)/2; i++) {
            if (number % i == 0) {
                Log.d("False", i+"で割り切れた");
                return false;
            }
        }
        return true;
    }
}
