package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.phrases_en_where_are_you_going),
                getString(R.string.phrases_mi_where_are_you_going)));
        words.add(new Word(getString(R.string.phrases_en_what_is_your_name),
                getString(R.string.phrases_mi_what_is_your_name)));
        words.add(new Word(getString(R.string.phrases_en_my_name_is),
                getString(R.string.phrases_mi_my_name_is)));
        words.add(new Word(getString(R.string.phrases_en_how_are_you_feeling),
                getString(R.string.phrases_mi_how_are_you_feeling)));
        words.add(new Word(getString(R.string.phrases_en_I_am_feeling_good),
                getString(R.string.phrases_mi_I_am_feeling_good)));
        words.add(new Word(getString(R.string.phrases_en_are_you_coming),
                getString(R.string.phrases_mi_are_you_coming)));
        words.add(new Word(getString(R.string.phrases_en_yes_I_am_coming),
                getString(R.string.phrases_mi_yes_I_am_coming)));
        words.add(new Word(getString(R.string.phrases_en_I_am_coming),
                getString(R.string.phrases_mi_I_am_coming)));
        words.add(new Word(getString(R.string.phrases_en_let_is_go),
                getString(R.string.phrases_mi_let_is_go)));
        words.add(new Word(getString(R.string.phrases_en_come_here),
                getString(R.string.phrases_mi_come_here)));

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