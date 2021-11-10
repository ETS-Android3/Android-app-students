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

public class newuser extends AppCompatActivity {

    public Button create;
    public Button back;
    public TextView user;
    public TextView password;

    public SharedPreferences sharedpreferences ;
    public static final String MyPREFERENCES = "users_demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);

        onclick_back_button();
        onclick_create_button();

    }

    void onclick_back_button(){

        back = (Button)findViewById(R.id.back_button);

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //Intent intent = new Intent("com.example.welcome1.btp1.newuser");
                //startActivity(intent);
                finish();
            }
        });

    }

    void onclick_create_button(){

        create = (Button)findViewById(R.id.create_button);

        user = (TextView)findViewById(R.id.username);
        password = (TextView)findViewById(R.id.pass);

        create.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //Intent intent = new Intent("com.example.welcome1.btp1.newuser");
                //startActivity(intent);

                String user_str = user.getText().toString();
                String pass_str = password.getText().toString();

                /*

                Check if the username already exists..
                if so

                Toast.makeText(getApplicationContext(),"Username already taken. Try another one.",Toast.LENGTH_SHORT).show();

                else
                 */

                sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                String val = sharedpreferences.getString(user_str,null);

                if(val==null){

                    editor.putString(user_str,pass_str);

                    editor.apply();
                }

                else{

                    Toast.makeText(getApplicationContext(),"Username already taken. Try another one.",Toast.LENGTH_SHORT).show();
                }



                Toast.makeText(getApplicationContext(),"Account successfully created !!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }




}
