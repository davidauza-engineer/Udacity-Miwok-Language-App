package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.family_en_father),
                getString(R.string.family_mi_father)));
        words.add(new Word(getString(R.string.family_en_mother),
                getString(R.string.family_mi_mother)));
        words.add(new Word(getString(R.string.family_en_son),
                getString(R.string.family_mi_son)));
        words.add(new Word(getString(R.string.family_en_daughter),
                getString(R.string.family_mi_daughter)));
        words.add(new Word(getString(R.string.family_en_older_brother),
                getString(R.string.family_mi_older_brother)));
        words.add(new Word(getString(R.string.family_en_younger_brother),
                getString(R.string.family_mi_younger_brother)));
        words.add(new Word(getString(R.string.family_en_older_sister),
                getString(R.string.family_mi_older_sister)));
        words.add(new Word(getString(R.string.family_en_younger_sister),
                getString(R.string.family_mi_younger_sister)));
        words.add(new Word(getString(R.string.family_en_grandmother),
                getString(R.string.family_mi_grandmother)));
        words.add(new Word(getString(R.string.family_en_grandfather),
                getString(R.string.family_mi_grandfather)));

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