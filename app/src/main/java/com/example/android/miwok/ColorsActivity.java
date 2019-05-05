package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.colors_en_red),
                getString(R.string.colors_mi_red), R.drawable.color_red));
        words.add(new Word(getString(R.string.colors_en_green),
                getString(R.string.colors_mi_green), R.drawable.color_green));
        words.add(new Word(getString(R.string.colors_en_brown),
                getString(R.string.colors_mi_brown), R.drawable.color_brown));
        words.add(new Word(getString(R.string.colors_en_gray),
                getString(R.string.colors_mi_gray), R.drawable.color_gray));
        words.add(new Word(getString(R.string.colors_en_black),
                getString(R.string.colors_mi_black), R.drawable.color_black));
        words.add(new Word(getString(R.string.colors_en_white),
                getString(R.string.colors_mi_white), R.drawable.color_white));
        words.add(new Word(getString(R.string.colors_en_dusty_yellow),
                getString(R.string.colors_mi_dusty_yellow), R.drawable.color_dusty_yellow));
        words.add(new Word(getString(R.string.colors_en_mustard_yellow),
                getString(R.string.colors_mi_mustard_yellow), R.drawable.color_mustard_yellow));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The adapter
        // knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}. There
        // should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}