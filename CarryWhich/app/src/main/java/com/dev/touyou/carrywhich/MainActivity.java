package com.dev.touyou.carrywhich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView pokeTextView;
    TextView verbTextView;

    String name;
    String[] names = {"フシギダネ", "ヒトカゲ", "ゼニガメ", "ピカチュウ"};
    String[] pokemon = {"モンスターボール", "スーパーボール", "ハイパーボール", "最初のポケモン"};
    String[] result = {"捕まえた！", "逃げられた..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        pokeTextView = (TextView) findViewById(R.id.pokemonTextView);
        verbTextView = (TextView) findViewById(R.id.verbTextView);
    }

    public void runPoke(View v) {
        Random randomName = new Random();
        int index = randomName.nextInt(4);
        name = names[index];
        nameTextView.setText(name + "を");

        Random randomBall = new Random();
        pokeTextView.setText(pokemon[randomBall.nextInt(4)] + "で");

        Random random = new Random();
        int res = random.nextInt(2);
        verbTextView.setText(result[res]);
        if (res == 1) {
            verbTextView.setTextSize((float) 30.0);
        } else {
            verbTextView.setTextSize((float) 20.0);
        }
    }
}
