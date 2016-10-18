package com.dev.touyou.memopad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExplainActivity extends AppCompatActivity {

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);

        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("key_tutorial", true);
        editor.commit();
    }
}
