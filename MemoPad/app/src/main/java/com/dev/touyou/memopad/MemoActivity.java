package com.dev.touyou.memopad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MemoActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText contentEditText;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        titleEditText = (EditText) findViewById(R.id.title);
        contentEditText = (EditText) findViewById(R.id.content);

        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);

        titleEditText.setText(pref.getString("key_title", ""));
        contentEditText.setText(pref.getString("key_content", ""));
    }

    public void save(View v) {
        String titleText = titleEditText.getText().toString();
        String contentText = contentEditText.getText().toString();

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key_title", titleText);
        editor.putString("key_content", contentText);
        editor.commit();

        finish();
    }
}
