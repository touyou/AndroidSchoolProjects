package com.dev.touyou.flashcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Word[] pokemon = {
            new Word(R.drawable.freeza, "フリーザー"),
            new Word(R.drawable.fire, "ファイヤ"),
            new Word(R.drawable.hakuryu, "ハクリュウ"),
            new Word(R.drawable.kairyu, "カイリュウ"),
            new Word(R.drawable.miniryu, "ミニリュウ"),
            new Word(R.drawable.myu, "ミュウ"),
            new Word(R.drawable.myutwo, "ミュウツー"),
            new Word(R.drawable.thunder, "サンダー")
    };

    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);

        for (int i = 0; i < pokemon.length; i++) {
            addWord(pokemon[i]);
        }
    }

    public void addWord(Word word) {
        LinearLayout layout = new LinearLayout(this.getApplicationContext());
        layout.setOrientation(LinearLayout.HORIZONTAL);

        TextView nameTextView = new TextView(this);
        nameTextView.setText(word.name);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(word.resID);

        layout.addView(imageView);
        layout.addView(nameTextView);

        container.addView(layout);
    }
}
