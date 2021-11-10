package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphax extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button d1,d2;
        ImageButton b2,b6;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.exit);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.axe);
        setContentView(R.layout.activity_alphax);
        final MediaPlayer D1=MediaPlayer.create(this,R.raw.x1);
        d1=(Button)this.findViewById(R.id.button14);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D1.start();
            }
        });
        final MediaPlayer D2=MediaPlayer.create(this,R.raw.x2);
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
