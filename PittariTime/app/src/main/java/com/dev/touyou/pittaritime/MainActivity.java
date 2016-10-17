package com.dev.touyou.pittaritime;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView mTimeTextView;
    TextView mResultTextView;

    Timer mTimer;
    Handler mHandler;

    int mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeTextView = (TextView) findViewById(R.id.textView);
        mResultTextView = (TextView) findViewById(R.id.textView2);

        mHandler = new Handler();
    }

    public void start(View v) {
        mTime = 10;

        mTimer = new Timer(false);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTime--;
                        Log.d("timeの数字=", String.valueOf(mTime));
                    }
                });
            }
        }, 0, 1000);
    }

    public void stop(View v) {
        if (mTime == 0) {
            mTimeTextView.setText(String.valueOf(mTime));
            mResultTextView.setText("おめでとう！");
        } else {
            mTimeTextView.setText(String.valueOf(mTime));
            mResultTextView.setText("残念");
        }

    }
}
