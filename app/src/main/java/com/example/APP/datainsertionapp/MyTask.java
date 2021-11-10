package com.example.rahul.datainsertionapp;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import java.io.IOException;

class MyTask extends AsyncTask<String, Void, MediaPlayer>
{


    MediaPlayer mediaPlayer;




    @Override
    protected MediaPlayer doInBackground(String... strings) {
        String url=strings[0];
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try
        {
            mediaPlayer.setDataSource(url);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }



}
