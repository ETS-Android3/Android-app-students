package com.example.rahul.datainsertionapp;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    RequestQueue rq;
    List<SliderUtils> sliderImg;

    String request_url = "http://192.168.43.223/getimage.php";
    String url1="http://192.168.43.223/sound1.mp3";
    String url2="http://192.168.43.223/sound2.mp3";
    String url3="http://192.168.43.223/sound3.mp3";
    String url4="http://192.168.43.223/sound4.mp3";
    String url5="http://192.168.43.223/sound5.mp3";
    String url6="http://192.168.43.223/sound6.mp3";
    String url7="http://192.168.43.223/sound7.mp3";
    String url8="http://192.168.43.223/sound8.mp3";
    String url9="http://192.168.43.223/sound9.mp3";
    String url10="http://192.168.43.223/sound10.mp3";
    String url11="http://192.168.43.223/sound11.mp3";
    String url12="http://192.168.43.223/sound12.mp3";
    String url13="http://192.168.43.223/sound13.mp3";
    String url14="http://192.168.43.223/sound14.mp3";
    String url15="http://192.168.43.223/sound15.mp3";
    String url16="http://192.168.43.223/sound16.mp3";
    String url17="http://192.168.43.223/sound17.mp3";
    String url18="http://192.168.43.223/sound18.mp3";
    String url19="http://192.168.43.223/sound19.mp3";
    String url20="http://192.168.43.223/sound20.mp3";
    String url21="http://192.168.43.223/sound21.mp3";
    String url22="http://192.168.43.223/sound22.mp3";
    String url23="http://192.168.43.223/sound23.mp3";
    String url24="http://192.168.43.223/sound24.mp3";
    String url25="http://192.168.43.223/sound25.mp3";
    String url26="http://192.168.43.223/sound26.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(this);
        sliderImg = new ArrayList<>();


        viewPager = findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        sendRequest();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);


    }

    public void play(View view) {
        MediaPlayer mediaPlayer=null;
        int x=viewPager.getCurrentItem();
        MyTask myTask = new MyTask();
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer=null;
        }
            switch(x)
        {
            case 0:
                mediaPlayer=myTask.doInBackground(url1);
                break;
            case 1:
                mediaPlayer=myTask.doInBackground(url2);
                break;
            case 2:
                mediaPlayer=myTask.doInBackground(url3);
                break;
            case 3:
                mediaPlayer=myTask.doInBackground(url4);
                break;
            case 4:
                mediaPlayer=myTask.doInBackground(url5);
                break;
            case 5:
                mediaPlayer=myTask.doInBackground(url6);
                break;
            case 6:
                mediaPlayer=myTask.doInBackground(url7);
                break;
            case 7:
                mediaPlayer=myTask.doInBackground(url8);
                break;
            case 8:
                mediaPlayer=myTask.doInBackground(url9);
                break;
            case 9:
                mediaPlayer=myTask.doInBackground(url10);
                break;
            case 10:
                mediaPlayer=myTask.doInBackground(url11);
                break;
            case 11:
                mediaPlayer=myTask.doInBackground(url12);
                break;
            case 12:
                mediaPlayer=myTask.doInBackground(url13);
                break;
            case 13:
                mediaPlayer=myTask.doInBackground(url14);
                break;
            case 14:
                mediaPlayer=myTask.doInBackground(url15);
                break;
            case 15:
                mediaPlayer=myTask.doInBackground(url16);
                break;
            case 16:
                mediaPlayer=myTask.doInBackground(url17);
                break;
            case 17:
                mediaPlayer=myTask.doInBackground(url18);
                break;
            case 18:
                mediaPlayer=myTask.doInBackground(url19);
                break;
            case 19:
                mediaPlayer=myTask.doInBackground(url20);
                break;
            case 20:
                mediaPlayer=myTask.doInBackground(url21);
                break;
            case 21:
                mediaPlayer=myTask.doInBackground(url22);
                break;
            case 22:
                mediaPlayer=myTask.doInBackground(url23);
                break;
            case 23:
                mediaPlayer=myTask.doInBackground(url24);
                break;
            case 24:
                mediaPlayer=myTask.doInBackground(url25);
                break;
            case 25:
                mediaPlayer=myTask.doInBackground(url26);
                break;
        }
        mediaPlayer.start();
    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            Main2Activity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0)
                        viewPager.setCurrentItem(1);
                    if (viewPager.getCurrentItem() == 1)
                        viewPager.setCurrentItem(2);
                    if (viewPager.getCurrentItem() == 2)
                        viewPager.setCurrentItem(3);
                    if (viewPager.getCurrentItem() == 3)
                        viewPager.setCurrentItem(4);
                    if (viewPager.getCurrentItem() == 4)
                        viewPager.setCurrentItem(5);
                    if (viewPager.getCurrentItem() == 5)
                        viewPager.setCurrentItem(6);
                    if (viewPager.getCurrentItem() == 6)
                        viewPager.setCurrentItem(7);
                    if (viewPager.getCurrentItem() == 8)
                        viewPager.setCurrentItem(9);
                    if (viewPager.getCurrentItem() == 9)
                        viewPager.setCurrentItem(10);
                    if (viewPager.getCurrentItem() == 10)
                        viewPager.setCurrentItem(11);
                    if (viewPager.getCurrentItem() == 11)
                        viewPager.setCurrentItem(12);
                    if (viewPager.getCurrentItem() == 12)
                        viewPager.setCurrentItem(13);
                    if (viewPager.getCurrentItem() == 13)
                        viewPager.setCurrentItem(14);
                    if (viewPager.getCurrentItem() == 14)
                        viewPager.setCurrentItem(15);
                    if (viewPager.getCurrentItem() == 15)
                        viewPager.setCurrentItem(16);
                    if (viewPager.getCurrentItem() == 16)
                        viewPager.setCurrentItem(17);
                    if (viewPager.getCurrentItem() == 18)
                        viewPager.setCurrentItem(19);
                    if (viewPager.getCurrentItem() == 19)
                        viewPager.setCurrentItem(20);
                    if (viewPager.getCurrentItem() == 20)
                        viewPager.setCurrentItem(21);
                    if (viewPager.getCurrentItem() == 21)
                        viewPager.setCurrentItem(22);
                    if (viewPager.getCurrentItem() == 22)
                        viewPager.setCurrentItem(23);
                    if (viewPager.getCurrentItem() == 23)
                        viewPager.setCurrentItem(24);
                    if (viewPager.getCurrentItem() == 24)
                        viewPager.setCurrentItem(24);
                    if (viewPager.getCurrentItem() == 25)
                        viewPager.setCurrentItem(0);

                }
            });
        }
    }

    public void sendRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, (JSONArray) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {

                    SliderUtils sliderUtils = new SliderUtils();
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        sliderUtils.setSliderImageUrl(jsonObject.getString("URL"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    sliderImg.add(sliderUtils);

                }

                Toast.makeText(getApplicationContext(),"Successs...",Toast.LENGTH_LONG).show();


                viewPagerAdapter = new ViewPagerAdapter(sliderImg, Main2Activity.this);
                viewPager.setAdapter(viewPagerAdapter);
                dotscount = viewPagerAdapter.getCount();
                dots = new ImageView[dotscount];
                for (int i = 0; i < dotscount; i++) {
                    dots[i] = new ImageView(Main2Activity.this);
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(8, 0, 8, 0);

                    sliderDotspanel.addView(dots[i], params);
                }
                dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

        }

                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error...",Toast.LENGTH_LONG).show();
            }
        });

        rq.add(jsonArrayRequest);
    }

}
