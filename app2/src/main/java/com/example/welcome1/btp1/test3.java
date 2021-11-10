package com.example.welcome1.btp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;

public class test3 extends AppCompatActivity {

    public SharedPreferences sharedpreferences ;
    public static final String MyPREFERENCES = "testresults_demo";
    public Integer no_of_correct_answers;
    public Integer attempted;


    public SharedPreferences sharedpreferences1 ;
    public static final String MyPREFERENCES1 = "status_demo";


    private CanvasView canvasView;
    public Button skip_b;
    public Button exit_b;
    public Button submit_b;
    public Button audio_b;
    public TextToSpeech toSpeech, toSpeech_ob1;
    public ArrayList<String> word_list;
    public int word_index;
    public TextView textView;

    public String correct_answer;
    //public ArrayList<Pair<String,ArrayList<String>>> word_list;
    //public Integer index;
    public String type;
    public String input_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        toSpeech =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    //toSpeech.setLanguage(Locale.UK);
                    float f = 0.1f;
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

        no_of_correct_answers = 0;
        attempted = 0;

        canvasView = (CanvasView)findViewById(R.id.canvas);

        word_list = new ArrayList<String>();


        word_list.add("man@1");
        word_list.add("god@1");
        word_list.add("pay@1");
        word_list.add("mom@1");
        word_list.add("cow@1");
        word_list.add("car@2");
        word_list.add("gas@2");
        word_list.add("dog@2");
        word_list.add("cap@2");
        word_list.add("car@2");

        type = word_list.get(word_index).split("@")[1];

        input_string = word_list.get(word_index).toString().split("@")[0];
        if(type.equals("1")) {
            input_string = "__"+input_string.substring(1);
        }
        else {
            input_string = input_string.substring(0,input_string.length()-1)+"__";
        }


        textView = (TextView) findViewById(R.id.textView3);
        textView.setText(input_string);

        onclick_submit_button();
        onclick_exit_button();
        onclick_audio_button();



    }
    //oncreate ends

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

                            //editor.putString("test3_total",total.toString());
                            //editor.putString("test3_correct",no_of_correct_answers.toString());

                            editor.putString("test3_total",attempted.toString());
                            //editor.putString("test3_attempted",attempted.toString());

                            editor.apply();


                            sharedpreferences1 = getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedpreferences1.edit();
                            Integer x = 1;
                            editor1.putString("test3",x.toString());
                            editor1.apply();



                            toSpeech_ob1.speak("Test completed", TextToSpeech.QUEUE_FLUSH, null);
                            Toast.makeText(getApplicationContext(),"Test over !!! ",Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        else {
                            Toast.makeText(getApplicationContext(), "submitting result..", Toast.LENGTH_SHORT).show();
                            type = word_list.get(word_index).split("@")[1];

                            input_string = word_list.get(word_index).toString().split("@")[0];
                            if (type.equals("1")) {
                                input_string = "__" + input_string.substring(1);
                            } else {
                                input_string = input_string.substring(0, input_string.length() - 1) + "__";
                            }
                            textView = (TextView) findViewById(R.id.textView3);
                            textView.setText(input_string);

                        }


                    }
                }
        );
    }



    public void onclick_audio_button(){

        audio_b = (Button)findViewById(R.id.speak_button);

        audio_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String toSpeak = word_list.get(word_index).split("@")[0];
                //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                toSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }




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

                        //editor.putString("test3_total",total.toString());
                        //editor.putString("test3_correct",no_of_correct_answers.toString());

                        editor.putString("test3_total",attempted.toString());
                        //editor.putString("test3_attempted",attempted.toString());

                        editor.apply();

                        finish();

                    }
                }
        );
    }



}
