package com.example.welcome1.btp1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alphab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b1;
        ImageButton b2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphab);
        final MediaPlayer A1=MediaPlayer.create(this,R.raw.b1);
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.baby);
        b1=(Button)this.findViewById(R.id.button10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A1.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2.start();
            }
        });
    }
}
