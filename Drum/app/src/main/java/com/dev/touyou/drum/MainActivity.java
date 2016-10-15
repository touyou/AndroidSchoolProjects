package com.dev.touyou.drum;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool mSoundPool;

    private int[] mSoundID;
    private int[] mSoundResource = {
            R.raw.cymbal1,
            R.raw.cymbal2,
            R.raw.cymbal3,
            R.raw.tom1,
            R.raw.tom2,
            R.raw.tom3,
            R.raw.hihat,
            R.raw.snare,
            R.raw.bass
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mSoundPool = new SoundPool(mSoundResource.length, AudioManager.STREAM_MUSIC, 0);
        mSoundID = new int[mSoundResource.length];

        for (int i=0; i<mSoundResource.length; i++) {
            mSoundID[i] = mSoundPool.load(getApplicationContext(), mSoundResource[i], 0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mSoundPool.release();
    }

    public void cymbal1(View v) {
        playSound(0);
    }

    public void cymbal2(View v) {
        playSound(1);
    }

    public void cymbal3(View v) {
        playSound(2);
    }

    public void tom1(View v) {
        playSound(3);
    }

    public void tom2(View v) {
        playSound(4);
    }

    public void tom3(View v) {
        playSound(5);
    }

    public void hihat(View v) {
        playSound(6);
    }

    public void snare(View v) {
        playSound(7);
    }

    public void bass(View v) {
        playSound(8);
    }

    private void playSound(int i) {
        mSoundPool.play(mSoundID[i], 1.0F, 1.0F, 0, 0, 1.0F);
    }
}
