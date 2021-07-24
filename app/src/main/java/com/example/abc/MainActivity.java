package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListner = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Alphabet> Alphabets = new ArrayList<Alphabet>();
        Alphabets.add(new Alphabet(R.drawable.a,R.raw.a));
        Alphabets.add(new Alphabet(R.drawable.b,R.raw.b));
        Alphabets.add(new Alphabet(R.drawable.c,R.raw.c));
        Alphabets.add(new Alphabet(R.drawable.d,R.raw.d));
        Alphabets.add(new Alphabet(R.drawable.e,R.raw.e));
        Alphabets.add(new Alphabet(R.drawable.f,R.raw.f));
        Alphabets.add(new Alphabet(R.drawable.g,R.raw.g));
        Alphabets.add(new Alphabet(R.drawable.h,R.raw.h));
        Alphabets.add(new Alphabet(R.drawable.i,R.raw.i));
        Alphabets.add(new Alphabet(R.drawable.j,R.raw.j));
        Alphabets.add(new Alphabet(R.drawable.k,R.raw.k));
        Alphabets.add(new Alphabet(R.drawable.l,R.raw.l));
        Alphabets.add(new Alphabet(R.drawable.m,R.raw.m));
        Alphabets.add(new Alphabet(R.drawable.n,R.raw.n));
        Alphabets.add(new Alphabet(R.drawable.o,R.raw.o));
        Alphabets.add(new Alphabet(R.drawable.p,R.raw.p));
        Alphabets.add(new Alphabet(R.drawable.q,R.raw.q));
        Alphabets.add(new Alphabet(R.drawable.r,R.raw.r));
        Alphabets.add(new Alphabet(R.drawable.s,R.raw.s));
        Alphabets.add(new Alphabet(R.drawable.t,R.raw.t));
        Alphabets.add(new Alphabet(R.drawable.u,R.raw.u));
        Alphabets.add(new Alphabet(R.drawable.v,R.raw.v));
        Alphabets.add(new Alphabet(R.drawable.w,R.raw.w));
        Alphabets.add(new Alphabet(R.drawable.x,R.raw.x));
        Alphabets.add(new Alphabet(R.drawable.y,R.raw.y));
        Alphabets.add(new Alphabet(R.drawable.z,R.raw.z));

        AlphabetAdapter adapter = new AlphabetAdapter(this,0,Alphabets);
        GridView gridView = (GridView) findViewById(R.id.list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Alphabet alphabet = Alphabets.get(position);
                //Release the media player if it currently exists becouse we are about to play diff sound.
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(MainActivity.this,alphabet.getmAudio());
                mediaPlayer.start();
                //Setup a listener on  the media player, so that we can stop and release the
                //media player once the sounds has been finished playing
                mediaPlayer.setOnCompletionListener(mCompletionListner);
            }
        });
    }
    //Clean up the media player by releasing its resources.
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        // Before going to stop state release the
        // allocated mediaplyer resources
        releaseMediaPlayer();
    }
}