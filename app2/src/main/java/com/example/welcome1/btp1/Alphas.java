package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphas);
        Button g1,g2,g3;
        ImageButton b2,b6,b7;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.vest);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.bus);
        final MediaPlayer A7=MediaPlayer.create(this,R.raw.nose);
        final MediaPlayer G1=MediaPlayer.create(this,R.raw.s1);
        final MediaPlayer G2=MediaPlayer.create(this,R.raw.s2);
        final MediaPlayer G3=MediaPlayer.create(this,R.raw.s3);
        g1=(Button)this.findViewById(R.id.button11);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G1.start();
            }
        });
        g2=(Button)this.findViewById(R.id.button12);
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G2.start();
            }
        });
        g3=(Button)this.findViewById(R.id.button13);
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G3.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton4);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A6.start();
            }
        });
        b7=(ImageButton)this.findViewById(R.id.imageButton5);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A7.start();
            }
        });
    }
}
