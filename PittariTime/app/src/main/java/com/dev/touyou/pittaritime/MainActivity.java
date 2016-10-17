package com.dev.touyou.pittaritime;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView mTimeTextView;
    TextView mResultTextView;

    Timer mTimer;
    Handler mHandler;

    int mTime;
    int mDefaultTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeTextView = (TextView) findViewById(R.id.textView);
        mResultTextView = (TextView) findViewById(R.id.textView2);

        mHandler = new Handler();

        Intent intent = getIntent();
        mDefaultTime = intent.getIntExtra("minutes", 0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void start(View v) {
        if (mTimer == null) {
            Toast.makeText(this, mDefaultTime+"秒を当ててね！", Toast.LENGTH_SHORT).show();
            mTime = mDefaultTime;
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
    }

    public void stop(View v) {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            if (mTime == 0) {
                mTimeTextView.setText(String.valueOf(mTime));
                mResultTextView.setText("おめでとう！");
            } else {
                mTimeTextView.setText(String.valueOf(mTime));
                mResultTextView.setText("残念");
            }
        }

    }
}
