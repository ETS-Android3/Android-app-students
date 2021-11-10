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

public class Alphad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button d1,d2;
        ImageButton b2,b6;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphad);
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.candy);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.dog);
        final MediaPlayer D1=MediaPlayer.create(this,R.raw.d1);
        d1=(Button)this.findViewById(R.id.button14);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D1.start();
            }
        });
        final MediaPlayer D2=MediaPlayer.create(this,R.raw.d2);
        d2=(Button)this.findViewById(R.id.button15);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D2.start();
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
