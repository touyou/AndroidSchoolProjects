package com.dev.touyou.janken;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView playerImageView;
    ImageView cpuImageView;
    TextView resultTextView;
    TextView textView;

    Random r;

    int number;
    int win;
    int lose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerImageView = (ImageView) findViewById(R.id.player);
        cpuImageView = (ImageView) findViewById(R.id.cpu);
        resultTextView = (TextView) findViewById(R.id.result);
        textView = (TextView) findViewById(R.id.textView);

        r = new Random();
        win = 0;
        lose = 0;
    }

    public void rock(View v) {
        playerImageView.setImageResource(R.drawable.rock);
        number = r.nextInt(3);
        cpu();
        result(0);
    }

    public void scissors(View v) {
        playerImageView.setImageResource(R.drawable.scissors);
        number = r.nextInt(3);
        cpu();
        result(1);
    }

    public void paper(View v) {
        playerImageView.setImageResource(R.drawable.paper);
        number = r.nextInt(3);
        cpu();
        result(2);
    }

    void cpu() {
        switch (number) {
            case 0:
                cpuImageView.setImageResource(R.drawable.rock);
                break;
            case 1:
                cpuImageView.setImageResource(R.drawable.scissors);
                break;
            case 2:
                cpuImageView.setImageResource(R.drawable.paper);
                break;
            default:
                break;
        }
    }

    void result(int p) {
        if (p == number) {
            resultTextView.setText("引き分けです。");
            resultTextView.setTextColor(Color.rgb(0,0,0));
        } else if ((p + 1) % 3 == number) {
            resultTextView.setText("あなたの勝ちです！");
            resultTextView.setTextColor(Color.rgb(255,0,0));
            win += 1;
        } else {
            resultTextView.setText("あなたの負けです...");
            resultTextView.setTextColor(Color.rgb(0,0,255));
            lose += 1;
        }
        textView.setText(win+"勝"+lose+"敗");
    }
}
