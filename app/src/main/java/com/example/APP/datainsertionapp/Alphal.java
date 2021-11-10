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

public class Alphal extends AppCompatActivity {
    Button l1,l2;
    ImageButton b2,b6;
    private Bitmap bitmap;
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphal);
        final MyTask myTask = new MyTask();
        l1=(Button)this.findViewById(R.id.button14);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/l1.m4a");
                mediaPlayer.start();
            }
        });
        l2=(Button)this.findViewById(R.id.button15);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/l2.m4a");
                mediaPlayer.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton7);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/belt.png");
        b2.setImageBitmap(bitmap);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/belt.mp3");
                mediaPlayer.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton8);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/old.jpg");
        b6.setImageBitmap(bitmap);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/old.mp3");
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
