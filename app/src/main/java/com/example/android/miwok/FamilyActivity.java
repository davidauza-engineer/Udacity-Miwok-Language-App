package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.family_en_father),
                getString(R.string.family_mi_father),
                R.drawable.family_father,
                R.raw.family_father));
        words.add(new Word(getString(R.string.family_en_mother),
                getString(R.string.family_mi_mother),
                R.drawable.family_mother,
                R.raw.family_mother));
        words.add(new Word(getString(R.string.family_en_son),
                getString(R.string.family_mi_son),
                R.drawable.family_son,
                R.raw.family_son));
        words.add(new Word(getString(R.string.family_en_daughter),
                getString(R.string.family_mi_daughter),
                R.drawable.family_daughter,
                R.raw.family_daughter));
        words.add(new Word(getString(R.string.family_en_older_brother),
                getString(R.string.family_mi_older_brother),
                R.drawable.family_older_brother,
                R.raw.family_older_brother));
        words.add(new Word(getString(R.string.family_en_younger_brother),
                getString(R.string.family_mi_younger_brother),
                R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        words.add(new Word(getString(R.string.family_en_older_sister),
                getString(R.string.family_mi_older_sister),
                R.drawable.family_older_sister,
                R.raw.family_older_sister));
        words.add(new Word(getString(R.string.family_en_younger_sister),
                getString(R.string.family_mi_younger_sister),
                R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        words.add(new Word(getString(R.string.family_en_grandmother),
                getString(R.string.family_mi_grandmother),
                R.drawable.family_grandmother,
                R.raw.family_grandmother));
        words.add(new Word(getString(R.string.family_en_grandfather),
                getString(R.string.family_mi_grandfather),
                R.drawable.family_grandfather,
                R.raw.family_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The adapter
        // knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}. There
        // should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated with
                // the current word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,
                        word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}