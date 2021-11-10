package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphav);
        Button j1,j2;
        ImageButton b2,b6;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.movie);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.vet);
        final MediaPlayer J1=MediaPlayer.create(this,R.raw.v1);
        j1=(Button)this.findViewById(R.id.button14);
        j1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                J1.start();
            }
        });
        final MediaPlayer J2=MediaPlayer.create(this,R.raw.v2);
        j2=(Button)this.findViewById(R.id.button15);
        j2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                J2.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton7);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton8);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A6.start();
            }
        });

    }
}
