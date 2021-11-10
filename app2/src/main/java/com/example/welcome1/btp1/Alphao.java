package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphao);
        Button c1,c2,c3,c4,c5,c6;
        ImageButton b2,b6,b7,b8,b9,b10;
        final MediaPlayer C1=MediaPlayer.create(this,R.raw.o1);
        final MediaPlayer C2=MediaPlayer.create(this,R.raw.o2);
        final MediaPlayer C3=MediaPlayer.create(this,R.raw.o3);
        final MediaPlayer C4=MediaPlayer.create(this,R.raw.o4);
        final MediaPlayer C5=MediaPlayer.create(this,R.raw.o5);
        final MediaPlayer C6=MediaPlayer.create(this,R.raw.o6);
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.boat);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.pot);
        final MediaPlayer A7=MediaPlayer.create(this,R.raw.apron);
        final MediaPlayer A8=MediaPlayer.create(this,R.raw.frog);
        final MediaPlayer A9=MediaPlayer.create(this,R.raw.goose);
        final MediaPlayer A10=MediaPlayer.create(this,R.raw.hook);
        c1=(Button)this.findViewById(R.id.button16);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C1.start();
            }
        });
        c2=(Button)this.findViewById(R.id.button17);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C2.start();
            }
        });
        c3=(Button)this.findViewById(R.id.button18);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C3.start();
            }
        });
        c4=(Button)this.findViewById(R.id.button19);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C4.start();
            }
        });
        c5=(Button)this.findViewById(R.id.button20);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C5.start();
            }
        });
        c6=(Button)this.findViewById(R.id.button22);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C6.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton10);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton9);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A6.start();
            }
        });
        b7=(ImageButton)this.findViewById(R.id.imageButton12);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A7.start();
            }
        });
        b8=(ImageButton)this.findViewById(R.id.imageButton11);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A8.start();
            }
        });
        b9=(ImageButton)this.findViewById(R.id.imageButton6);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A9.start();
            }
        });
        b10=(ImageButton)this.findViewById(R.id.imageButton13);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A10.start();
            }
        });
    }

}
