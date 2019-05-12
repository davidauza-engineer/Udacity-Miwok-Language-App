package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
        words.add(new Word(getString(R.string.phrases_en_where_are_you_going),
                getString(R.string.phrases_mi_where_are_you_going),
                R.raw.phrase_where_are_you_going));
        words.add(new Word(getString(R.string.phrases_en_what_is_your_name),
                getString(R.string.phrases_mi_what_is_your_name),
                R.raw.phrase_what_is_your_name));
        words.add(new Word(getString(R.string.phrases_en_my_name_is),
                getString(R.string.phrases_mi_my_name_is),
                R.raw.phrase_my_name_is));
        words.add(new Word(getString(R.string.phrases_en_how_are_you_feeling),
                getString(R.string.phrases_mi_how_are_you_feeling),
                R.raw.phrase_how_are_you_feeling));
        words.add(new Word(getString(R.string.phrases_en_I_am_feeling_good),
                getString(R.string.phrases_mi_I_am_feeling_good),
                R.raw.phrase_im_feeling_good));
        words.add(new Word(getString(R.string.phrases_en_are_you_coming),
                getString(R.string.phrases_mi_are_you_coming),
                R.raw.phrase_are_you_coming));
        words.add(new Word(getString(R.string.phrases_en_yes_I_am_coming),
                getString(R.string.phrases_mi_yes_I_am_coming),
                R.raw.phrase_yes_im_coming));
        words.add(new Word(getString(R.string.phrases_en_I_am_coming),
                getString(R.string.phrases_mi_I_am_coming),
                R.raw.phrase_im_coming));
        words.add(new Word(getString(R.string.phrases_en_let_is_go),
                getString(R.string.phrases_mi_let_is_go),
                R.raw.phrase_lets_go));
        words.add(new Word(getString(R.string.phrases_en_come_here),
                getString(R.string.phrases_mi_come_here),
                R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The adapter
        // knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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

                Log.v("PhrasesActivity", "Current word: " + word);

                // Release the media player if it currently exists because we are about to play a
                // different sound file.
                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource associated with
                // the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,
                        word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the media
                // player once the sounds has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
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