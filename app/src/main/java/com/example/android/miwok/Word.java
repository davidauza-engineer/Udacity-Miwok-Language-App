package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;

    /**
     * Create a new Word object.
     *
     * @param pDefaultTranslation is the word in a language that the user is already familiar with
     *                            (such as English)
     * @param pMiwokTranslation   is the word in the Miwok language
     */
    public Word(String pDefaultTranslation, String pMiwokTranslation) {
        mDefaultTranslation = pDefaultTranslation;
        mMiwokTranslation = pMiwokTranslation;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
}
