package com.example.welcome1.btp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.Header;
import org.json.JSONObject;

public class testpage extends AppCompatActivity {

    public SharedPreferences sharedpreferences ;
    public static final String MyPREFERENCES = "testresults_demo";
    public Integer no_of_correct_answers;
    public Integer attempted;


    public SharedPreferences sharedpreferences1 ;
    public static final String MyPREFERENCES1 = "status_demo";


    private CanvasView canvasView;
    //public Button skip_b;
    public Button exit_b;
    public Button submit_b;
    public Button audio_b;
    public TextToSpeech toSpeech, toSpeech_ob1;
    public ArrayList<String> word_list;
    public int word_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testpage);

        toSpeech =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    float f = 0.3f;
                    toSpeech.setLanguage(Locale.ENGLISH);
                    toSpeech.setSpeechRate(f);
                }
            }
        });

        toSpeech_ob1 =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    float f = 0.8f;
                    toSpeech_ob1.setLanguage(Locale.ENGLISH);
                    toSpeech_ob1.setSpeechRate(f);
                }
            }
        });


        canvasView = (CanvasView)findViewById(R.id.canvas);

        no_of_correct_answers = 0;
        attempted = 0;

        word_list = new ArrayList<String>();


        word_list.add("man");
        word_list.add("god");
        word_list.add("dog");
        word_list.add("cow");
        word_list.add("car");
        word_list.add("gas");
        word_list.add("tip");
        word_list.add("gas");
        word_list.add("map");
        word_list.add("life");

        word_index = 0;

        // button functions
        onclick_submit_button();
        //onclick_skip_button();
        onclick_exit_button();
        onclick_audio_button();

    }

    public void onclick_submit_button(){

        submit_b = (Button)findViewById(R.id.submit_button);

        submit_b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        attempted += 1;
                        word_index += 1;

                        canvasView.clearCanvas();

                        if(word_index == word_list.size()){

                            sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            Integer total = word_list.size();

                            //editor.putString("test4_total",total.toString());
                            //editor.putString("test4_correct",no_of_correct_answers.toString());

                            editor.putString("test4_total",attempted.toString());
                            //editor.putString("test4_attempted",attempted.toString());

                            editor.apply();


                            sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedpreferences1.edit();
                            Integer x = 1;
                            editor1.putString("test4",x.toString());
                            editor1.putString("easy",x.toString());
                            editor1.apply();





                            toSpeech_ob1.speak("Test completed", TextToSpeech.QUEUE_FLUSH, null);
                            Toast.makeText(getApplicationContext(),"Test over !! Medium level unlocked !! ",Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        else
                            Toast.makeText(getApplicationContext(),"submitting result..",Toast.LENGTH_SHORT).show();




                    }
                }
        );
    }





    public void onclick_audio_button(){

        audio_b = (Button)findViewById(R.id.speak_button);

        audio_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String toSpeak = word_list.get(word_index);
                //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                toSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }



    /*
    public void onclick_skip_button(){

        skip_b = (Button)findViewById(R.id.skip_button);

        skip_b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        word_index = (word_index + 1) % word_list.size();
                        Toast.makeText(getApplicationContext(),"Skipping current word..",Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }
    */



    public void clearCanvas(View v){

        canvasView.clearCanvas();
    }

    public static String encodeTobase64(Bitmap image)
    {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b,Base64.DEFAULT);
        return imageEncoded;
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }




    public void onclick_exit_button(){

        exit_b = (Button)findViewById(R.id.button2);

        exit_b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        Integer total = word_list.size();

                        //editor.putString("test4_total",total.toString());
                        //editor.putString("test4_correct",no_of_correct_answers.toString());

                        editor.putString("test4_total",attempted.toString());
                        //editor.putString("test4_attempted",attempted.toString());

                        editor.apply();

                        finish();

                    }
                }
        );
    }


}
