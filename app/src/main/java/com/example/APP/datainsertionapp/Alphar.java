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

public class Alphar extends AppCompatActivity {

    private Button b1,b2,b3;
    private ImageButton c1,c2,c3;
    private Bitmap bitmap;
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphac);
        final MyTask myTask = new MyTask();
        b1=findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/r1.m4a");
                mediaPlayer.start();
            }
        });
        b2=findViewById(R.id.button21);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/r2.m4a");
                mediaPlayer.start();
            }
        });
        b3=findViewById(R.id.button23);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/r3.m4a");
                mediaPlayer.start();
            }
        });
        c1=findViewById(R.id.imageButton21);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/barn.jpg");
        c1.setImageBitmap(bitmap);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/barn.mp3");
                mediaPlayer.start();
            }
        });
        c2=findViewById(R.id.imageButton22);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/red.png");
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/red.mp3");
                mediaPlayer.start();
            }
        });
        c2.setImageBitmap(bitmap);
        c3=findViewById(R.id.imageButton23);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/ear.png");
        c3.setImageBitmap(bitmap);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/ear.mp3");
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
