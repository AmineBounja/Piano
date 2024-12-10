package com.example.piano;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Button> btns = new ArrayList<>();
    private ArrayList<MediaPlayer> media = new ArrayList<>();
    static int target = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media.add(MediaPlayer.create(this, R.raw.do_sound));
        media.add(MediaPlayer.create(this, R.raw.re));
        media.add(MediaPlayer.create(this, R.raw.mi));
        media.add(MediaPlayer.create(this, R.raw.fa));
        media.add(MediaPlayer.create(this, R.raw.sol));
        media.add(MediaPlayer.create(this, R.raw.la));
        media.add(MediaPlayer.create(this, R.raw.si));

        btns.add(findViewById(R.id.a));
        btns.add(findViewById(R.id.b));
        btns.add(findViewById(R.id.c));
        btns.add(findViewById(R.id.d));
        btns.add(findViewById(R.id.e));
        btns.add(findViewById(R.id.f));
        btns.add(findViewById(R.id.g));

        for (int i = 0; i < media.size(); i++) {
            final int index = i;
            btns.get(i).setOnClickListener(v -> {

                if (media.get(target).isPlaying()) {
                    media.get(target).pause();
                    media.get(target).seekTo(0);
                }

                target = index;
                media.get(target).start();


            });
        }
    }

}
