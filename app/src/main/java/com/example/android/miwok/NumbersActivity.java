package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of words
        ArrayList<String> words = new ArrayList<>();
        words.add(getString(R.string.numbers_one));
        words.add(getString(R.string.numbers_two));
        words.add(getString(R.string.numbers_three));
        words.add(getString(R.string.numbers_four));
        words.add(getString(R.string.numbers_five));
        words.add(getString(R.string.numbers_six));
        words.add(getString(R.string.numbers_seven));
        words.add(getString(R.string.numbers_eight));
        words.add(getString(R.string.numbers_nine));
        words.add(getString(R.string.numbers_ten));

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, R.layout.list_item, words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
