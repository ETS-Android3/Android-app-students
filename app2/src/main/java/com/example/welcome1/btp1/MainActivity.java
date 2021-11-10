package com.example.welcome1.btp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  LoginFragment.OnLoginFormActivityListener,WelcomeFragment.OnLogoutListener {

    //public Button login_button;
   // public EditText user;
   // public EditText pass;
    //public Button exit_button;
    //public TextView sign_up;
    public static Pref_Config pref_config;
    public static ApiInterface apiInterface;
    //public SharedPreferences sharedpreferences ;
    //public static final String MyPREFERENCES = "users_demo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref_config = new Pref_Config(this);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);


        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            if (pref_config.readLoginStatus()) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new WelcomeFragment()).commit();
            } else {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new LoginFragment()).commit();
            }

        }
    }

    @Override
    public void performRegister() {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegistrationFragment()).addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String name) {
       pref_config.writeName(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WelcomeFragment()).commit();
    }

    @Override
    public void logoutPerformed() {
        pref_config.writeLoginStatus(false);
        pref_config.writeName("User");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
    }
     /*   sign_up = (TextView)findViewById(R.id.create_account);
        sign_up.setTextColor(Color.BLUE);

        //SpannableString content = new SpannableString("New user ? Click here to sign up !!");
        //content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        //sign_up.setText(content);

        onclick_login_button();
        onclick_signup_button();
        //onclick_exit_button();
    }
    void database()
    {
        String usr=user.getText().toString();
        String pas=pass.getText().toString();
        String type="login";

        BackgroundWorker backgroundWorker= new BackgroundWorker(this);
        backgroundWorker.execute(type,usr,pas);
    }
    void onclick_login_button(){

        user = (EditText)findViewById(R.id.username_field);
        pass = (EditText)findViewById(R.id.password_field);



        login_button = (Button) findViewById(R.id.login);

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            database();


                        if(user.getText().toString().equals("user") && pass.getText().toString().equals("pass")){

                            Intent intent = new Intent("com.example.welcome1.btp1.homepage");
                            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(MainActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                        }



                        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();*/

                  /*      String user_str = user.getText().toString();


                        String val = sharedpreferences.getString(user_str,null);

                        if(val==null){
                            Toast.makeText(MainActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                        }

                        else{

                            String pass_str = pass.getText().toString();

                            if(pass_str.equals(val)){

                                Intent intent = new Intent("com.example.welcome1.btp1.homepage");
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                                startActivity(intent);

                            }

                            else{
                                Toast.makeText(MainActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                            }


                        }


                    }
                }

        );
    }

    void onclick_signup_button(){

        sign_up.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent("com.example.welcome1.btp1.newuser");
                startActivity(intent);
            }
        });

    }

*/
    /*
    void onclick_exit_button(){
        exit_button = (Button) findViewById(R.id.exit_button);
        exit_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Closing app..", Toast.LENGTH_LONG).show();
                        finish();

                    }
                }

        );
    }
    */




}
