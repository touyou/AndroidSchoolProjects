package com.dev.touyou.count;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView subTextView;
    TextView sumTextView;
    int number;
    int subnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        subTextView = (TextView) findViewById(R.id.textView2);
        sumTextView = (TextView) findViewById(R.id.textView3);

        number = 0;
        subnumber = 0;
    }

    public void add(View v) {
        number += 1;
        textView.setText(number + "回ボタンが押されました！");
    }

    public void minus(View v) {
        number -= 1;
        textView.setText(number + "回ボタンが押されました！");
    }

    public void add2(View v) {
        subnumber += 1;
        subTextView.setText(subnumber + "回ボタンが押されました！");
    }

    public void sum(View v) {
        sumTextView.setText("合計の値は" + (number + subnumber) + "です！");
    }
}
