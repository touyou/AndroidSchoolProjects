package com.dev.touyou.flashcardplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Card> mCards;
    CardAdapter mCardAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mCards = new ArrayList<Card>();

        mCards.add(new Card(R.drawable.fire, getString(R.string.fire_name), getString(R.string.fire_content), getString(R.string.fire_meaning)));
        mCards.add(new Card(R.drawable.myu, getString(R.string.myu_name), getString(R.string.myu_content), getString(R.string.myu_meaning)));
        mCards.add(new Card(R.drawable.myutwo, getString(R.string.myutwo_name), getString(R.string.myutwo_content), getString(R.string.myutwo_meaning)));
        mCards.add(new Card(R.drawable.thunder, getString(R.string.thunder_name), getString(R.string.thunder_content), getString(R.string.thunder_meaning)));
        mCards.add(new Card(R.drawable.polygon, getString(R.string.polygon_name), getString(R.string.polygon_content), getString(R.string.polygon_meaning)));

        mCardAdapter = new CardAdapter(this, R.layout.card, mCards);
        mListView.setAdapter(mCardAdapter);
        Log.d("D", "load done");
    }
}
