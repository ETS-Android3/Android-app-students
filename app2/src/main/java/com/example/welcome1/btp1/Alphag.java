package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphag);
        Button g1,g2,g3;
        ImageButton b2,b6,b7;
        final MediaPlayer G1=MediaPlayer.create(this,R.raw.g1);
        final MediaPlayer G2=MediaPlayer.create(this,R.raw.g2);
        final MediaPlayer G3=MediaPlayer.create(this,R.raw.g3);
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.genie);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.big);
        final MediaPlayer A7=MediaPlayer.create(this,R.raw.eight);
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
