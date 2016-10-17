package com.dev.touyou.pittaritime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void button(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("minutes", 10);
        startActivity(intent);
    }

    public void button2(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("minutes", 5);
        startActivity(intent);
    }

    public void button3(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("minutes", 20);
        startActivity(intent);
    }
}
