package com.example.welcome1.btp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class trainingwordpage extends AppCompatActivity {

    public TextToSpeech toSpeech;
    public TextView input;
    public Button audio_b;
    public Button next;
    public Button previous;
    public Button back;
    public Button remove_b;
    public SharedPreferences sharedpreferences ;
    public ArrayList<String> sentence_list,sentence_list1;
    public static final String MyPREFERENCES = "traininglevel1_demo";

    public SharedPreferences sharedpreferences1 ;
    public static final String MyPREFERENCES1 = "status_demo";

    public int index;
    public String temp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingwordpage);

        input = (TextView)findViewById(R.id.input_sentence);
        //input.setBackgroundColor(Color.YELLOW);


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

        sentence_list.add("cat");
        sentence_list.add("fat");
        sentence_list.add("hat");
        sentence_list.add("red");
        sentence_list.add("man");
        sentence_list.add("pig");
        sentence_list.add("dog");
        sentence_list.add("yes");
        sentence_list.add("you");
        sentence_list.add("and");
        sentence_list.add("bat");
        sentence_list.add("the");
        sentence_list.add("log");
        sentence_list.add("gets");
        sentence_list.add("bit");
        sentence_list.add("deal");
        sentence_list.add("mad");
        sentence_list.add("he");
        sentence_list.add("fed");
        sentence_list.add("bag");
        sentence_list.add("tip");
        sentence_list.add("gap");
        sentence_list.add("fill");
        sentence_list.add("big");
        sentence_list.add("hog");
        sentence_list.add("can");
        sentence_list.add("hole");
        sentence_list.add("dad");
        sentence_list.add("gas");
        sentence_list.add("gave");
        sentence_list.add("mat");
        sentence_list.add("snow");
        sentence_list.add("god");
        sentence_list.add("wish");
        sentence_list.add("ban");
        sentence_list.add("led");
        sentence_list.add("sees");
        sentence_list.add("map");
        sentence_list.add("make");
        sentence_list.add("way");
        sentence_list.add("rig");
        sentence_list.add("she");
        sentence_list.add("take");
        sentence_list.add("fan");
        sentence_list.add("note");
        sentence_list.add("bin");
        sentence_list.add("cap");
        sentence_list.add("pays");
        sentence_list.add("loan");
        sentence_list.add("fog");
        sentence_list.add("real");
        sentence_list.add("leg");
        sentence_list.add("cow");
        sentence_list.add("life");
        sentence_list.add("rat");
        sentence_list.add("car");
        sentence_list.add("bad");
        sentence_list.add("bid");
        sentence_list.add("dig");
        sentence_list.add("met");
        sentence_list.add("uses");
        sentence_list.add("art" );
        sentence_list.add("buys");
        sentence_list.add("wed");
        sentence_list.add("ran");


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

            //if (val!= null)
             //   y=1;

            if(val==null || val.equals(x.toString())){
                sentence_list1.add(str);
            }

            sentence_list=sentence_list1;

        }


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
    //end of oncreate


    public void click_audio_button(){

        audio_b = (Button)findViewById(R.id.audio_button);

        audio_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sentence_list.size()!=0) {
                    final String toSpeak = sentence_list.get(index).toString();
                    //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();

                    Integer i = 0;

                    for(i = 0; i<toSpeak.length(); i++) {
                        temp = toSpeak.substring(i,i+1);
                        toSpeech.speak(temp, TextToSpeech.QUEUE_FLUSH, null);

                        try {
                            synchronized(this){
                                wait(1000);
                            }
                        }
                        catch(InterruptedException ex){
                        }
                    }

                    toSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }

                else{
                    Toast.makeText(getApplicationContext(), "No more words left.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void delay(){
        Runnable r = new Runnable() {
            @Override
            public void run(){

            }
        };

        Handler h = new Handler();

        h.postDelayed(r, 1000);
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

                            sharedpreferences1 = getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedpreferences1.edit();
                            Integer x = 1;
                            editor1.putString("training1",x.toString());
                            editor1.apply();

                            input.setBackgroundColor(Color.YELLOW);
                            input.setText("Training over !!");


                        }

                        else if(sentence_list.size()==1) {

                            sentence_list.remove(index);

                            sharedpreferences1 = getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedpreferences1.edit();
                            Integer x = 1;
                            editor1.putString("training1",x.toString());
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
                            Toast.makeText(getApplicationContext(), "No more words left.", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(getApplicationContext(), "No more words left.", Toast.LENGTH_SHORT).show();
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
                        for (String str:sentence_list1
                                ) {
                            Integer val= 0;
                            if(!sentence_list.contains(str))
                                editor.putString(str,val.toString());

                            else{
                                Integer tp = 1;
                                editor.putString(str, tp.toString());
                            }

                        }

                        //editor.commit();
                        editor.apply();
                        finish();

                    }
                }
        );
    }
    //end of back button


}
//end of class