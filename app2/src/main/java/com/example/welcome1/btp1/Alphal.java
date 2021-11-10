package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphal);
        Button l1,l2;
        ImageButton b2,b6;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.belt);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.old);
        final MediaPlayer L1=MediaPlayer.create(this,R.raw.l1);
        l1=(Button)this.findViewById(R.id.button14);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.start();
            }
        });
        final MediaPlayer L2=MediaPlayer.create(this,R.raw.l2);
        l2=(Button)this.findViewById(R.id.button15);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L2.start();
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
