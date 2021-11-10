package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button k1,k2;
        ImageButton b2,b6;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.skating);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.desk);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphak);
        final MediaPlayer K1=MediaPlayer.create(this,R.raw.k1);
        k1=(Button)this.findViewById(R.id.button14);
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                K1.start();
            }
        });
        final MediaPlayer K2=MediaPlayer.create(this,R.raw.k2);
        k2=(Button)this.findViewById(R.id.button15);
        k2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                K2.start();
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
