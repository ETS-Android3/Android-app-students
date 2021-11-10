package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b1,b3,b4,b5;
        ImageButton b2,b6,b7,b8;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphau);
        final MediaPlayer A1=MediaPlayer.create(this,R.raw.u1);
        final MediaPlayer A3=MediaPlayer.create(this,R.raw.u2);
        final MediaPlayer A4=MediaPlayer.create(this,R.raw.u3);
        final MediaPlayer A5=MediaPlayer.create(this,R.raw.u4);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.cube);
        final MediaPlayer A7=MediaPlayer.create(this,R.raw.square);
        final MediaPlayer A8=MediaPlayer.create(this,R.raw.glue);
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.drum);
        b1=(Button)this.findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A1.start();
            }
        });
        b3=(Button)this.findViewById(R.id.button6);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A3.start();
            }
        });
        b4=(Button)this.findViewById(R.id.button7);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A4.start();
            }
        });
        b5=(Button)this.findViewById(R.id.button8);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A5.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton15);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A6.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2.start();
            }
        });
        b7=(ImageButton)this.findViewById(R.id.imageButton20);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A7.start();
            }
        });
        b8=(ImageButton)this.findViewById(R.id.imageButton19);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A8.start();
            }
        });
    }


    }
