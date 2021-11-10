package com.example.welcome1.btp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class test1 extends AppCompatActivity {

    public SharedPreferences sharedpreferences ;
    public static final String MyPREFERENCES = "testresults_demo";

    public SharedPreferences sharedpreferences1 ;
    public static final String MyPREFERENCES1 = "status_demo";


    public Button audio_button1;
    public Button next_button;

    public Button option1;
    public Button option2;
    public Button option3;
    public Button option4;

    public TextToSpeech toSpeech_ob;
    public TextToSpeech toSpeech_ob1;

    public String correct_answer;
    public ArrayList<Pair<String,ArrayList<String>>> word_list;

    public Integer index;
    public Integer no_of_correct_answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        toSpeech_ob =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    float f = 0.1f;
                    toSpeech_ob.setLanguage(Locale.ENGLISH);
                    toSpeech_ob.setSpeechRate(f);
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




        ArrayList<String> option_list1 = new ArrayList<>(Arrays.asList("fat", "hat","bat","cat"));
        ArrayList<String> option_list2 = new ArrayList<>(Arrays.asList("dog", "fog","log","hog"));
        ArrayList<String> option_list3 = new ArrayList<>(Arrays.asList("red", "wed","fed","bed"));
        ArrayList<String> option_list4 = new ArrayList<>(Arrays.asList("dig", "pig","rig","big"));
        ArrayList<String> option_list5 = new ArrayList<>(Arrays.asList("man", "can","fan","ran"));
        ArrayList<String> option_list6 = new ArrayList<>(Arrays.asList("cat", "can","cap","car"));
        ArrayList<String> option_list7 = new ArrayList<>(Arrays.asList("man", "mad","mat","map"));
        ArrayList<String> option_list8 = new ArrayList<>(Arrays.asList("bat", "bag","bad","ban"));
        ArrayList<String> option_list9 = new ArrayList<>(Arrays.asList("big", "bid","bit","bin"));
        ArrayList<String> option_list10 = new ArrayList<>(Arrays.asList("cow", "cop","con","cot"));



        Pair<String,ArrayList<String>> pair1 =  new Pair<>("cat",option_list1);
        Pair<String,ArrayList<String>> pair2 =  new Pair<>("dog",option_list2);
        Pair<String,ArrayList<String>> pair3 =  new Pair<>("bed",option_list3);
        Pair<String,ArrayList<String>> pair4 =  new Pair<>("pig",option_list4);
        Pair<String,ArrayList<String>> pair5 =  new Pair<>("man",option_list5);
        Pair<String,ArrayList<String>> pair6 =  new Pair<>("car",option_list6);
        Pair<String,ArrayList<String>> pair7 =  new Pair<>("map",option_list7);
        Pair<String,ArrayList<String>> pair8 =  new Pair<>("bad",option_list8);
        Pair<String,ArrayList<String>> pair9 =  new Pair<>("bin",option_list9);
        Pair<String,ArrayList<String>> pair10 =  new Pair<>("cow",option_list10);



        index = 0;
        no_of_correct_answers = 0;

        word_list = new ArrayList<Pair<String,ArrayList<String>>>();
        word_list.add(pair1);
        word_list.add(pair2);
        word_list.add(pair3);
        word_list.add(pair4);
        word_list.add(pair5);
        word_list.add(pair6);
        word_list.add(pair7);
        word_list.add(pair8);
        word_list.add(pair9);
        word_list.add(pair10);

        ArrayList<String> options = word_list.get(index).second;
        option1=(Button)findViewById(R.id.option1);
        option1.setText(options.get(0).toString());
        option2=(Button)findViewById(R.id.option2);
        option2.setText(options.get(1).toString());
        option3=(Button)findViewById(R.id.option3);
        option3.setText(options.get(2).toString());
        option4=(Button)findViewById(R.id.option4);
        option4.setText(options.get(3).toString());

        correct_answer = word_list.get(index).first.toString();

        onclick_next_button();
        onclick_audio_button();

    }
    //end of oncreate


    void onclick_audio_button(){

        audio_button1 = (Button)findViewById(R.id.audio_button1);

        audio_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String toSpeak = word_list.get(index).first.toString();
                    //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                    toSpeech_ob.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


            }
        });


    }


    public void onclick_opt_button(View view){

        option1 = (Button)findViewById(R.id.option1);
        option2 = (Button)findViewById(R.id.option2);
        option3 = (Button)findViewById(R.id.option3);
        option4 = (Button)findViewById(R.id.option4);

        String op1  = option1.getText().toString();
        String op2  = option2.getText().toString();
        String op3  = option3.getText().toString();
        String op4  = option4.getText().toString();


        if(op1.equals(correct_answer))
            option1.setBackgroundColor(Color.GREEN);

        else if(op2.equals(correct_answer))
            option2.setBackgroundColor(Color.GREEN);

        else if(op3.equals(correct_answer))
            option3.setBackgroundColor(Color.GREEN);

        else if(op4.equals(correct_answer))
            option4.setBackgroundColor(Color.GREEN);

        Button click_b = (Button) findViewById(view.getId());
        String text = click_b.getText().toString();

        if(!text.equals(correct_answer)) {
            click_b.setBackgroundColor(Color.RED);
            toSpeech_ob1.speak("Wrong answer", TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(getApplicationContext(),"Wrong answer !!!",Toast.LENGTH_SHORT).show();
        }

        else {

            no_of_correct_answers += 1;
            toSpeech_ob1.speak("Correct answer", TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(getApplicationContext(), "Correct answer !!!", Toast.LENGTH_SHORT).show();
        }


        next_button.setEnabled(true);
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);



    }

    void onclick_next_button(){

        next_button = (Button)findViewById(R.id.next_button);

        next_button.setEnabled(false);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                index = index + 1;
                if(index == word_list.size()){

                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    Integer total = word_list.size();

                    editor.putString("test1_total",total.toString());
                    editor.putString("test1_correct",no_of_correct_answers.toString());

                    editor.apply();


                    sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedpreferences1.edit();
                    Integer x = 1;
                    editor1.putString("test1",x.toString());
                    editor1.apply();



                    toSpeech_ob1.speak("Test completed", TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(getApplicationContext(),"Test over !!! ",Toast.LENGTH_SHORT).show();

                    finish();
                }


                else{
                    //Toast.makeText(getApplicationContext(),index.toString(),Toast.LENGTH_SHORT).show();
                    ArrayList<String> options = word_list.get(index).second;
                    //Toast.makeText(getApplicationContext(),options.get(index).toString(),Toast.LENGTH_SHORT).show();
                    option1 = (Button) findViewById(R.id.option1);
                    option1.setText(options.get(0).toString());
                    option2 = (Button) findViewById(R.id.option2);
                    option2.setText(options.get(1).toString());
                    option3 = (Button) findViewById(R.id.option3);
                    option3.setText(options.get(2).toString());
                    option4 = (Button) findViewById(R.id.option4);
                    option4.setText(options.get(3).toString());


                    correct_answer = word_list.get(index).first.toString();

                    option1.setBackgroundColor(Color.parseColor("#b0e0e6"));
                    option2.setBackgroundColor(Color.parseColor("#b0e0e6"));
                    option3.setBackgroundColor(Color.parseColor("#b0e0e6"));
                    option4.setBackgroundColor(Color.parseColor("#b0e0e6"));

                    next_button.setEnabled(false);
                    option1.setEnabled(true);
                    option2.setEnabled(true);
                    option3.setEnabled(true);
                    option4.setEnabled(true);


                }


            }
        });


    }
    //end of next button




}
// end of the class

