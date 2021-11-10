package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphaf extends AppCompatActivity {

    Button f1,f2;
    ImageButton b2,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphaf);
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.chef);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.elf);
        final MediaPlayer F1=MediaPlayer.create(this,R.raw.f1);
        f1=(Button)this.findViewById(R.id.button14);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F1.start();
            }
        });
        final MediaPlayer F2=MediaPlayer.create(this,R.raw.f2);
        f2=(Button)this.findViewById(R.id.button15);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F2.start();
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
