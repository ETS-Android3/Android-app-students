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

public class Alphaa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphaa);
        final MediaPlayer A1=MediaPlayer.create(this,R.raw.a1);
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.ant);
        final MediaPlayer A3=MediaPlayer.create(this,R.raw.a2);
        final MediaPlayer A4=MediaPlayer.create(this,R.raw.a3);
        final MediaPlayer A5=MediaPlayer.create(this,R.raw.a4);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.face);
        final MediaPlayer A7=MediaPlayer.create(this,R.raw.tea);
        final MediaPlayer A8=MediaPlayer.create(this,R.raw.oval);

        Button b1,b3,b4,b5;
        ImageButton b2,b6,b7,b8;
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
        b2=(ImageButton)this.findViewById(R.id.imageButton16);
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
        b7=(ImageButton)this.findViewById(R.id.imageButton17);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A7.start();
            }
        });
        b8=(ImageButton)this.findViewById(R.id.imageButton18);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A8.start();
            }
        });
    }

}
