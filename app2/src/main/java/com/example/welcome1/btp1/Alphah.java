package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphah);
        Button h1;
        ImageButton b2;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.hot);
        final MediaPlayer H1=MediaPlayer.create(this,R.raw.h1);
        h1=(Button)this.findViewById(R.id.button10);
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H1.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2.start();
            }
        });

    }
}
