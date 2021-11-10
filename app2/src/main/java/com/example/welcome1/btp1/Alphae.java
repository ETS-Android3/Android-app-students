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

public class Alphae extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button e1,e2;
        ImageButton b2,b6;
        final MediaPlayer A2=MediaPlayer.create(this,R.raw.ear);
        final MediaPlayer A6=MediaPlayer.create(this,R.raw.leg);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphae);
        final MediaPlayer E1=MediaPlayer.create(this,R.raw.e1);
        e1=(Button)this.findViewById(R.id.button14);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                E1.start();
            }
        });
        final MediaPlayer E2=MediaPlayer.create(this,R.raw.e2);
        e2=(Button)this.findViewById(R.id.button15);
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                E2.start();
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
