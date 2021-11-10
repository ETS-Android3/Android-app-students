package com.example.rahul.datainsertionapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Alphag extends AppCompatActivity {
    private Button g1,g2,g3;
    private ImageButton b2,b6,b7;
    private Bitmap bitmap;
    MediaPlayer mediaPlayer=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphag);
        final MyTask myTask = new MyTask();
        g1=(Button)this.findViewById(R.id.button11);
        g2=(Button)this.findViewById(R.id.button12);
        g3=(Button)this.findViewById(R.id.button13);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/g1.m4a");
                mediaPlayer.start();
            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/g2.m4a");
                mediaPlayer.start();
            }
        });
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/g3.m4a");
                mediaPlayer.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton2);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/genie.jpg");
        b2.setImageBitmap(bitmap);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/genie.mp3");
                mediaPlayer.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton4);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/big.png");
        b6.setImageBitmap(bitmap);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/big.mp3");
                mediaPlayer.start();
            }
        });
        b7=(ImageButton)this.findViewById(R.id.imageButton5);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/eight.jpg");
        b7.setImageBitmap(bitmap);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/eight.mp3");
                mediaPlayer.start();
            }
        });
    }
    public Bitmap getBitmapFromURL(String src)
    {
        try
        {
            URL url=new URL(src);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input =connection.getInputStream();
            Bitmap myBitmap= BitmapFactory.decodeStream(input);
            return myBitmap;

        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
