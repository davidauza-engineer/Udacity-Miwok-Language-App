package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.numbers_en_one),
                getString(R.string.numbers_mi_one)));
        words.add(new Word(getString(R.string.numbers_en_two),
                getString(R.string.numbers_mi_two)));
        words.add(new Word(getString(R.string.numbers_en_three),
                getString(R.string.numbers_mi_three)));
        words.add(new Word(getString(R.string.numbers_en_four),
                getString(R.string.numbers_mi_four)));
        words.add(new Word(getString(R.string.numbers_en_five),
                getString(R.string.numbers_mi_five)));
        words.add(new Word(getString(R.string.numbers_en_six),
                getString(R.string.numbers_mi_six)));
        words.add(new Word(getString(R.string.numbers_en_seven),
                getString(R.string.numbers_mi_seven)));
        words.add(new Word(getString(R.string.numbers_en_eight),
                getString(R.string.numbers_mi_eight)));
        words.add(new Word(getString(R.string.numbers_en_nine),
                getString(R.string.numbers_mi_nine)));
        words.add(new Word(getString(R.string.numbers_en_ten),
                getString(R.string.numbers_mi_ten)));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The adapter
        // knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}. There
        // should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
