package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing the audio
     * file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.colors_en_red),
                getString(R.string.colors_mi_red),
                R.drawable.color_red,
                R.raw.color_red));
        words.add(new Word(getString(R.string.colors_en_green),
                getString(R.string.colors_mi_green),
                R.drawable.color_green,
                R.raw.color_green));
        words.add(new Word(getString(R.string.colors_en_brown),
                getString(R.string.colors_mi_brown),
                R.drawable.color_brown,
                R.raw.color_brown));
        words.add(new Word(getString(R.string.colors_en_gray),
                getString(R.string.colors_mi_gray),
                R.drawable.color_gray,
                R.raw.color_gray));
        words.add(new Word(getString(R.string.colors_en_black),
                getString(R.string.colors_mi_black),
                R.drawable.color_black,
                R.raw.color_black));
        words.add(new Word(getString(R.string.colors_en_white),
                getString(R.string.colors_mi_white),
                R.drawable.color_white,
                R.raw.color_white));
        words.add(new Word(getString(R.string.colors_en_dusty_yellow),
                getString(R.string.colors_mi_dusty_yellow),
                R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow));
        words.add(new Word(getString(R.string.colors_en_mustard_yellow),
                getString(R.string.colors_mi_mustard_yellow),
                R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The adapter
        // knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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

                Log.v("ColorsActivity", "Current word: " + word);

                // Release the media player if it currently exists because we are about to play a
                // different sound file.
                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource associated with
                // the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,
                        word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the media
                // player once the sounds has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        // When the activity is stopped, release the media player resources because we won't be
        // playing any more sounds.
        releaseMediaPlayer();
        super.onStop();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        Log.e("Activity: ", "Media released");
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}