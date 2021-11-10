package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Alphac extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphac);
        final MediaPlayer A1=(MediaPlayer)MediaPlayer.create(this,R.raw.c1);
        final MediaPlayer A2=(MediaPlayer)MediaPlayer.create(this,R.raw.c2);
        final MediaPlayer A3=(MediaPlayer)MediaPlayer.create(this,R.raw.c3);
        final MediaPlayer A4=(MediaPlayer)MediaPlayer.create(this,R.raw.ceiling);
        final MediaPlayer A5=(MediaPlayer)MediaPlayer.create(this,R.raw.cow);
        final MediaPlayer A6=(MediaPlayer)MediaPlayer.create(this,R.raw.duck);
       Button b1,b2,b3;
       ImageButton c1,c2,c3;
       b1=findViewById(R.id.button9);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               A1.start();
           }
       });
        b2=findViewById(R.id.button21);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2.start();
            }
        });
        b3=findViewById(R.id.button23);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A3.start();
            }
        });
        c1=findViewById(R.id.imageButton21);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A4.start();
            }
        });
        c2=findViewById(R.id.imageButton22);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A5.start();
            }
        });

        c3=findViewById(R.id.imageButton23);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A6.start();
            }
        });


    }
}
