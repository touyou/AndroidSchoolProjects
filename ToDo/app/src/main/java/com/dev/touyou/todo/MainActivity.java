package com.dev.touyou.todo;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);

        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();

                String item = (String) adapter.getItem(position);
                adapter.remove(item);
                adapter.insert(item, position + 1);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                 ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();

                String item = (String) adapter.getItem(i);
                adapter.remove(item);
                Toast.makeText(getApplicationContext(), item+"を削除しました。", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    public void add(View v) {
        String text;
        text = editText.getText().toString();

        Toast.makeText(this, text+"を追加しました。", Toast.LENGTH_SHORT).show();

        adapter.add(text);

        editText.setText("");
    }
}
