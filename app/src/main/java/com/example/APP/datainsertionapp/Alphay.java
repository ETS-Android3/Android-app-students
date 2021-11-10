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

public class Alphay extends AppCompatActivity {
    private Button i1,i2,i3,i4,i5;
    private ImageButton b2,b6,b7,b8,b9;
    private Bitmap bitmap;
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphai);
        final MyTask myTask = new MyTask();
        i1=(Button)this.findViewById(R.id.button16);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/y1.m4a");
                mediaPlayer.start();
            }
        });
        i2=(Button)this.findViewById(R.id.button17);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/y2.m4a");
                mediaPlayer.start();
            }
        });
        i3=(Button)this.findViewById(R.id.button18);
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/y3.m4a");
                mediaPlayer.start();
            }
        });
        i4=(Button)this.findViewById(R.id.button19);
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/y4.m4a");
                mediaPlayer.start();
            }
        });
        i5=(Button)this.findViewById(R.id.button20);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/y5.m4a");
                mediaPlayer.start();
            }
        });
        b2=(ImageButton)this.findViewById(R.id.imageButton10);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/lion2.jpg");
        b2.setImageBitmap(bitmap);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/lion.mp3");
                mediaPlayer.start();
            }
        });
        b6=(ImageButton)this.findViewById(R.id.imageButton9);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/army.png");
        b6.setImageBitmap(bitmap);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/army.mp3");
                mediaPlayer.start();
            }
        });
        b7=(ImageButton)this.findViewById(R.id.imageButton12);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/yard.jpg");
        b7.setImageBitmap(bitmap);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/yard.mp3");
                mediaPlayer.start();
            }
        });
        b8=(ImageButton)this.findViewById(R.id.imageButton11);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/bicycle.jpg");
        b8.setImageBitmap(bitmap);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/bicycle.mp3");
                mediaPlayer.start();
            }
        });
        b9=(ImageButton)this.findViewById(R.id.imageButton13);
        bitmap=getBitmapFromURL("http://192.168.43.223/drawable/fly.png");
        b9.setImageBitmap(bitmap);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer=null;
                }
                mediaPlayer=myTask.doInBackground("http://192.168.43.223/raw/fly.mp3");
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
