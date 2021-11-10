package com.example.welcome1.btp1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Locale;

public class trainingpage extends AppCompatActivity {

    public TextToSpeech toSpeech;
    public TextView input;
    public Button audio_b;
    public Button next;
    public Button previous;
    public Button back;
    public Button remove_b;
    public SharedPreferences sharedpreferences ;
    public ArrayList<String> sentence_list,sentence_list1;
    public static final String MyPREFERENCES = "traininglevel2_demo";
    public int index;

    public SharedPreferences sharedpreferences1 ;
    public static final String MyPREFERENCES1 = "status_demo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingpage);

        input = (TextView)findViewById(R.id.input_sentence);
        //input.setBackgroundColor(Color.YELLOW);

        //final Locale locale = new Locale("en", "IN");

        toSpeech =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    float f = 0.1f;
                    toSpeech.setLanguage(Locale.ENGLISH);
                    toSpeech.setSpeechRate(f);
                }
            }
        });

        sentence_list = new ArrayList<String>();

        sentence_list.add("Man gets deal");
        sentence_list.add("He gets tip");
        sentence_list.add("Dad gets gas");
        sentence_list.add("Gas gave snow");
        sentence_list.add("God wish man");
        sentence_list.add("Dog sees map");
        sentence_list.add("Mom pays loan");
        sentence_list.add("Tip gets real");
        sentence_list.add("Man runs dog");
        sentence_list.add("Dog gets leg");
        sentence_list.add("Cow saves life");
        sentence_list.add("Rat meets cat");
        sentence_list.add("Car uses gas");
        sentence_list.add("Man buys art");


        sentence_list1 = sentence_list;

        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        Integer x = 0;
        Integer st=1;
        int y=0;


        x = 1;

        ArrayList sentence_list1 = new ArrayList<String>();

        for (String str: sentence_list)
        {
            String val = sharedpreferences.getString(str,null);

            if(val==null || val.equals(x.toString())){
                sentence_list1.add(str);
            }

            sentence_list=sentence_list1;

        }

        //if(y==1)
            //Toast.makeText(getApplicationContext(), "not found",Toast.LENGTH_SHORT).show();

        index = 0;

        if(sentence_list.size()!=0)
            input.setText(sentence_list.get(index).toString());

        else{
            input.setBackgroundColor(Color.YELLOW);
            input.setText("Training over !!");
        }

        click_prev_button();
        click_next_button();
        click_back_button();
        click_remove_button();
        click_audio_button();

    }


    public void click_audio_button(){

        audio_b = (Button)findViewById(R.id.audio_button);

        audio_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sentence_list.size()!=0) {

                    String toSpeak = sentence_list.get(index).toString();
                    //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();

                    Integer i = 0;
                    Integer cur = 0;

                    String[] words = toSpeak.split(" ");

                    for (i = 0; i < words.length; i++) {



                        toSpeech.speak(words[i], TextToSpeech.QUEUE_FLUSH, null);

                        try {
                            synchronized (this) {

                                wait(1500);

                            }
                        }
                        catch (InterruptedException ex) {}


                        //str.setSpan(new BackgroundColorSpan(Color.BLACK), cur, cur + words[i].length(), 0);
                        //input.setText(str);

                        cur = cur + words[i].length() + 1;

                    }




                    //toSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }

                else{
                    Toast.makeText(getApplicationContext(), "No more sentences left.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



    public void click_remove_button(){

        remove_b = (Button)findViewById(R.id.sentence_button);
        remove_b.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

//                      SharedPreferences.Editor editor1 = sharedpreferences.edit();

                        Integer x1 = 0;

                        if(sentence_list.size()==0){

                            sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedpreferences1.edit();
                            Integer x = 1;
                            editor1.putString("training2",x.toString());
                            editor1.apply();

                            input.setBackgroundColor(Color.YELLOW);
                            input.setText("Training over !!");

                        }

                        else if(sentence_list.size()==1) {

                            sentence_list.remove(index);

                            sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedpreferences1.edit();
                            Integer x = 1;
                            editor1.putString("training2",x.toString());
                            editor1.apply();

                            input.setText("Training over !!");
                            input.setBackgroundColor(Color.YELLOW);
                        }

                        else{

//                          editor1.putString(sentence_list.get(index).toString(), x1.toString());
//                          editor1.commit();
                            sentence_list.remove(index);

                            index = index % sentence_list.size();
                            input.setText(sentence_list.get(index));
                        }

                    }
                }
        );
    }


    public void click_prev_button(){

        previous = (Button)findViewById(R.id.previous_button);

        previous.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(sentence_list.size()!=0) {
                            index = (index + sentence_list.size() - 1) % sentence_list.size();
                            input.setText(sentence_list.get(index));
                        }

                        else{
                            Toast.makeText(getApplicationContext(), "No more sentences left.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }


    public void click_next_button(){

        next = (Button)findViewById(R.id.next_button);

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(sentence_list.size()!=0) {
                            index = (index + 1) % sentence_list.size();
                            input.setText(sentence_list.get(index));

                        }

                        else{
                            Toast.makeText(getApplicationContext(), "No more sentences left.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }


    public void click_back_button(){

        back = (Button)findViewById(R.id.back_button);

        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        for (String str:sentence_list1){

                            Integer val= 0;
                            if(!sentence_list.contains(str))
                                editor.putString(str,val.toString());

                            else {

                                Integer tp = 1;
                                editor.putString(str,tp.toString());
                            }


                        }

                        //editor.commit();
                        editor.apply();
                        finish();

                    }
                }
        );
    }



}
