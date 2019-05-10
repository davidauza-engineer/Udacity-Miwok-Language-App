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
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Audio resource ID for the word
     */
    private int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param pDefaultTranslation is the word in a language that the user is already familiar with
     *                            (such as English)
     * @param pMiwokTranslation   is the word in the Miwok language
     * @param pAudioResourceId    is the resource ID for the audio file associated with this word.
     */
    public Word(String pDefaultTranslation,
                String pMiwokTranslation,
                int pAudioResourceId) {
        mDefaultTranslation = pDefaultTranslation;
        mMiwokTranslation = pMiwokTranslation;
        mAudioResourceId = pAudioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param pDefaultTranslation is the word in a language that the user is already familiar with
     *                            (such as English)
     * @param pMiwokTranslation   is the word in the Miwok language
     * @param pImageResourceId    is the drawable resource ID for the image associated with the word
     * @param pAudioResourceId    is the resource ID for the audio file associated with this word.
     */
    public Word(String pDefaultTranslation,
                String pMiwokTranslation,
                int pImageResourceId,
                int pAudioResourceId) {
        mDefaultTranslation = pDefaultTranslation;
        mMiwokTranslation = pMiwokTranslation;
        mImageResourceId = pImageResourceId;
        mAudioResourceId = pAudioResourceId;
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

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}