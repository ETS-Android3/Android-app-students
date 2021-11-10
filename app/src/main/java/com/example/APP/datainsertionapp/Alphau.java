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

public class Alphau extends AppCompatActivity {
    Button b1,b3,b4,b5;
    ImageButton b2,b6,b7,b8;
    private Bitmap bitmap;
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphau);
        final MyTask myTask = new MyTask();
        b1=(Button)this.findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/u1.m4a");
                mediaPlayer.start();
            }
        });
        b3=(Button)this.findViewById(R.id.button6);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/u2.m4a");
                mediaPlayer.start();
            }
        });
        b4=(Button)this.findViewById(R.id.button7);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/u3.m4a");
                mediaPlayer.start();
            }
        });
        b5=(Button)this.findViewById(R.id.button8);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/u4.m4a");
                mediaPlayer.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton15);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/cube.jpg");
        b2.setImageBitmap(bitmap);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/cube.mp3");
                mediaPlayer.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/square.png");
        b6.setImageBitmap(bitmap);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/square.mp3");
                mediaPlayer.start();
            }
        });
        b7=(ImageButton)this.findViewById(R.id.imageButton20);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/glue.jpg");
        b7.setImageBitmap(bitmap);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/glue.mp3");
                mediaPlayer.start();
            }
        });
        b8=(ImageButton)this.findViewById(R.id.imageButton19);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/drum.png");
        b8.setImageBitmap(bitmap);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/drum.mp3");
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
