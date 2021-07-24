package com.example.abc;

public class Alphabet {
    private Integer mImageOfAlphabet;
    private int mAudio;

    public Alphabet(Integer imageOfAlphabet, int audio) {
        this.mImageOfAlphabet = imageOfAlphabet;
        this.mAudio = audio;
    }

    public Integer getmImageOfAlphabet() {
        return mImageOfAlphabet;
    }

    public int getmAudio() {
        return mAudio;
    }
}
