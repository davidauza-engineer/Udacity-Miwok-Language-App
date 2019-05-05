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
     * Image resource ID for the word
     */
    private int mImageResourceId;

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
     * Create a new Word object.
     *
     * @param pDefaultTranslation is the word in a language that the user is already familiar with
     *                            (such as English)
     * @param pMiwokTranslation   is the word in the Miwok language
     * @param pImageResourceId    is the image resource ID
     */
    public Word(String pDefaultTranslation, String pMiwokTranslation, int pImageResourceId) {
        mDefaultTranslation = pDefaultTranslation;
        mMiwokTranslation = pMiwokTranslation;
        mImageResourceId = pImageResourceId;
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

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
