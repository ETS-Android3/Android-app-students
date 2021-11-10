package com.example.welcome1.btp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class homepage extends AppCompatActivity {
    public Button training1;
    public Button training2;
    public Button easy_level_button;
    public Button medium_level_button;
    public Button difficult_level_button;
    public Button ninja_level_button;


    public SharedPreferences sharedpreferences1 ;
    public static final String MyPREFERENCES1 = "status_demo";


    public Button help_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        onclickbutton();
        onclick_help_button();
        init();
    }
    public void init()
    {

        training1=(Button)findViewById(R.id.button);
        training1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.welcome1.btp1.Training1");
                        startActivity(intent);
                    }
                });
        training2=(Button)findViewById(R.id.button3);
        training2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(homepage.this,Training2.class);
                        startActivity(intent);
                    }
                });
    }


    public void onclick_help_button(){

        help_button = (Button)findViewById(R.id.help_button);

        help_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent("com.example.welcome1.btp1.helppage");
                        startActivity(intent);

                    }
                }

        );


    }

    public void onclickbutton(){





        easy_level_button = (Button)findViewById(R.id.easy_level);
        easy_level_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent("com.example.welcome1.btp1.levelpage");
                        //Create the bundle
                        Bundle bundle = new Bundle();

                        //Add your data to bundle
                        bundle.putString("level", "Easy");

                        //Add the bundle to the intent
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                }

        );

        medium_level_button = (Button)findViewById(R.id.medium_level);
        medium_level_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("easy",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Easy level to unlock this.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.levelpage");
                            //Create the bundle
                            Bundle bundle = new Bundle();

                            //Add your data to bundle
                            bundle.putString("level", "Medium");

                            //Add the bundle to the intent
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }

                    }
                }

        );

        difficult_level_button = (Button)findViewById(R.id.difficult_level);
        difficult_level_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("medium",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Medium level to unlock this.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.levelpage");
                            //Create the bundle
                            Bundle bundle = new Bundle();

                            //Add your data to bundle
                            bundle.putString("level", "Difficult");

                            //Add the bundle to the intent
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }

                    }
                }

        );

        ninja_level_button = (Button)findViewById(R.id.ninja_level);
        ninja_level_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        sharedpreferences1 =getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences1.edit();

                        String val = sharedpreferences1.getString("difficult",null);

                        if(val==null){

                            Toast.makeText(getApplicationContext(), "Complete Difficult level to unlock this.", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Intent intent = new Intent("com.example.welcome1.btp1.levelpage");
                            //Create the bundle
                            Bundle bundle = new Bundle();

                            //Add your data to bundle
                            bundle.putString("level", "Ninja");

                            //Add the bundle to the intent
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }

                    }
                }

        );

    }



}
