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

public class Alphaa extends AppCompatActivity {
    private Button b1,b3,b4,b5;
    private ImageButton b2,b6,b7,b8;
    private Bitmap bitmap;
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphaa);
        final MyTask myTask = new MyTask();
        b2=(ImageButton)this.findViewById(R.id.imageButton16);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/face.png");
        b2.setImageBitmap(bitmap);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/face.mp3");
                mediaPlayer.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/ant.png");
        b6.setImageBitmap(bitmap);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/ant.mp3");
                mediaPlayer.start();
            }
        });
        b7=(ImageButton)this.findViewById(R.id.imageButton17);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/tea.png");
        b7.setImageBitmap(bitmap);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/tea.mp3");
                mediaPlayer.start();
            }
        });
        b8=(ImageButton)this.findViewById(R.id.imageButton18);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/oval.png");
        b8.setImageBitmap(bitmap);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/oval.mp3");
                mediaPlayer.start();
            }
        });
        b1=(Button)this.findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/a1.m4a");
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
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/a2.m4a");
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
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/a3.m4a");
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
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/a4.m4a");
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
