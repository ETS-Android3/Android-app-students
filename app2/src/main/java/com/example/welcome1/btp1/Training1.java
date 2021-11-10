package com.example.welcome1.btp1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.os.Build.*;
import static android.os.Build.VERSION.*;

@TargetApi(VERSION_CODES.LOLLIPOP)
@RequiresApi(api = VERSION_CODES.LOLLIPOP)
public class Training1 extends AppCompatActivity{
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    SoundPool soundPool;
    int num;
    private int sound1,sound2,sound3,sound4,sound5,sound6,sound7,sound8,sound9,sound10,sound11,sound12,sound13,sound14,sound15,sound16,sound17,sound18,sound19,sound20,sound21,sound22,sound23,sound24,sound25,sound26;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training1);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            AudioAttributes audioAttributes=new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
            soundPool = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(audioAttributes).build();
        }
        else {
            soundPool = new SoundPool( 1,AudioManager.STREAM_MUSIC,0);
        }
        sound1= soundPool.load(this,R.raw.sound1,1);
        sound2= soundPool.load(this,R.raw.sound2,1);
        sound3= soundPool.load(this,R.raw.sound3,1);
        sound4= soundPool.load(this,R.raw.sound4,1);
        sound5= soundPool.load(this,R.raw.sound5,1);
        sound6= soundPool.load(this,R.raw.sound6,1);
        sound7= soundPool.load(this,R.raw.sound7,1);
        sound8= soundPool.load(this,R.raw.sound8,1);
        sound9= soundPool.load(this,R.raw.sound9,1);
        sound10= soundPool.load(this,R.raw.sound10,1);
        sound11= soundPool.load(this,R.raw.sound11,1);
        sound12= soundPool.load(this,R.raw.sound12,1);
        sound13= soundPool.load(this,R.raw.sound13,1);
        sound14= soundPool.load(this,R.raw.sound14,1);
        sound15= soundPool.load(this,R.raw.sound15,1);
        sound16= soundPool.load(this,R.raw.sound16,1);
        sound17= soundPool.load(this,R.raw.sound17,1);
        sound18 = soundPool.load(this,R.raw.sound18,1);
        sound19= soundPool.load(this,R.raw.sound19,1);
        sound20= soundPool.load(this,R.raw.sound20,1);
        sound21= soundPool.load(this,R.raw.sound21,1);
        sound22= soundPool.load(this,R.raw.sound22,1);
        sound23= soundPool.load(this,R.raw.sound23,1);
        sound24= soundPool.load(this,R.raw.sound24,1);
        sound25= soundPool.load(this,R.raw.sound25,1);
        sound26= soundPool.load(this,R.raw.sound26,1);

        }
    public void playSound(View view)
    {
        num=viewPager.getCurrentItem();         //int num= ImageAdapter.pos();
        //int num=parseInt(et);
        switch(num){
            case 0:
                soundPool.play(sound1,1,1,0,0,1 );
                break;
            case 1:
                soundPool.play(sound2,1,1,0,0,1 );
                break;
            case 2:
                soundPool.play(sound3,1,1,0,0,1 );
                break;
            case 3:
                soundPool.play(sound4,1,1,0,0,1 );
                break;
            case 4:
                soundPool.play(sound5,1,1,0,0,1 );
                break;
            case 5:
                soundPool.play(sound6,1,1,0,0,1 );
                break;
            case 6:
                soundPool.play(sound7,1,1,0,0,1 );
                break;
            case 7:
                soundPool.play(sound8,1,1,0,0,1 );
                break;
            case 8:
                soundPool.play(sound9,1,1,0,0,1 );
                break;
            case 9:
                soundPool.play(sound10,1,1,0,0,1 );
                break;
            case 10:
                soundPool.play(sound11,1,1,0,0,1 );
                break;
            case 11:
                soundPool.play(sound12,1,1,0,0,1 );
                break;
            case 12:
                soundPool.play(sound13,1,1,0,0,1 );
                break;
            case 13:
                soundPool.play(sound14,1,1,0,0,1 );
                break;
            case 14:
                soundPool.play(sound15,1,1,0,0,1 );
                break;
            case 15:
                soundPool.play(sound16,1,1,0,0,1 );
                break;
            case 16:
                soundPool.play(sound17,1,1,0,0,1 );
                break;
            case 17:
                soundPool.play(sound18,1,1,0,0,1 );
                break;
            case 18:
                soundPool.play(sound19,1,1,0,0,1 );
                break;
            case 19:
                soundPool.play(sound20,1,1,0,0,1 );
                break;
            case 20:
                soundPool.play(sound21,1,1,0,0,1 );
                break;
            case 21:
                soundPool.play(sound22,1,1,0,0,1 );
                break;
            case 22:
                soundPool.play(sound23,1,1,0,0,1 );
                break;
            case 23:
                soundPool.play(sound24,1,1,0,0,1 );
                break;
            case 24:
                soundPool.play(sound25,1,1,0,0,1 );
                break;
            case 25:
                soundPool.play(sound26,1,0,0,1,1 );
                break;
        }
    }
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool=null;

    }
}






