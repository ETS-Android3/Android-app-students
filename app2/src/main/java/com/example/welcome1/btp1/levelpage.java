package com.example.welcome1.btp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class levelpage extends AppCompatActivity {

    public TextView textView;
    public Button homepage;
    public Button trainingpage;
    public Button testpage;
    public Button resultpage;


    public SharedPreferences sharedpreferences1 ;
    public static final String MyPREFERENCES1 = "status_demo";


    public Button test1;
    public Button test2;
    public Button test3;
    public Button training1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelpage);
        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        String level_name = bundle.getString("level");
        textView = (TextView) findViewById(R.id.level_title);
        textView.setText("Level : " +level_name);

        onclick_homepage_button();
        onclick_trainingpage_button();
        onclick_testpage_button();
        onclick_resultpage_button();
        onclick_test1_button();
        onclick_test2_button();
        onclick_test3_button();
        onclick_training1_button();

    }

    void onclick_homepage_button(){

        homepage = (Button)findViewById(R.id.homepage_button);

        homepage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Intent intent = new Intent("com.example.welcome1.btp1.homepage");
                        //startActivity(intent);
                        finish();
                    }
                }
        );
    }


    void onclick_test1_button(){

        test1 = (Button)findViewById(R.id.match_word_button);

        test1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("training1",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Training 1 to unlock this level.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.test1");
                            startActivity(intent);
                        }

                    }
                }
        );
    }

    void onclick_test2_button(){

        test2 = (Button)findViewById(R.id.match_alphabet_button);

        test2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        sharedpreferences1 = getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("test1",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Test 1 to unlock this level.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.test2");
                            startActivity(intent);
                        }

                    }
                }
        );
    }

    void onclick_training1_button(){

        training1 = (Button)findViewById(R.id.training_word_button);

        training1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent("com.example.welcome1.btp1.trainingwordpage");
                        startActivity(intent);

                    }
                }
        );
    }


    void onclick_test3_button(){

        test3 = (Button)findViewById(R.id.fill_alphabet_button);

        test3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sharedpreferences1 = getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("test2",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Test 2 to unlock this level.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.test3");
                            startActivity(intent);
                        }

                    }
                }
        );
    }

    void onclick_trainingpage_button(){

        trainingpage = (Button)findViewById(R.id.training_button);

        trainingpage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sharedpreferences1 = getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("test3",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Test 3 to unlock this level.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.trainingpage");
                            startActivity(intent);
                        }
                    }
                }
        );
    }

    void onclick_testpage_button(){

        testpage = (Button)findViewById(R.id.testing_button);

        testpage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("training2",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Training 2 to unlock this level.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.testpage");
                            startActivity(intent);
                        }
                    }
                }
        );
    }

    void onclick_resultpage_button(){

        resultpage = (Button)findViewById(R.id.result_button);

        resultpage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent("com.example.welcome1.btp1.resultpage");
                        startActivity(intent);
                    }
                }
        );
    }
}
