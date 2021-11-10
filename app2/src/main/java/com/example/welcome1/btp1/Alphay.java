package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphay);
        Button i1,i2,i3,i4,i5;
        ImageButton b2,b6,b7,b8,b9;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.lion);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.army);
        final MediaPlayer A7=MediaPlayer.create(this,R.raw.yard);
        final MediaPlayer A8=MediaPlayer.create(this,R.raw.bicycle);
        final MediaPlayer A9=MediaPlayer.create(this,R.raw.fly);
        final MediaPlayer I1=MediaPlayer.create(this,R.raw.y1);
        final MediaPlayer I2=MediaPlayer.create(this,R.raw.y2);
        final MediaPlayer I3=MediaPlayer.create(this,R.raw.y3);
        final MediaPlayer I4 =MediaPlayer.create(this,R.raw.y4);
        final MediaPlayer I5=MediaPlayer.create(this,R.raw.y5);
        i1=(Button)this.findViewById(R.id.button16);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I1.start();
            }
        });
        i2=(Button)this.findViewById(R.id.button17);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I2.start();
            }
        });
        i3=(Button)this.findViewById(R.id.button18);
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I3.start();
            }
        });
        i4=(Button)this.findViewById(R.id.button19);
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I4.start();
            }
        });
        i5=(Button)this.findViewById(R.id.button20);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I5.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton10);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A6.start();
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
        b9=(ImageButton)this.findViewById(R.id.imageButton13);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A9.start();
            }
        });
    }
}
